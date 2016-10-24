package org.beetl.ext.fn;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.misc.ClassSearch;

/** 
 * 返回对象simple name，原始类型都会转成对应的封装类的类型
 * type.name(1)
 * @author xiandafu
 *
 */
public class TypeNameFunction implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		Object key = (Object)paras[0];
		return key==null?null:key.getClass().getSimpleName();
		
	}

}
