package org.beetl.core.function;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.User;

public class NullFunction implements Function {

	@Override
	public Map call(Object[] paras, Context ctx) {
		Boolean b = (Boolean)paras[0];
		if(b) {
			return null;
		}else {
			Map map = new HashMap();
			User user = new User("name");
			map.put("user", user);
			return map;
		}
	}

}
