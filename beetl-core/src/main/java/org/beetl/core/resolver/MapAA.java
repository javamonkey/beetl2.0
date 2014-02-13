package org.beetl.core.resolver;

import java.util.Map;

public class MapAA extends AA
{

	@Override
	public Object value(Object o, Object name)
	{
		return ((Map) o).get(name);
	}

}
