package org.beetl.core.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache
{
	Map map = new HashMap();
	List list = new ArrayList();

	public Cache()
	{
		map.put("a", 1);
		map.put("b", new TestUser("b"));
		list.add(new TestUser("a"));
	}

	public Object get(String key)
	{
		if (key.equals("map"))
		{
			return map;
		}
		else
		{
			return list;
		}
	}
}
