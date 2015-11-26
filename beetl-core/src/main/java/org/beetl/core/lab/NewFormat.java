package org.beetl.core.lab;

import org.beetl.core.Context;
import org.beetl.core.ContextFormat;

public class NewFormat extends ContextFormat {

	@Override
	public Object format(Object data, String pattern, Context ctx) {
		return ctx.globalVar.get(data.toString());
	}

}
