/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
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
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;

/**
 * 三元表达式
 * 
 * condtion?a:b
 * @author joelli
 *
 */
public class TernaryExpression extends Expression
{

	public Expression condtion;
	public Expression a;
	public Expression b;

	public TernaryExpression(Expression condtion, Expression a, Expression b, GrammarToken token)
	{
		super(token);
		this.condtion = condtion;
		this.a = a;
		this.b = b;

	}

	public Object evaluate(Context ctx)
	{
		
		Object value = condtion.evaluate(ctx);
		if(value==null){
			BeetlException be = new BeetlException(BeetlException.NULL);
			be.pushToken(condtion.token);
			throw be;
		}else if(!(value instanceof Boolean)){
			BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
			be.pushToken(condtion.token);
			throw be;
		}
		boolean cond = (Boolean)value;

		if (cond)
		{
			return a.evaluate(ctx);
		}
		else
		{
			if (b != null)
			{
				return b.evaluate(ctx);
			}
			else
			{
				return null;
			}
		}

	}

	public void infer(InferContext inferCtx)
	{
		condtion.infer(inferCtx);
		if (a != null)
		{
			a.infer(inferCtx);
			if (b == null)
			{
				this.type = a.type;
				return;
			}
		}
		if (b != null)
		{
			b.infer(inferCtx);
			if (a == null)
			{
				this.type = b.type;
				return;
			}
		}

		if (a.type.equals(b.type))
		{
			this.type = a.type;
		}
		else
		{
			// 能优化成共同的接口或者父类？
			this.type = Type.ObjectType;
		}

	}

}
