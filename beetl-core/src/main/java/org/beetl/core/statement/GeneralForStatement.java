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
 * 
 * for(var a=0;a &lt;10;i++){}elsefor{}
 * @author joelli
 *
 */
public class GeneralForStatement extends Statement implements IGoto
{
	public Expression[] expInit;
	public Expression condtion;
	public Expression[] expUpdate;
	public Statement forPart;
	public Statement elseforPart;
	public VarAssignStatementSeq varAssignSeq;
	public boolean hasGoto = false;
	public short itType = 0;

	//for(expInit;condtion;expUpdate){}
	public GeneralForStatement(VarAssignStatementSeq varAssignSeq, Expression[] expInit, Expression condtion,
			Expression[] expUpdate, Statement forPart, Statement elseforPart, GrammarToken token)
	{
		super(token);
		this.varAssignSeq = varAssignSeq;
		this.expInit = expInit;
		this.condtion = condtion;
		this.expUpdate = expUpdate;
		this.elseforPart = elseforPart;
		this.forPart = forPart;

	}

	public void execute(Context ctx)
	{
		if (expInit != null)
		{
			for (Expression exp : expInit)
			{
				exp.evaluate(ctx);
			}
		}
		if (varAssignSeq != null)
		{
			varAssignSeq.execute(ctx);
		}
		//todo 需要提高效率，减少hasLooped赋值，以及每次gotoFlag检测，然而，这个不太常用，目前不优化

//		boolean hasLooped = false;
		for (;;)
		{
			Object val = condtion.evaluate(ctx);
			boolean bool = false;
			if (val instanceof Boolean)
			{
				bool = ((Boolean) val).booleanValue();
			}
			else
			{
				BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
				be.pushToken(condtion.token);
				throw be;
			}

			if (bool)
			{
//				hasLooped = true;
				forPart.execute(ctx);
				switch (ctx.gotoFlag)
				{
					case IGoto.NORMAL:
						break;
					case IGoto.CONTINUE:
						ctx.gotoFlag = IGoto.NORMAL;
						break;
					case IGoto.RETURN:
						return;
					case IGoto.BREAK:
						ctx.gotoFlag = IGoto.NORMAL;
						return;
				}

			}
			else
			{
				break;
			}

			if (this.expUpdate != null)
			{
				for (Expression exp : expUpdate)
				{
					exp.evaluate(ctx);
				}
			}

		}

	}

	@Override
	public final boolean hasGoto()
	{
		// TODO Auto-generated method stub
		return hasGoto;
	}

	@Override
	public final void setGoto(boolean occour)
	{
		this.hasGoto = occour;

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		if (expInit != null)
		{
			for (Expression exp : expInit)
			{
				exp.infer(inferCtx);

			}
		}

		if (varAssignSeq != null)
		{
			varAssignSeq.infer(inferCtx);
		}

		if (condtion != null)
		{
			condtion.infer(inferCtx);
		}

		if (expUpdate != null)
		{
			for (Expression exp : expUpdate)
			{
				exp.infer(inferCtx);

			}
		}

		forPart.infer(inferCtx);
		if (elseforPart != null)
		{
			elseforPart.infer(inferCtx);
		}

	}

}
