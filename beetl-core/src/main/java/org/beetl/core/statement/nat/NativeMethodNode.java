package org.beetl.core.statement.nat;

import org.beetl.core.statement.Expression;

public class NativeMethodNode extends NativeNode
{
	public String method;
	public Expression[] paras;

	public NativeMethodNode(String method, Expression[] paras)
	{
		this.method = method;
		this.paras = paras;
	}

}