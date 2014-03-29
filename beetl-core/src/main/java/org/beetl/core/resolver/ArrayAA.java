package org.beetl.core.resolver;

public class ArrayAA extends AttributeAccess
{

	@Override
	public Object value(Object o, Object attr)
	{
		int index = ((Number) attr).intValue();
		return ((Object[]) o)[index];
	}

}
