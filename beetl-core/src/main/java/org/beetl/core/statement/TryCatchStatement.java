package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;

public class TryCatchStatement extends Statement
{

	BlockStatement tryPart;
	BlockStatement catchPart;
	VarDefineNode error;

	public TryCatchStatement(BlockStatement tryPart, BlockStatement catchPart, VarDefineNode error, GrammarToken token)
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
					if (ex instanceof BeetlException)
					{
						ctx.vars[error.varIndex] = ex;
					}
					else
					{
						ctx.vars[error.varIndex] = new BeetlException(BeetlException.ERROR, ex.getMessage(), ex);
					}

				}
				catchPart.execute(ctx);

			}
			else
			{

				if (ex instanceof BeetlException)
				{
					throw (BeetlException) ex;
				}
				else
				{
					BeetlException be = new BeetlException(BeetlException.ERROR, ex.getMessage(), ex);
					be.token = tryPart.token;
					throw be;
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
