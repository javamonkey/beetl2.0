package org.beetl.core.statement.nat;

import org.beetl.core.statement.Expression;

public class NativeArrayNode extends NativeNode
{
	public Expression exp;

	public NativeArrayNode(Expression expression)
	{
		this.exp = expression;
	}

}