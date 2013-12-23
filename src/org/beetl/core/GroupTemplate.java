package org.beetl.core;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.exception.TempException;
import org.beetl.core.statement.Program;

public class GroupTemplate {

	/* 模板在运行过程中,class方法，accessory调用等需要的classLoader */
	ClassLoader classLoader = null;
	ResourceLoader resourceLoader = null;
	Configuration conf = null;
	TemplateEngine engine = null;
	Map<String, Program> programCache = new HashMap<String, Program>();

	/**
	 * 使用loader 和 conf初始化GroupTempalte
	 * 
	 * @param loader
	 *            资源加载器
	 * @param conf
	 *            模板引擎配置
	 */

	public GroupTemplate(ResourceLoader loader, Configuration conf) {
		this.resourceLoader = loader;
		this.conf = conf;
		engine = TemplateEngineFactory.getEngine();
	}

	/**
	 * 使用loader 和 默认的模板引擎配置来初始化GroupTempalte
	 * 
	 * @param loader
	 *            资源加载器
	 * 
	 */

	protected void setClassLoader(ClassLoader classLoader) {

	}

	public Template getTemplate(String key) {
		key = key.intern();
		Program program = this.programCache.get(key);
		if (program == null) {
			synchronized (key) {
				if (program == null) {
					Resource resource = resourceLoader.getResource(key);
					program = this.loadTemplate(resource);
					this.programCache.put(key, program);
				}
			}
		}

		return new Template(program, this.conf);

	}

	private Program loadTemplate(Resource res) {
		Reader reader = res.openReader();
		Transformator sf = new Transformator(conf.placeholderStart,
				conf.placeholderEnd, conf.statementStart, conf.statementEnd);
		Reader scriptReader;
		try {
			scriptReader = sf.transform(reader);

		} catch (HTMLTagParserException e) {
			throw new TempException(e.getMessage());
		} catch (IOException e) {
			throw new TempException(e.getMessage());
		}

		Program program = engine.createProgram(scriptReader);
		program.metaData.staticTextArray = new Object[sf.textMap.size()];
		int i = 0;

		for (Entry<String, String> entry : sf.textMap.entrySet()) {
			if (conf.directByteOutput) {
				try {
					program.metaData.staticTextArray[i++] = entry.getValue()
							.getBytes(conf.charset);
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			} else {

				program.metaData.staticTextArray[i++] = entry.getValue()
						.toCharArray();
			}

		}

		return program;

	}

	/**
	 * 关闭GroupTemplate，清理所有的资源
	 */
	public void close() {

	}

	// /** 为事件类型注册一个监听器
	// * @param type
	// * @param e
	// */
	// public void onEvent(int type,Listener e){
	//
	// }

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	/**
	 * 判断是否有事件对应的监听器，用于不必要的构造事件对象
	 * 
	 * @param eventType
	 * @return
	 */
	public boolean hasListener(int eventType) {
		return false;
	}

}
