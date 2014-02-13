package org.beetl.core.resolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.beetl.core.exception.TempException;

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
			throw new TempException(e.getMessage());
		}
		catch (IllegalAccessException e)
		{
			throw new TempException(e.getMessage());
		}
		catch (InvocationTargetException e)
		{
			throw new TempException(e.getMessage());
		}
	}

	@Override
	public Class getReturnType()
	{
		return method.getReturnType();
	}
}
