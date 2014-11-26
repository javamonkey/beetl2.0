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

import java.util.Collections;
import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.IteratorStatus;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.BeetlParserException;

/** for(user:list){}elsefor{}
 * @author joelli
 *
 */
public final class ForStatement extends Statement implements IGoto
{
	public Expression idNode;
	public Expression exp;
	public Statement forPart;
	public Statement elseforPart;
	public boolean hasGoto = false;
	public short itType = 0;
	public boolean hasSafe;

	/**
	 * for(idNode in exp) {forPath}elsefor{elseforPart}
	 * @param idNode
	 * @param exp
	 * @param forPart
	 * @param elseforPart
	 * @param token
	 */
	public ForStatement(VarDefineNode idNode, Expression exp, boolean hasSafe, Statement forPart,
			Statement elseforPart, GrammarToken token)
	{
		super(token);
		this.idNode = idNode;
		this.exp = exp;
		this.hasSafe = hasSafe;
		this.elseforPart = elseforPart;
		this.forPart = forPart;

	}

	public final void execute(Context ctx)
	{
		// idNode 是其后设置的
		int varIndex = ((IVarIndex) idNode).getVarIndex();
		Object collection = exp.evaluate(ctx);
		IteratorStatus it = null;
		if (collection == null)
		{
			if (!this.hasSafe)
			{
				BeetlException ex = new BeetlException(BeetlException.NULL);
				ex.pushToken(exp.token);
				throw ex;
			}
			else
			{
				it = new IteratorStatus(Collections.EMPTY_LIST);
			}

		}
		else
		{
			it = IteratorStatus.getIteratorStatusByType(collection, itType);
			if (it == null)
			{
				BeetlParserException ex = new BeetlParserException(BeetlParserException.COLLECTION_EXPECTED_ERROR);
				ex.pushToken(exp.token);
				throw ex;
			}
		}

		ctx.vars[varIndex + 1] = it;
		// loop_index
		//		ctx.vars[varIndex+2] = 0;
		//		ctx.vars[varIndex+3] = it.getSize();
		//		
		if (this.hasGoto)
		{

			while (it.hasNext())
			{
				ctx.vars[varIndex] = it.next();
				forPart.execute(ctx);
				switch (ctx.gotoFlag)
				{
					case IGoto.NORMAL:
						break;
					case IGoto.CONTINUE:
						ctx.gotoFlag = IGoto.NORMAL;
						continue;
					case IGoto.RETURN:
						return;
					case IGoto.BREAK:
						ctx.gotoFlag = IGoto.NORMAL;
						return;
				}
			}

			if (!it.hasData())
			{
				if (elseforPart != null)
					elseforPart.execute(ctx);
			}
			return;

		}
		else
		{
			while (it.hasNext())
			{
				ctx.vars[varIndex] = it.next();
				forPart.execute(ctx);

			}
			if (!it.hasData())
			{
				if (elseforPart != null)
					elseforPart.execute(ctx);
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
		exp.infer(inferCtx);
		if (exp.getType().types != null)
		{

			if (Map.class.isAssignableFrom(exp.getType().cls))
			{
				idNode.type = Type.mapEntryType;

			}
			else
			{
				//list or array
				idNode.type = exp.getType().types[0];
			}

		}
		else
		{
			idNode.type = Type.ObjectType;
		}

		int index = ((IVarIndex) idNode).getVarIndex();
		inferCtx.types[index] = idNode.type;
		inferCtx.types[index + 1] = new Type(IteratorStatus.class, idNode.type.cls);
		forPart.infer(inferCtx);
		if (elseforPart != null)
		{
			elseforPart.infer(inferCtx);
		}

	}

}
