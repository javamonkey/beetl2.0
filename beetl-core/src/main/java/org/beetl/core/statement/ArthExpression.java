package org.beetl.core.statement;

import org.beetl.core.ALU;
import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

public class ArthExpression extends Expression
{

	public static final short PLUS = 0;
	public static final short MIN = 1;
	public static final short MUL = 2;
	public static final short DIV = 3;
	public static final short MOD = 4;
	short arthMode = PLUS;

	public Expression a;
	public Expression b;

	public ArthExpression(Expression a, Expression b, short mode, GrammarToken token)
	{
		super(token);
		this.a = a;
		this.b = b;
		this.arthMode = mode;
	}

	public Object evaluate(Context ctx)
	{
		Object x = a.evaluate(ctx);
		Object y = b.evaluate(ctx);
		switch (arthMode)
		{
			case PLUS:
				return ALU.plus(x, y);
			case MIN:
				return ALU.minus(x, y);
			case MUL:
				return ALU.mult(x, y);
			case DIV:
				return ALU.div(x, y);
			case MOD:
				return ALU.mod(x, y);

			default:
				throw new TempException("不可能发生");

		}

	}

	public void infer(InferContext inferCtx)
	{
		a.infer(inferCtx);
		b.infer(inferCtx);
		//should check it ?
		this.type = new Type(ALU.getBaseTypeClass(a.type.cls, b.type.cls));
	}

}
