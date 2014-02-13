package org.beetl.core.resolver;

public interface MethodInvoker
{
	public Object get(Object o);

	public Class getReturnType();
}
