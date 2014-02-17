package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class TryStatement extends Statement
{

	BlockStatement tryPart;
	BlockStatement catchPart;
	VarDefineNode error;

	public TryStatement(BlockStatement tryPart, BlockStatement catchPart, VarDefineNode error, Token token)
	{
		super(token);
		this.tryPart = tryPart;
		this.catchPart = catchPart;
		this.error = error;
	}

	@Override
	public void execute(Context ctx)
	{
		try
		{
			tryPart.execute(ctx);

		}
		catch (Exception ex)
		{
			if (catchPart != null)
			{
				ctx.vars[error.varIndex] = ex;
				catchPart.execute(ctx);
			}
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		tryPart.infer(inferCtx);
		if (catchPart != null)
		{
			catchPart.infer(inferCtx);
		}

	}

}
