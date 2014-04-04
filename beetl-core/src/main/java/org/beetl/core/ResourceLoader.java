package org.beetl.core;

/**
 * ResourceLoader 负责根据GroupTemplate提供的Key,来获取Resource，这些Resource可以是文件，
 * 加密的文本，以及数据库Blob字段等
 * 
 * @author joelli
 * 
 * 
 */
public interface ResourceLoader
{

	/**
	 * 根据key获取Resource
	 * 
	 * @param key
	 * @return
	 */
	public Resource getResource(String key);

	public boolean isModified(Resource key);

	/**
	 * 关闭ResouceLoader，通常是GroupTemplate关闭的时候也关闭对应的ResourceLoader
	 */
	public void close();

}
