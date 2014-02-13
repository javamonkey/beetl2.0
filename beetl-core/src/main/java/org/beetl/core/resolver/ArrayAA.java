package org.beetl.core.resolver;

public class ArrayAA extends AA
{

	@Override
	public Object value(Object o, Object attr)
	{
		int index = ((Number) attr).intValue();
		return ((Object[]) o)[index];
	}

}
