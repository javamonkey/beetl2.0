package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

public class VarRef extends Expression implements IVarIndex
{

	public VarAttribute[] attributes;
	public Expression safe;
	int varIndex;
	boolean hasSafe;

	public VarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, Token token)
	{
		super(token);

		this.attributes = attributes;
		this.safe = safe;
		this.hasSafe = hasSafe;

	}

	@Override
	public Object evaluate(Context ctx)
	{

		Object value = ctx.vars[varIndex];
		if (value == Context.NOT_EXIST_OBJECT)
		{
			if (hasSafe)
			{
				return safe == null ? null : safe.evaluate(ctx);
			}
			else if (ctx.safeOutput)
			{
				return null;
			}
			else
			{
				throw new TempException("未定义或者是空" + this.token.text);
			}
		}

		if (attributes.length == 0)
		{
			return value;
		}
		Object attrExp = null;
		for (VarAttribute attr : attributes)
		{

			if (value == null && hasSafe)
			{
				return safe == null ? null : safe.evaluate(ctx);
			}
			value = attr.evaluate(ctx, value);

		}
		return value;

	}

	@Override
	public void setVarIndex(int index)
	{
		this.varIndex = index;

	}

	@Override
	public int getVarIndex()
	{
		return this.varIndex;
	}

	@Override
	public void infer(InferContext inferCtx)
	{

		Type type = inferCtx.types[this.varIndex];
		Type lastType = type;
		Type t = null;
		for (VarAttribute attr : attributes)
		{
			inferCtx.temp = lastType;
			attr.infer(inferCtx);
			t = lastType;
			lastType = attr.type;
			attr.type = t;

		}
		this.type = lastType;
	}

}
