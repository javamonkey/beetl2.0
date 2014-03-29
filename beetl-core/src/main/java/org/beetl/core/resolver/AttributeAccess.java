package org.beetl.core.resolver;

public abstract class AttributeAccess implements java.io.Serializable
{
	public Class returnType;

	public abstract Object value(Object o, Object name);

}
