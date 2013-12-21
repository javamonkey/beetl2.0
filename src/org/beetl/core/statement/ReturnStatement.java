package org.beetl.core.statement;

import org.beetl.core.Context;

public class ReturnStatement extends Statement {

	public ReturnStatement(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		ctx.gotoFlag = IGoto.RETURN;
		return null;
	}

}
