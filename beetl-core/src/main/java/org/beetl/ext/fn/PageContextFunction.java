package org.beetl.ext.fn;

import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;

/** 用于web开发，提供一个存放变量的pageContext,存放变量，随后再任意地方使用
 * <pre>
 * pageCtx("abc",user); * 
 * 
 * var user  = pageCtx("abc");
 * </pre>
 * @author xiandafu
 *
 */
public class PageContextFunction implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		//参考webrender,仅仅在webrender里设置了这个变量
		Map map = (Map)ctx.getGlobal("$page");
		if(map==null) throw new RuntimeException("没有找到$page全局变量");
		if(paras.length==1){
			String key = (String)paras[0];
			return map.get(key);
		}else {
			String key = (String)paras[0];
			Object value = paras[1];
			return map.put(key, value);
		}
	
	}

}
