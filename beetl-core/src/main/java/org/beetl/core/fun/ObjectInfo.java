/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.fun;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 指定类包含的所有方法，并且按照方法名归类
 * @author joelli
 *
 */
public class ObjectInfo
{
	Map<String, List<Method>> map = new HashMap<String, List<Method>>();
	List<Method> allMethod = new ArrayList<Method>();
	Class c = null;

	public ObjectInfo(Class c)
	{
		this.c = c;
		init();
	}

	public List<Method> getMethods(String name)
	{
		return map.get(name);
	}

	public List<Method> allMethods()
	{
		return allMethod;
	}

	public Map<String, List<Method>> getMap()
	{
		return this.map;
	}

	private void init()
	{
		Method[] ms = c.getMethods();
		for (Method m : ms)
		{
			//仅仅获取public
			if (Modifier.isPublic(m.getModifiers()))
			{
				if (m.getDeclaringClass() == Object.class)
				{
					continue;
				}
				String name = m.getName();
				List<Method> list = map.get(name);
				if (list == null)
				{
					list = new ArrayList<Method>(1);
					map.put(name, list);

				}
				list.add(m);
				allMethod.add(m);
			}

		}

	}

}
