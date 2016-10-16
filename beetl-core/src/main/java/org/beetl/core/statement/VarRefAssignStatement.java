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
import org.beetl.core.om.ObjectAA;
import org.beetl.core.parser.BeetlParser.VarAttributeVirtualContext;

/**
 * var xxx.cc = exp;
 * @author joelli
 *
 */
public class VarRefAssignStatement extends VarAssignStatement
{

	protected int varIndex;
	public Expression exp;
	public VarRef varRef;
	protected VarAttribute lastVarAttribute = null;

	public VarRefAssignStatement(Expression exp, VarRef varRef)
	{
		super(exp,exp.token);
		this.exp = exp;
		this.varRef = varRef;
		lastVarAttribute = varRef.attributes[varRef.attributes.length-1];
	}

	public void execute(Context ctx)
	{
		Object value =  exp.evaluate(ctx);
		Object obj = varRef.evaluateUntilLast(ctx);
		Object key = null;
		if(lastVarAttribute instanceof VarSquareAttribute){
			key  = (((VarSquareAttribute)lastVarAttribute).exp).evaluate(ctx);
			
			
		}else {
			key = lastVarAttribute.name;
		}
		try{
			ObjectAA.defaultObjectAA().setValue(obj, key, value);
		}catch(ClassCastException ex){
			BeetlException bx = new BeetlException(BeetlException.ATTRIBUTE_INVALID,ex);
			bx.pushToken(lastVarAttribute.token);
			throw bx;
		}catch(BeetlException be){
			be.pushToken(lastVarAttribute.token);
			throw be;
		}
		
		

	}
	

	public int getVarIndex()
	{
		return varIndex;
	}

	public void setVarIndex(int varIndex)
	{
		this.varIndex = varIndex;
	}

	public void infer(InferContext inferCtx)
	{
		//赋值不需要做类型推测
	}

}
