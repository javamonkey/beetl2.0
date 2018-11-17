package org.beetl.core.statement;

import org.beetl.core.Context;

/**
 * 表达式语句，如fun();
 * @author joelli
 *
 */
public class StatementExpression extends Statement {

	public Expression exp;

	public StatementExpression(Expression exp, GrammarToken token) {
		super(token);
		this.exp = exp;

	}

	@Override
	public void execute(Context ctx) {
		exp.evaluate(ctx);

	}


}
