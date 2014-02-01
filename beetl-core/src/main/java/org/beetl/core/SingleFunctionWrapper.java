package org.beetl.core;

import java.lang.reflect.Method;

import org.beetl.core.exception.TempException;

public class SingleFunctionWrapper extends FunctionWrapper
{
	Method m;

	public SingleFunctionWrapper(Object target, Method m)
	{
		this.target = target;
		this.m = m;
		this.requiredContext = this.checkContextRequried(m.getParameterTypes());

	}

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		try
		{
			if (!this.requiredContext)
			{
				Object result = m.invoke(target, paras);
				return result;
			}
			else
			{
				Object[] newParas = new Object[paras.length + 1];
				System.arraycopy(paras, 0, newParas, 0, paras.length);
				newParas[paras.length] = ctx;
				return m.invoke(target, newParas);
			}

		}
		catch (Exception ex)
		{
			throw new TempException(ex.getMessage());
		}

	}

}
