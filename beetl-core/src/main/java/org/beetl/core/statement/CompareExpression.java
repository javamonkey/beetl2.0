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
 *  a&gt; b,a&gt;=b,a==b,a&gt;b,a&gt;=b
 * @author joelli
 *
 */
public class CompareExpression extends Expression {

	final short EQUAL = 0;
	final short NOT_EQUAL = 1;
	final short LARGE = 2;
	final short LARGE_EQUAL = 3;
	final short LESS = 4;
	final short LESS_EQUAL = 5;

	short compareMode = EQUAL;

	public Expression a;
	public Expression b;

	public CompareExpression(Expression a, Expression b, short mode, GrammarToken token) {
		super(token);
		this.a = a;
		this.b = b;
		this.compareMode = mode;
	}

	public Object evaluate(Context ctx) {
		Object x = a.evaluate(ctx);
		Object y = b.evaluate(ctx);
		int r = 0;
		switch (compareMode) {
			case EQUAL:
				return ALU.equals(x, y);

			case NOT_EQUAL:
				return !ALU.equals(x, y);
			case LARGE_EQUAL:
				return !ALU.less(x, y, a, b);

			case LARGE:
				return !ALU.lessEquals(x, y, a, b);
			case LESS:
				return ALU.less(x, y, a, b);
			case LESS_EQUAL:
				return ALU.lessEquals(x, y, a, b);
			default:
				throw new RuntimeException("不可能发生");

		}

	}


}
