package org.beetl.core.attr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.beetl.core.exception.TempException;

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
