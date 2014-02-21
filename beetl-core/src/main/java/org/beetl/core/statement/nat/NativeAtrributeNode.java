package org.beetl.core.statement.nat;

public class NativeAtrributeNode extends NativeNode
{
	public String attribute;

	public NativeAtrributeNode(String attribute)
	{
		this.attribute = attribute;
	}

	public String attribute()
	{
		return this.attribute;
	}
}