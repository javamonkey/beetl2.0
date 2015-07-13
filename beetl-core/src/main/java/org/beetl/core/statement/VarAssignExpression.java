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

/**
 *  if( (xxx = exp)==1);
 * @author joelli
 *
 */
public class VarAssignExpression extends Expression implements IVarIndex
{

	protected int varIndex;
	public Expression exp;

	public VarAssignExpression(Expression exp, GrammarToken token)
	{
		super(token);
		this.exp = exp;
	}

	public Object evaluate(Context ctx)
	{
		Object o = exp.evaluate(ctx);
		ctx.vars[varIndex] = o;
		return o;

	}

	public void infer(InferContext inferCtx)
	{

		exp.infer(inferCtx);
		Type oldType = inferCtx.types[varIndex];
		Type newType = exp.type;
		if (oldType == null)
		{
			inferCtx.types[varIndex] = newType;
		}
		else if (oldType.cls == Type.NULLType.cls)
		{
			inferCtx.types[varIndex] = newType;
		}
		else
		{
			// 对于数字类型，很有可能整形变成浮点，解释执行是ok的，但编译执行会出错
			//同样，对于不同类型，解释执行ok，但编译执行就问题。
			//解决办法只能是重新infer，或者整个模板都解释执行，或者提示dynamic object
			inferCtx.types[varIndex] = newType;

		}

	}

	@Override
	public void setVarIndex(int index) {
		this.varIndex = index;
	}

	@Override
	public int getVarIndex() {
		return varIndex;
	}

}
