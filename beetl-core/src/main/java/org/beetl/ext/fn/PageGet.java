package org.beetl.ext.fn;

import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;

public class PageGet implements Function {

	@Override
	public Object call(Object[] paras, Context ctx) {
		Map map = (Map)ctx.getGlobal("$page");
		if(map==null) throw new RuntimeException("没有找到$page全局变量");
		String key = (String)paras[0];
		return map.get(key);
	}

}
