package org.beetl.core.util;

import java.lang.reflect.Method;

import org.beetl.core.exception.TempException;

/**
 * 对General Get不做性能优化
 * @author joelli
 *
 */
public class GeneralGetAttributeAccessor implements AttributeAccessor {
	
	
	@Override
	public Object getAttribute(Object o, int index,String name) {
		try{
			Method m = o.getClass().getMethod("get", new Class[]{String.class});
			Object value = m.invoke(o, name);
			return value;
		}catch(Exception ex){
			throw new TempException("属性调用出错");
		}
		
	}

}
