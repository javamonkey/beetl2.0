package org.beetl.core.statement;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.exception.TempException;

public class PlaceholderST extends Statement {

	Expression expression;

	public PlaceholderST(Expression exp, Token token) {
		super(token);
		this.expression = exp;

	}

	@Override
	public void execute(Context ctx) {
		Object value = expression.evaluate(ctx);
		try {
			ctx.byteWriter.write(value);
		} catch (IOException e) {
			throw new TempException(e.getMessage());
		}

	}

}
