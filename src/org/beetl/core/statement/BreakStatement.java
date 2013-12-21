package org.beetl.core.statement;

import org.beetl.core.Context;

public class BreakStatement extends Statement {

	public BreakStatement(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		ctx.gotoFlag = IGoto.BREAK;
		return null;
	}

}
