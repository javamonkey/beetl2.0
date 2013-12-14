package org.beetl.core.statement;

import org.beetl.core.Context;

public class SafePlaceholderST extends PlaceholderST {

	public SafePlaceholderST(Expression exp, Token token) {
		super(exp, token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		try {
			Object value = expression.run(ctx);
			ctx.byteWriter.writePlaceholderContent(value);
		} catch (Exception ex) {

		}

		return null;
	}

}
