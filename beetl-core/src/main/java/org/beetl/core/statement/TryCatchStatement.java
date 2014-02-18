package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

public class TryCatchStatement extends Statement
{

	BlockStatement tryPart;
	BlockStatement catchPart;
	VarDefineNode error;

	public TryCatchStatement(BlockStatement tryPart, BlockStatement catchPart, VarDefineNode error, Token token)
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
				if (error != null)
				{
					if (ex instanceof TempException)
					{
						ctx.vars[error.varIndex] = ex;
					}
					else
					{
						ctx.vars[error.varIndex] = new TempException(ex.getMessage());
					}

				}
				catchPart.execute(ctx);

			}
			else
			{
				if (ex instanceof RuntimeException)
				{
					throw (RuntimeException) ex;
				}
				else
				{
					throw new TempException(ex.getMessage());
				}
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
