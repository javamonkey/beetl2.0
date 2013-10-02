package org.beetl.core;


public class GroupTemplate {
	
	/*模板在运行过程中,class方法，accessory调用等需要的classLoader*/
	ClassLoader classLoader = null;
	ResourceLoader resourceLoader = null;
	Configuration conf = null;
	
	
	/** 使用loader 和 conf初始化GroupTempalte
	 * @param loader 资源加载器
	 * @param conf  模板引擎配置
	 */
	
	protected GroupTemplate(ResourceLoader loader,Configuration conf){
		
	}
	/** 使用loader 和 默认的模板引擎配置来初始化GroupTempalte
	 * @param loader 资源加载器
	 * 
	 */
	

	
	protected void setClassLoader(ClassLoader classLoader){
		
	}

	
	public Template getTemplate(String key){
		return null;
	}
	
	/**
	 * 配置GroupTemplate后，必须调用此方法通知GroupTemplate，准备好
	 */
	public void ready(){
		
	}
	
	/**
	 * 关闭GroupTemplate，清理所有的资源
	 */
	public void close(){
		
	}
	
	/** 为事件类型注册一个监听器
	 * @param type
	 * @param e
	 */
	public void onEvent(int type,Listener e){
		
	}
	
	/**通知一个事件发生
	 * @param e
	 */
	public void fireEvent(Event e){
		
	}
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
	
	/**判断是否有事件对应的监听器，用于不必要的构造事件对象
	 * @param eventType
	 * @return
	 */
	public boolean hasListener(int eventType){
		return false;
	}
	

	
	
	
	
}
