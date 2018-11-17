package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.misc.ALU;

/**
 * exp1 or exp2
 * @author joelli
 *
 */
public class OrExpression extends Expression {

	public Expression exp1, exp2;

	public OrExpression(Expression exp1, Expression exp2, GrammarToken token) {
		super(token);
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public Object evaluate(Context ctx) {
		if (ALU.isTrue(exp1.evaluate(ctx), exp1)) {
			return Boolean.TRUE;
		} else {
			return ALU.isTrue(exp2.evaluate(ctx), exp2);
		}
	}


}
