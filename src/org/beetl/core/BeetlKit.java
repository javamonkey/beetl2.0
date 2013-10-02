package org.beetl.core;

import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/**
 *  beetl小工具,加载classpath下的beetl.properties 来配置模板引擎，通常用于测试，或者
 *  性能要求不高的场景
 *   * @author joelli
 *
 */
public class BeetlKit {
	
	/*模板部分*/
	
	
	public static String render(String template,Map<String,Object> paras){
		return null;
	}
	
	public static String render(Reader reader,Map<String,Object> paras){
		return null;
	}
	
	public static void renderTo(Reader reader,Writer writer,Map<String,Object> paras){
		
	}
	
	public static void renderTo(String template,Writer writer,Map<String,Object> paras){
		
	}
	
	/*脚本部分*/
	
	public Map execute(String script,Map<String,Object> paras){
		return null;
	}
	
	public Map execute(Reader script,Map<String,Object> paras){
		return null;
	}
	
	public Map execute(Reader script,Map<String,Object> paras,StringBuilder console){
		return null;
	}
}
