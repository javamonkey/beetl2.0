package org.beetl.core.statement;

import org.beetl.core.Context;

public class BreakStatement extends Statement
{

	public BreakStatement(Token token)
	{
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void execute(Context ctx)
	{
		ctx.gotoFlag = IGoto.BREAK;

	}

}
