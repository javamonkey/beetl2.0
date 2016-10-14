/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
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
package org.beetl.core.misc;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.beetl.core.GroupTemplate;

/** 在classloader下仅仅根据类名加载类，会尝试用系统内置的以及配置好的包名作为类的包名
 * @author jeolli
 *
 */
public class ClassSearch
{
	Set<String> pkgList;
	Map<String, Class> map = new ConcurrentHashMap<String, Class>();
	GroupTemplate gt;

	/**默认的搜索列表
	 * @param pkgList
	 */
	public ClassSearch(Set<String> pkgList,GroupTemplate gt)
	{
		this.pkgList = pkgList;
		this.gt = gt ;

	}

	/** 根据类名得到指定类，如果类名是带包名，则直接用当前classloader加载，如果仅仅类名
	 * 则尝试用内置的或者配置的包名作为包名尝试加载
	 * @param name
	 * @return 不成功，返回null
	 */
	public Class getClassByName(String name)
	{

		if (name.indexOf(".") != -1)
		{
			try
			{
				return Class.forName(name,true,gt.getClassLoader());
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
						cls = Class.forName(clsName,true,gt.getClassLoader());
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
