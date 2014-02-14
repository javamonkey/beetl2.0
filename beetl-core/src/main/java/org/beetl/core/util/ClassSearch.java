package org.beetl.core.util;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClassSearch
{
	Set<String> pkgList;
	Map<String, Class> map = new ConcurrentHashMap<String, Class>();

	public ClassSearch(Set<String> pkgList)
	{
		this.pkgList = pkgList;

	}

	public Class getClassByName(String name)
	{

		if (name.indexOf(".") != -1)
		{
			try
			{
				return Class.forName(name);
			}
			catch (ClassNotFoundException e)
			{
				return null;
			}

		}
		else
		{
			Class cls = map.get(name);
			if (cls == null)
			{
				for (String pkg : pkgList)
				{
					try
					{
						String clsName = pkg.concat(name);
						cls = Class.forName(clsName);
						map.put(name, cls);
						return cls;

					}
					catch (Exception ex)
					{
						// continue;
					}
				}
				return null;
			}
			else
			{
				return cls;
			}

		}

	}
}
