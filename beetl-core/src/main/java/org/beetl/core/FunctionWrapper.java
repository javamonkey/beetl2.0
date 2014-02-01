package org.beetl.core;

public abstract class FunctionWrapper implements Function
{
	boolean requiredContext = false;
	String functionName = null;
	Object target;

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
}
