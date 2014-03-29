package org.beetl.core.resolver;

import java.util.List;

public class ListAA extends AttributeAccess
{

	@Override
	public Object value(Object o, Object attr)
	{
		int index = ((Number) attr).intValue();
		return ((List) o).get(index);
	}

}
