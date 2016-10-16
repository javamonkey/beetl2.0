package org.beetl.core.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.core.Resource;

/**
 * 基于Spring Resource API语法的Beetl Resource实现
 *
 * @author Chen Rui
 */
public class SpringResource extends Resource {
	/**
	 * 日志器
	 */
	private static final Log LOG = LogFactory.getLog(SpringResourceLoader.class);

	/**
	 * lastModified字段特殊值, 表示Resource API不支持检测文件修改
	 */
	public static final long UNSUPPORT_MODIFIED_CHECK = -1;
	/**
	 * 资源对应的内部Spring Resource实例
	 */
	org.springframework.core.io.Resource resource = null;
	/**
	 * 资源保存的模版信息修改时间
	 */
	private long lastModified = SpringResource.UNSUPPORT_MODIFIED_CHECK;

	/**
	 * 基于Spring Resource API语法的Beetl Resource实现
	 *
	 * @param id
	 *            资源id
	 * @param loader
	 *            资源加载器
	 * @param resource
	 *            对应的Spring Resource实例
	 */
	public SpringResource(String id, SpringResourceLoader loader) {
		super(id, loader);
	}

	/**
	 * 资源是否发生改变
	 *
	 * @return 资源是否发生改变
	 */
	@Override
	public boolean isModified() {
		// 无法获取资源修改时间，统一返回false
		if ((resource != null) && (lastModified != SpringResource.UNSUPPORT_MODIFIED_CHECK)) {
			// 获取当前资源修改时间
			long fileLastModified = SpringResource.getLastModified(resource);
			if (fileLastModified == SpringResource.UNSUPPORT_MODIFIED_CHECK) {
				// 无法获取当前资源修改时间，返回false
				lastModified = SpringResource.UNSUPPORT_MODIFIED_CHECK;
				return false;
			} else {
				// 资源发生变动，返回true
				return fileLastModified != lastModified;
			}
		} else {
			return false;
		}
	}

	/**
	 * 打开资源Reader
	 *
	 * @return 资源Reader
	 */
	@Override
	public Reader openReader() {
		try {
			SpringResourceLoader resourceLoader = (SpringResourceLoader) this.resourceLoader;
			resource = resourceLoader.createResource(id);
			if (resource != null) {
				Reader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), resourceLoader.getCharset()));
				lastModified = SpringResource.getLastModified(resource);
				return reader;
			} else {
				throw SpringResourceLoader.createTemplateLoadError(id);
			}
		} catch (IOException e) {
			SpringResource.LOG.debug("Access Resource IO Error!", e);
			throw SpringResourceLoader.createTemplateLoadError(id, e);
		}
	}

	/**
	 * 从Resource API中获取模版变更时间, 如果Resource API无法转换到文件系统，统一返回UNSUPPORT_MODIFIED_CHECK
	 *
	 * @param resource
	 *            Spring Resource对象
	 * @return 从Resource API中获取模版变更时间, 如果Resource API无法转换到文件系统，统一返回UNSUPPORT_MODIFIED_CHECK
	 */
	private static long getLastModified(org.springframework.core.io.Resource resource) {
		try {
			File file = resource.getFile();
			if (file != null) {
				return file.lastModified();
			} else {
				return SpringResource.UNSUPPORT_MODIFIED_CHECK;
			}
		} catch (IOException e) {
			SpringResource.LOG.debug("Access Resource IO Error!", e);
			return SpringResource.UNSUPPORT_MODIFIED_CHECK;
		}

	}

	/**
	 * 返回资源信息
	 *
	 * @return 资源信息
	 */
	public String display() {
		return "{resourceId: ".concat(id).concat(", resourceType:").concat(resource.getClass().getSimpleName()).concat("}");
	}
}
