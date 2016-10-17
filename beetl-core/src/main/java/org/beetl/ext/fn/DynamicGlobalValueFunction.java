package org.beetl.ext.fn;

import org.beetl.core.Context;
import org.beetl.core.Function;

/** 动态引用全局变量，dynamic(a+"_index");
 * @author xiandafu
 *
 */
public class DynamicGlobalValueFunction implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
	
		String key = (String)paras[0];
		return ctx.globalVar.get(key);
	}
	
}
