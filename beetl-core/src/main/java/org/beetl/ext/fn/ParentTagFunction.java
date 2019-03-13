package org.beetl.ext.fn;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.tag.Tag;

public class ParentTagFunction implements Function {

	@Override
	public Tag call(Object[] paras, Context ctx) {

		Tag current = ctx.getCurrentTag();
		return current != null ? current.getParent() : null;
	}

}
