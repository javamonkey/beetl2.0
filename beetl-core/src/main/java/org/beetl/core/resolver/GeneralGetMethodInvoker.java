package org.beetl.core.resolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GeneralGetMethodInvoker implements MethodInvoker
{
	Method method;
	String name;

	public GeneralGetMethodInvoker(Method m, String name)
	{
		this.method = m;
		this.name = name;
	}

	@Override
	public Object get(Object o)
	{
		try
		{
			return method.invoke(o, name);
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Class getReturnType()
	{
		return method.getReturnType();
	}
}
