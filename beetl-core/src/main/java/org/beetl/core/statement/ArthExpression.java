/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.misc.ALU;

/**
 * a+b,a-b,a*b,a/b,a%b
 * @author joelli
 *
 */
public class ArthExpression extends Expression {

	public static final short PLUS = 0;
	public static final short MIN = 1;
	public static final short MUL = 2;
	public static final short DIV = 3;
	public static final short MOD = 4;
	public short arthMode = PLUS;

	public Expression a;
	public Expression b;

	public ArthExpression(Expression a, Expression b, short mode, GrammarToken token) {
		super(token);
		this.a = a;
		this.b = b;
		this.arthMode = mode;
	}

	public Object evaluate(Context ctx) {
		Object x = a.evaluate(ctx);
		Object y = b.evaluate(ctx);
		switch (arthMode) {
			case PLUS:
				return ALU.plus(x, y, a, b);
			case MIN:
				return ALU.minus(x, y, a, b);
			case MUL:
				return ALU.mult(x, y, a, b);
			case DIV:
				return ALU.div(x, y, a, b);
			case MOD:
				return ALU.mod(x, y, a, b);

			default:
				throw new RuntimeException("不可能发生");

		}

	}


}
