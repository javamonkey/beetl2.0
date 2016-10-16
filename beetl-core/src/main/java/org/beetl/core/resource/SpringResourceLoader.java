package org.beetl.core.resource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.fun.FileFunctionWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.FileSystemResource;

/**
 * 基于Spring Resource API语法的Beetl ResourceLoader实现<br>
 * <strong>本资源加载器应作为Spring Bean创建，注入org.beetl.ext.spring.BeetlGroupUtilConfiguration使用</strong><br>
 *
 * @author Chen Rui
 */
public class SpringResourceLoader implements ResourceLoader, ApplicationContextAware {
	/**
	 * 日志器
	 */
	private static final Log LOG = LogFactory.getLog(SpringResourceLoader.class);

	/**
	 * 是否检测资源变化
	 */
	public static final boolean DEFAULT_AUTOCHECK = false;

	/**
	 * Spring应用程序上下文
	 */
	private ApplicationContext applicationContext = null;
	/**
	 * 资源文件字符编码，默认取上下文默认编码
	 */
	private String charset = Charset.defaultCharset().name();

	/**
	 * 资源前缀名，仅对以/开头的资源id有效
	 */
	private String prefix = "";

	/**
	 * 资源后缀名
	 */
	private String suffix = "";

	/**
	 * 是否检测资源变化
	 */
	private Boolean autoCheck = null;

	/**
	 * 函数定义文件目录
	 */
	private String functionRootResource = null;
	/**
	 * 函数定义文件后缀名
	 */
	private String functionSuffix = null;

	/**
	 * 资源文件字符编码，默认取上下文默认编码
	 *
	 * @return 资源文件字符编码，默认取上下文默认编码
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 资源文件字符编码，默认取上下文默认编码
	 *
	 * @param charset
	 *            资源文件字符编码，默认取上下文默认编码
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * Spring应用程序上下文
	 *
	 * @param applicationContext
	 *            Spring应用程序上下文
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * 函数定义文件目录，默认为classpath下functions目录
	 *
	 * @param functionRootResource
	 *            函数定义文件目录，默认为classpath下functions目录
	 */
	public void setFunctionRootResource(String functionRootResource) {
		this.functionRootResource = functionRootResource;
	}

	/**
	 * 函数定义文件后缀名，默认fn
	 *
	 * @param functionSuffix
	 *            函数定义文件后缀名，默认fn
	 */
	public void setFunctionSuffix(String functionSuffix) {
		this.functionSuffix = ".".concat(functionSuffix);
	}

	/**
	 * 设置是否检测资源变化
	 *
	 * @param autocheck
	 *            是否检测资源变化
	 */
	public void setAutoCheck(boolean autoCheck) {
		this.autoCheck = autoCheck;
	}

	/**
	 * 资源前缀名，仅对以/开头的资源id有效
	 *
	 * @param prefix
	 *            资源前缀名，仅对以/开头的资源id有效
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * 资源后缀名
	 *
	 * @param suffix
	 *            资源后缀名
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * 资源初始化
	 *
	 * @param groupTemplate
	 *            Beetl GroupTemplate
	 */
	@Override
	public void init(GroupTemplate groupTemplate) {
		Map<String, String> resourceMap = groupTemplate.getConf().getResourceMap();

		if (autoCheck == null) {
			autoCheck = "true".equals(resourceMap.get("autoCheck"));
		}
		if (functionRootResource == null) {
			functionRootResource = resourceMap.get("functionRoot");
		}
		if (functionSuffix == null) {
			setFunctionSuffix(resourceMap.get("functionSuffix"));
		}

		// 加载函数定义文件
		try {
			org.springframework.core.io.Resource rootResource = applicationContext.getResource(functionRootResource);
			if (rootResource.exists()) {
				readFuntionFile(rootResource.getFile(), "", groupTemplate);
			}
		} catch (IOException e) {
			SpringResourceLoader.LOG.debug("Access Function File Resource IO Error!", e);
		}
	}

