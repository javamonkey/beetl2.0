package org.beetl.core.statement;

import org.beetl.core.ALU;
import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class CompareExpression extends Expression
{

	final short EQUAL = 0;
	final short NOT_EQUAL = 1;
	final short LARGE = 2;
	final short LARGE_EQUAL = 3;
	final short LESS = 4;
	final short LESS_EQUAL = 5;

	short compareMode = EQUAL;

	public Expression a;
	public Expression b;

	public CompareExpression(Expression a, Expression b, short mode, GrammarToken token)
	{
		super(token);
		this.a = a;
		this.b = b;
		this.compareMode = mode;
	}

	public Object evaluate(Context ctx)
	{
		Object x = a.evaluate(ctx);
		Object y = b.evaluate(ctx);
		int r = 0;
		switch (compareMode)
		{
			case EQUAL:
				return ALU.equals(x, y);

			case NOT_EQUAL:
				return !ALU.equals(x, y);
			case LARGE_EQUAL:
				return ALU.less(y, x, a, b);

			case LARGE:
				return ALU.lessEquals(y, x, a, b);
			case LESS:
				return ALU.less(x, y, a, b);
			case LESS_EQUAL:
				return ALU.lessEquals(x, y, a, b);
			default:
				throw new RuntimeException("不可能发生");

		}

	}

	public void infer(InferContext inferCtx)
	{
		a.infer(inferCtx);
		b.infer(inferCtx);
		this.type = Type.BooleanType;
	}

}
