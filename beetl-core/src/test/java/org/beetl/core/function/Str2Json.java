package org.beetl.core.function;

import java.util.Map;

import org.beetl.core.BeetlKit;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;

public class Str2Json implements Function
{

	@Override
	public Object call(Object[] paras, Context ctx) {
		String str = (String) paras[0];
		String json = "var a=".concat(str).concat(";");
		Map map;
		try {
			map = BeetlKit.execute(json);
		} catch (BeetlException e) {
			throw e;
		}
		return map.get("a");
	}

}
