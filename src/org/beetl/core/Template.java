package org.beetl.core;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

import org.beetl.core.exception.BeetlException;

public interface Template {
	
	/** 获取模板输出的文本，结果是一个String
	 * @return
	 * @throws BeetlException
	 */
	public String getText() throws BeetlException;
	
	/** 获取模板输出的文本,输出到Writer里
	 * @param w
	 * @throws BeetlException
	 */
	public void getText(Writer writer)throws BeetlException;
	
	/**获取模板输出的文本,输出到OutputStream里,tempalte必须在二进制输出模式下才能使用
	 * @param os
	 * @throws BeetlException
	 */
	public void getText(OutputStream os) throws BeetlException;
	

	
	/** 为模板绑定变量，此变量在模板编译的时候,根据infer标记来决定是否要推测期类型，如果infer为true，
	 * 则表示模板引擎优化需要推测其类型，默认总是true，如果为false，则认为:
	 * 因为变量可能能对应不同java类型，
	 * 或者变量是容器，但容器里的元素是不同类型
	 * @param varName
	 * @param o
	 */
	public void binding(String varName, Object o,boolean infer);
	
	
	
	/** 为模板绑定一个变量，infer是true
	 * @param varName 变量名称，必须符合jaavascript 命名规范
	 * @param o 模板变量
	 */
	public void binding(String varName,Object o);
	
	
	
	/**为模板绑定多个变量，map的key，value对应了变量名称和变量值。key必须符合javascript命名规范
	 * @param map
	 */
	public void binding(Map map);
	
	
	
}
