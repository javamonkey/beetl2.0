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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 将native方法包装成Function
 * @author joelli
 *
 */
public abstract class FunctionWrapper implements Function
{
	boolean requiredContext = false;
	public String functionName = null;
	Object target;
	Class cls;

	public FunctionWrapper(String funName)
	{
		this.functionName = funName;
	}

	protected boolean checkContextRequried(Class[] paras)
	{
		return paras.length != 0 && paras[paras.length - 1] == Context.class;
	}

	protected Object[] getContextParas(Object[] paras, Context ctx)
	{
		Object[] newParas = new Object[paras.length + 1];
		System.arraycopy(paras, 0, newParas, 0, paras.length);
		newParas[paras.length] = ctx;
		return newParas;

	}

	/**得到对象的所有FunctionWrapper，改对象的所有Public 方法都将注册到Beetl里
	 * @param ns
	 * @param o
	 * @return
	 */
	public static List<FunctionWrapper> getFunctionWrapper(String ns, Class c, Object o)
	{

		ObjectInfo info = ObjectUtil.getObjectInfo(c);
		Map<String, List<Method>> map = info.getMap();
		List<FunctionWrapper> fwList = new ArrayList<FunctionWrapper>();
		for (Entry<String, List<Method>> entry : map.entrySet())
		{

			if (entry.getValue().size() == 1)
			{

				Method method = entry.getValue().get(0);
				FunctionWrapper fw = new SingleFunctionWrapper(ns.concat(".").concat(method.getName()), c, o, method);
				fwList.add(fw);
			}
			else
			{
				Method method = entry.getValue().get(0);
				String name = method.getName();
				FunctionWrapper fw = new MutipleFunctionWrapper(ns.concat(".").concat(name), c, o, entry.getValue()
						.toArray(new Method[0]));
				fwList.add(fw);
			}

		}
		return fwList;

	}
}
