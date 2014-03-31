package org.beetl.core.statement;

import org.beetl.core.ALU;
import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class IncDecExpression extends Expression implements IVarIndex
{
	boolean isInc, returnOrginal;
	int index;

	public IncDecExpression(boolean isInc, boolean returnOrginal, GrammarToken token)
	{
		super(token);
		this.isInc = isInc;
		this.returnOrginal = returnOrginal;
	}

	public final Object evaluate(Context ctx)
	{
		Object c = ctx.vars[index];
		Object newValue = isInc ? ALU.plusOne(c, this) : ALU.minusOne(c, this);
		if (isInc)
		{
			newValue = ALU.plusOne(c, this);
		}
		else
		{
			newValue = ALU.minusOne(c, this);
		}
		ctx.vars[index] = newValue;
		return returnOrginal ? c : newValue;
	}

	@Override
	public void infer(InferContext inferCtx)
	{
		this.type = inferCtx.types[this.index];

	}

	@Override
	public void setVarIndex(int index)
	{
		this.index = index;

	}

	@Override
	public int getVarIndex()
	{
		return index;
	}

}
