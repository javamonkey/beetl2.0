package org.beetl.ext.fn;

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.JsonFactory;

/**
 * 使用jackson或者fastjson 序列化对对象
 */
public class Json implements Function
{

	@Override
	public String call(Object[] paras, Context ctx)
	{
		Object o = paras[0];
		if(o==null){
			return "";
		}
		String msg = JsonFactory.get().render(o);
		return msg;

	}



}