	/**
	 * 加载函数定义文件<br>
	 * <strong>仿照Beetl的实现</strong>
	 *
	 * @param searchRoot
	 *            搜索根路径
	 * @param ns
	 *            命名空间
	 * @param searchResource
	 *            搜索资源名
	 * @param groupTemplate
	 *            Beetl GroupTemplate
	 */
	protected void readFuntionFile(File searchRoot, String ns, GroupTemplate groupTemplate) throws IOException {
		for (File file : searchRoot.listFiles()) {
			String fileName = file.getName();
			String resourceId = getRealPath(new FileSystemResource(file), fileName);

			if (file.isDirectory()) {
				readFuntionFile(file, fileName.concat("."), groupTemplate);
			} else if (fileName.endsWith(functionSuffix)) {
				groupTemplate.registerFunction(ns.concat(fileName.substring(0, fileName.length() - functionSuffix.length())),
						new FileFunctionWrapper(resourceId));
			}
		}
	}

	/**
	 * 资源关闭
	 */
	@Override
	public void close() {
		// Do Thing
	}

	/**
	 * 指定资源是否存在
	 *
	 * @param key
	 *            指定资源key
	 * @return 指定资源是否存在
	 */
	@Override
	public boolean exist(String key) {
		try {
			org.springframework.core.io.Resource resource = createResource(key);
			// 资源存在且可读
			return (resource != null) && resource.exists() && resource.isReadable();
		} catch (Exception e) {
			SpringResourceLoader.LOG.debug("Access Resource IO Error!", e);
			// 出现IO异常，返回false
			return false;
		}
	}

	/**
	 * 返回指定key的Beetl资源对象
	 *
	 * @param key
	 *            指定资源key
	 * @return 指定职员是否存在
	 */
	@Override
	public Resource getResource(String key) {
		return new SpringResource(key, this);
	}

	/**
	 * 获取相对资源路径
	 *
	 * @param resource
	 *            当前资源
	 * @param key
	 *            相对资源key
	 * @return 相对资源路径
	 */
	@Override
	public String getResourceId(Resource resource, String key) {
		// 相对路径以/开头表示绝对路径
		if ((resource == null) || key.startsWith("/")) {
			return key;
		} else {
			try {
				return getRealPath(((SpringResource) resource).resource, key);
			} catch (IOException e) {
				SpringResourceLoader.LOG.debug("Access Resource IO Error!", e);
				return key.startsWith("/") ? key.substring(1) : key;
			}
		}
	}

	/**
	 * 测试资源是否有修改
	 *
	 * @param resource
	 *            Beetl资源对象
	 * @return Beetl资源
	 */
	@Override
	public boolean isModified(Resource resource) {
		if (autoCheck && (resource != null)) {
			return resource.isModified();
		}
		return false;
	}

	/**
	 * 根据资源id创建Spring Resource实例
	 *
	 * @param id
	 *            资源id
	 * @return 根据职员id创建资源key
	 * @throws IOException
	 */
	public org.springframework.core.io.Resource createResource(String id) throws IOException {
		// 添加后缀
		return applicationContext.getResource((id.startsWith("/") ? prefix : "").concat(id).concat(id.endsWith(functionSuffix) ? "" : suffix));
	}

	/**
	 * 相对资源key计算
	 *
	 * @param base
	 *            基础资源
	 * @param key
	 *            相对资源key
	 * @return 计算结果
	 * @throws IOException
	 *             相对计算出错
	 */
	private String getRealPath(org.springframework.core.io.Resource base, String key) throws IOException {
		return base.createRelative(key).getURI().toString();
	}

	/**
	 * 创建资源加载异常
	 *
	 * @param resourceId
	 *            资源id
	 * @param e
	 *            底层异常
	 * @return 异常对象
	 */
	public static BeetlException createTemplateLoadError(String resourceId, Throwable e) {
		BeetlException beetlException = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR, e);
		beetlException.resourceId = resourceId;
		return beetlException;
	}

	/**
	 * 创建资源加载异常
	 *
	 * @param resourceId
	 *            资源id
	 * @return 异常对象
	 */
	public static BeetlException createTemplateLoadError(String resourceId) {
		BeetlException beetlException = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR);
		beetlException.resourceId = resourceId;
		return beetlException;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
