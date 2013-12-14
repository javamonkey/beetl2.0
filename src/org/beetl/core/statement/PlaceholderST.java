package org.beetl.core.statement;

import org.beetl.core.Context;

public class PlaceholderST extends Statement {

	Expression expression;

	public PlaceholderST(Expression exp, Token token) {
		super(token);
		this.expression = exp;

	}

	@Override
	public Object run(Context ctx) {
		Object value = expression.run(ctx);
		ctx.byteWriter.writePlaceholderContent(value);

		return null;
	}

}
