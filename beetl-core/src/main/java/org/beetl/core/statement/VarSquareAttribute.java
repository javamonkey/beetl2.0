package org.beetl.core.statement;

import org.beetl.core.InferContext;

/**
 * a.[]
 * 
 * @author joelli
 * 
 */
public class VarSquareAttribute extends VarAttribute
{
	protected short type = 1;
	public Expression exp;

	public VarSquareAttribute(Expression exp, Token token)
	{
		super(token);
		this.exp = exp;
	}

	public void infer(InferContext inferCtx)
	{
		super.infer(inferCtx);
	}

}
