package org.beetl.core.lab;

import org.beetl.core.om.AttributeAccess;

public class XXXAttributeAccess extends AttributeAccess
{

	@Override
	public Object value(Object o, Object name)
	{
		return ((PrivateTest) o).getName();
	}

}
