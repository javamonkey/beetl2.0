package org.beetl.core;

/**事件类型，beetl模板渲染生命周期里的各种事件
 * @author joelli
 *
 */
public class EventType {
	/**
	 * 模板解析结束事件，模板解析结果将传个相应的Listener
	 */
	public final int 	SCRIPT_PARSE_END  = 0;
	
	
	
	/**
	 * 模板开始运行事件
	 */
	public final int 	SCRIPT_EXECUTE_START  = 1;
	
	/**
	 * 模板运行结束事件，模板运行结果将传给相应的Listener
	 */
	public final int 	SCRIPT_EXECUTE_END  = 2;
	
}
