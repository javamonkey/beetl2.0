package org.beetl.core.statement;

import org.beetl.core.Context;

public class SafePlaceholderST extends PlaceholderST {

	public SafePlaceholderST(Expression exp, Token token) {
		super(exp, token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Context ctx) {
		try {
			Object value = expression.evaluate(ctx);
			ctx.byteWriter.write(value);
		} catch (Exception ex) {

		}

	}

}
