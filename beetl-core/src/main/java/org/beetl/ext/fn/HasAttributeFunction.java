package org.beetl.ext.fn;

import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.fun.GeneralGetMethodInvoker;
import org.beetl.core.fun.MethodInvoker;
import org.beetl.core.fun.ObjectUtil;

/**
 * 判断指定对象是否包含属性
 *  if(hasAttribute(xxx,"name","age")
 * @author xiandafu
 *
 */
public class HasAttributeFunction implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		Object  o = paras[0];
		if(o==null) {
			throw new NullPointerException();
		}
		if(o instanceof Map) {
			return false;
		}
		Class type  = o.getClass();
		for(int i=1;i<paras.length;i++) {
			String key = (String)paras[i];
			//TODO3.0,  通过反射获取
			MethodInvoker invoke = ObjectUtil.getInvokder(type, key);
			if(invoke==null) {
				return false;
			}else if(invoke instanceof GeneralGetMethodInvoker) {
				return false ;
			}
		}
		return true;
	}

}
