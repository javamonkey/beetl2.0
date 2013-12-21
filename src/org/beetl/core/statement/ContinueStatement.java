package org.beetl.core.statement;

import org.beetl.core.Context;

public class ContinueStatement extends Statement {

	public ContinueStatement(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		ctx.gotoFlag = IGoto.CONTINUE;
		return null;
	}

}
