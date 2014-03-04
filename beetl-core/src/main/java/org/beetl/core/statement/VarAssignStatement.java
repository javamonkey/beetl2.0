package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class VarAssignStatement extends Statement implements IVarIndex
{

	protected int varIndex;
	public Expression exp;

	public VarAssignStatement(Expression exp, Token token)
	{
		super(token);
		this.exp = exp;
	}

	public void execute(Context ctx)
	{
		ctx.vars[varIndex] = exp.evaluate(ctx);

	}

	public int getVarIndex()
	{
		return varIndex;
	}

	public void setVarIndex(int varIndex)
	{
		this.varIndex = varIndex;
	}

	public void infer(InferContext inferCtx)
	{

		exp.infer(inferCtx);
		Type oldType = inferCtx.types[varIndex];
		Type newType = exp.type;
		if (oldType == null)
		{
			inferCtx.types[varIndex] = newType;
		}
		else if (oldType.cls == Type.NULLType.cls)
		{
			inferCtx.types[varIndex] = newType;
		}
		else
		{
			// 对于数字类型，很有可能整形变成浮点，解释执行是ok的，但编译执行会出错
			//同样，对于不同类型，解释执行ok，但编译执行就问题。
			//解决办法只能是重新infer，或者整个模板都解释执行，或者提示dynamic object
			inferCtx.types[varIndex] = newType;

		}

	}

}
