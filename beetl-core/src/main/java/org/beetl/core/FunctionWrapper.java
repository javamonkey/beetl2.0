package org.beetl.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.util.ObjectUtil;

public abstract class FunctionWrapper implements Function
{
	boolean requiredContext = false;
	String functionName = null;
	Object target;

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

	public static List<FunctionWrapper> getFunctionWrapper(String ns, Object o)
	{
		Method[] ms = ObjectUtil.getSelfPublicMethod(o);
		// 同名方法
		Map<String, List<Method>> map = new HashMap<String, List<Method>>();

		for (Method method : ms)
		{
			String name = method.getName();
			List<Method> list = map.get(name);
			if (list == null)
			{
				list = new ArrayList<Method>();
				map.put(name, list);
			}
			list.add(method);

		}

		List<FunctionWrapper> fwList = new ArrayList<FunctionWrapper>();
		for (Entry<String, List<Method>> entry : map.entrySet())
		{

			if (entry.getValue().size() == 1)
			{
				Method method = entry.getValue().get(0);
				FunctionWrapper fw = new SingleFunctionWrapper(ns.concat(".").concat(method.getName()), o, method);
				fwList.add(fw);
			}
			else
			{
				Method method = entry.getValue().get(0);
				String name = method.getName();
				FunctionWrapper fw = new MutipleFunctionWrapper(ns.concat(".").concat(name), o, entry.getValue()
						.toArray(new Method[0]));
				fwList.add(fw);
			}

		}
		return fwList;

	}
}
