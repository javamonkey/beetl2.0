package org.beetl.core.om;

import java.util.Map.Entry;

public class MapEntryAA extends AttributeAccess
{

	@Override
	public Object value(Object o, Object name)
	{
		Entry entry = (Entry) o;
		if (name.equals("key"))
		{
			return entry.getKey();
		}
		else if (name.equals("value"))
		{
			return entry.getValue();
		}
		else
		{
			throw new RuntimeException("无此方法entry." + name);
		}
	}

}
