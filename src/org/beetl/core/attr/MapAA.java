package org.beetl.core.attr;

import java.util.Map;

public class MapAA implements AA {


	@Override
	public Object getAttribute(Object o, int index, String name) {
		return ((Map)o).get(name);
	}

	
}
