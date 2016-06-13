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

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.fun.MutipleFunctionWrapper;
import org.beetl.core.fun.SingleFunctionWrapper;

/**
 * call();
 * @author joelli
 *
 */
public class FunctionExpression extends Expression
{
	String name;
	public Expression[] exps;
	public VarAttribute[] vas;

	public FunctionExpression(String name, Expression[] exps, VarAttribute[] vas, GrammarToken token)
	{
		super(token);
		this.name = name;
		this.exps = exps;
		this.vas = vas;
	}

	public Object evaluate(Context ctx)
	{
		Function fn = ctx.gt.getFunction(name);
		if (fn == null)
		{
			BeetlException ex = new BeetlException(BeetlException.FUNCTION_NOT_FOUND);
			ex.pushToken(token);
			throw ex;
		}

		Object[] paras = new Object[exps.length];
		for (int i = 0; i < paras.length; i++)
		{
			paras[i] = exps[i].evaluate(ctx);
		}
		Object value = null;
		try
		{
			value = fn.call(paras, ctx);
		}
		catch (BeetlException ex)
		{
			ex.pushToken(token);
			throw ex;
		}
		catch (RuntimeException ex)
		{
			BeetlException be = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用方法出错 " + name, ex);
			be.pushToken(this.token);
			throw be;
		}

		if (vas == null)
		{
			return value;
		}
		else
		{

			for (VarAttribute attr : vas)
			{

				try
				{
					value = attr.evaluate(ctx, value);
				}
				catch (BeetlException ex)
				{
					ex.pushToken(attr.token);
					throw ex;

				}
				catch (RuntimeException ex)
				{
					BeetlException be = new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问出错", ex);
					be.pushToken(attr.token);
					throw be;
				}

				if (value == null)
				{
					BeetlException be = new BeetlException(BeetlException.ERROR, "空指针 ");
					be.pushToken(attr.token);
					throw be;
				}

			}
			return value;
		}

	}

	public void infer(InferContext inferCtx)
	{
		Function fn = inferCtx.gt.getFunction(name);
		if (fn == null)
		{
			BeetlException ex = new BeetlException(BeetlException.FUNCTION_NOT_FOUND);
			ex.pushToken(token);
			throw ex;
		}
		for (Expression exp : exps)
		{
			exp.infer(inferCtx);
		}
		//return type;
		Class c = null;
		if (fn instanceof SingleFunctionWrapper)
		{
			SingleFunctionWrapper singleWrapper = (SingleFunctionWrapper) fn;
			c = singleWrapper.getReturnType();
		}
		else if (fn instanceof MutipleFunctionWrapper)
		{
			try
			{
				Class[] parasType = new Class[exps.length];
				int i = 0;
				for (Expression exp : exps)
				{
					exp.infer(inferCtx);
					parasType[i++] = exp.getType().cls;
				}
				c = ((MutipleFunctionWrapper) fn).getReturnType(parasType);
			}
			catch (BeetlException ex)
			{
				ex.pushToken(token);
				throw ex;
			}

		}
		else
		{

			Method call = null;
			try
			{
				call = fn.getClass().getMethod("call", Object[].class, Context.class);
				c = call.getReturnType();
			}
			catch (NoSuchMethodException e)
			{
				BeetlException ex = new BeetlException(BeetlException.FUNCTION_INVALID);
				ex.pushToken(token);
				throw ex;
			}
			catch (SecurityException e)
			{
				BeetlException ex = new BeetlException(BeetlException.FUNCTION_INVALID);
				ex.pushToken(token);
				throw ex;
			}
		}

		Type lastType = new Type(c);
		if (vas == null)
		{
			this.type = lastType;
			return;
		}
		else
		{

			Type t = null;
			for (VarAttribute attr : vas)
			{
				inferCtx.temp = lastType;
				attr.infer(inferCtx);
				t = lastType;
				lastType = attr.type;
				attr.type = t;

			}
			this.type = lastType;
		}

	}

}
