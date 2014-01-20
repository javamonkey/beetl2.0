package org.beetl.core;

import java.io.Reader;

public abstract class Resource {

	ResourceLoader resourceLoader = null;

	/**
	 * 打开Reader
	 * 
	 * @return
	 */
	public abstract Reader openReader();

	/**
	 * 得到Resource指定行数的内容，用于调试，报错等显示原有模板信息,如果获取不了 返回NUll
	 * 
	 * @param startLine
	 * @param endLine
	 * @return
	 */
	public abstract String getContent(int startLine, int endLine);

	/**
	 * 检测资源是否改变
	 * 
	 * @return
	 */
	public abstract boolean isModified();

	/**
	 * 得到Resource对应的ResourceLoader
	 * 
	 * @return
	 */
	public ResourceLoader getResourceLoader() {
		return this.resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public abstract String getId();
}
