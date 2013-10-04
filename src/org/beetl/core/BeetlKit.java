package org.beetl.core;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 *  beetl小工具,加载classpath下的beetl.properties 来配置模板引擎，通常用于测试，或者
 *  性能要求不高的场景
 *   * @author joelli
 *
 */
public class BeetlKit {
	
	/** 使用默认配置，调用此方法可以改变模板配置
	 * @param conf
	 */
	public static void setConfiguration(Configuration conf){
		
	}
	
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
	
	public static Map execute(String script,Map<String,Object> paras){
		return null;
	}
	
	public static Map execute(Reader script,Map<String,Object> paras){
		return null;
	}
	
	public static Map execute(Reader script,Map<String,Object> paras,StringBuilder console){
		return null;
	}
	
	
	
	
	/*模板自测试部分*/
	
	
	/**
	 * @param template 模板内容
	 * @param initValue 模板初始化值
	 * @param console 模板的输出
	 * @return 模板渲染结果
	 */
	public static String testTemplate(String template,String initValue,StringWriter console){
		return null;
	}
	
	
}
