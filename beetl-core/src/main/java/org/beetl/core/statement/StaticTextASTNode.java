package org.beetl.core.statement;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;

public final class StaticTextASTNode extends Statement
{

	int textIndex;

	public StaticTextASTNode(int textIndex, GrammarToken token)
	{
		super(token);
		this.textIndex = textIndex;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Context ctx)
	{
		try
		{
			if (ctx.byteOutputMode)
			{
				ctx.byteWriter.write((byte[]) ctx.staticTextArray[textIndex]);
			}
			else
			{
				ctx.byteWriter.write((char[]) ctx.staticTextArray[textIndex]);
			}
		}
		catch (IOException ex)
		{
			BeetlException be = new BeetlException(BeetlException.CLIENT_IO_ERROR_ERROR, "Client IO Error", ex);
			be.token = this.token;
			throw be;
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// do nothing
	}

}
