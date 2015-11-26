package org.beetl.ext.fn;

import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;

public class PagePut implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		Map map = (Map)ctx.getGlobal("$page");
		if(map==null) throw new RuntimeException("没有找到$page全局变量");
		String key = (String)paras[0];
		Object value = paras[1];
		return map.put(key, value);
	}

}
