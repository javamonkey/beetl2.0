package org.beetl.core.om;

import java.util.Map;

public class MapAA extends AttributeAccess
{

	@Override
	public Object value(Object o, Object name)
	{
		return ((Map) o).get(name);
	}

}
