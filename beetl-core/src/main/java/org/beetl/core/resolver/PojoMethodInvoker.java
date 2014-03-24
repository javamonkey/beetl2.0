package org.beetl.core.resolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PojoMethodInvoker implements MethodInvoker
{

	Method method;

	public PojoMethodInvoker(Method m)
	{
		this.method = m;
	}

	@Override
	public Object get(Object obj)
	{
		try
		{
			return method.invoke(obj, null);
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
