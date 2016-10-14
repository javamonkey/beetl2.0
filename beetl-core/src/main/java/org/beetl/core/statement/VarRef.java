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
 * user.name
 * @author joelli
 *
 */
public class VarRef extends Expression implements IVarIndex
{

	public VarAttribute[] attributes;
	public Expression safe;
	public int varIndex;
	public boolean hasSafe;
	private GrammarToken firstToken = null;

	public VarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, GrammarToken token)
	{
		this(attributes, hasSafe, safe, token, token);

	}

	public VarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, GrammarToken token,
			GrammarToken firstToken)
	{
		super(token);

		this.attributes = attributes;
		this.safe = safe;
		this.hasSafe = hasSafe;
		this.firstToken = firstToken;

	}

	@Override
	public Object evaluate(Context ctx)
	{

		Object value = ctx.vars[varIndex];
		if (value == Context.NOT_EXIST_OBJECT)
		{
			if (hasSafe)
			{
				return safe == null ? null : safe.evaluate(ctx);
			}
			else
			{
				BeetlException ex = new BeetlException(BeetlException.VAR_NOT_DEFINED);
				ex.pushToken(this.firstToken);
				throw ex;
			}
		}

		if (value == null)
		{
			if (hasSafe)
			{
				return safe == null ? null : safe.evaluate(ctx);
			}
		}

		if (attributes.length == 0)
		{
			return value;
		}

		for (int i = 0; i < attributes.length; i++)
		{

			VarAttribute attr = attributes[i];
			if (value == null)
			{
				if (hasSafe)
				{
					return safe == null ? null : safe.evaluate(ctx);
				}
				else
				{
					BeetlException be = new BeetlException(BeetlException.NULL, "空指针");
					if (i == 0)
					{
						be.pushToken(this.firstToken);
					}
					else
					{
						be.pushToken(attributes[i - 1].token);
					}

					throw be;
				}

			}

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

		}

		if (value == null && hasSafe)
		{
			return safe == null ? null : safe.evaluate(ctx);
		}
		else
		{
			return value;
		}

	}
	
	
	/** 计算所有表达式，知道最后一值，用于a.b[xx].c = 1  赋值，只计算到a.b[xx]
	 * @param ctx
	 * @return
	 */
	public Object evaluateUntilLast(Context ctx){
		if (attributes.length == 0)
		{
			//不可能发生，除非beetl写错了，先放在着
			throw new RuntimeException();
		}
		Object value = ctx.vars[varIndex];
		if (value == Context.NOT_EXIST_OBJECT)
		{
			BeetlException ex = new BeetlException(BeetlException.VAR_NOT_DEFINED);
			ex.pushToken(this.firstToken);
			throw ex;
		}

		if (value == null)
		{
			BeetlException ex = new BeetlException(BeetlException.NULL);
			ex.pushToken(this.firstToken);
			throw ex;
		}

	
		for (int i = 0; i < attributes.length-1; i++)
		{

			VarAttribute attr = attributes[i];
			if (value == null)
			{
				
					BeetlException be = new BeetlException(BeetlException.NULL, "空指针");
					if (i == 0)
					{
						be.pushToken(this.firstToken);
					}
					else
					{
						be.pushToken(attributes[i - 1].token);
					}

					throw be;

			}

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

		}

		return value ;
	}

	@Override
	public void setVarIndex(int index)
	{
		this.varIndex = index;

	}

	@Override
	public int getVarIndex()
	{
		return this.varIndex;
	}

	@Override
	public void infer(InferContext inferCtx)
	{

		Type type = inferCtx.types[this.varIndex];
		Type lastType = type;
		Type t = null;
		for (VarAttribute attr : attributes)
		{
			inferCtx.temp = lastType;
			attr.infer(inferCtx);
			t = lastType;
			lastType = attr.type;
			attr.type = t;

		}
		this.type = lastType;
		//要review代码，这段在2.0.1的代码现在2.0.11才发现漏写，气人！
		if (safe != null)
		{
			safe.infer(inferCtx);
			if (!safe.type.equals(this.type))
			{
				this.type = Type.ObjectType;
			}
		}
	}

}
