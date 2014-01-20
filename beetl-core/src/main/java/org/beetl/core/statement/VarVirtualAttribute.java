package org.beetl.core.statement;

public class VarVirtualAttribute extends VarAttribute
{
	protected short type = 2;

	public VarVirtualAttribute(Token token)
	{
		super(token);

	}

	public void infer(Type[] types, Object temp)
	{
		throw new UnsupportedOperationException();
	}
}
