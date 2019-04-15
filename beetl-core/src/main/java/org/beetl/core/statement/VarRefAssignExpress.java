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
import org.beetl.core.exception.BeetlException;

import org.beetl.core.om.AABuilder;
import org.beetl.core.om.AttributeAccess;
import org.beetl.core.om.ObjectSetterUtil;


/**
 * call(xxx.cc = exp); 返回是exp
 * @author joelli
 *
 */
public class VarRefAssignExpress extends Expression implements IVarIndex {

	public Expression exp;
	public VarRef varRef;
	protected VarAttribute lastVarAttribute = null;
	protected int varIndex = -1;

	public VarRefAssignExpress(Expression exp, VarRef varRef) {
		super(varRef.token);
		this.exp = exp;
		this.varRef = varRef;
		if (varRef.attributes.length == 0) {
			lastVarAttribute = null;
		} else {
			lastVarAttribute = varRef.attributes[varRef.attributes.length - 1];

		}
	}

	public Object evaluate(Context ctx) {
		Object value = exp.evaluate(ctx);
		if (lastVarAttribute == null) {

			ctx.vars[varIndex] = value;
			return value;
		}
		Object obj = varRef.evaluateUntilLast(ctx);
		Object key = null;

		if (lastVarAttribute instanceof VarSquareAttribute) {
			key = (((VarSquareAttribute) lastVarAttribute).exp).evaluate(ctx);
		} else {
			key = lastVarAttribute.name;
		}

		if(obj==null){
			BeetlException bx = new BeetlException(BeetlException.NULL);
			bx.pushToken(varRef.token);
			throw bx;
		}

		try {

			AttributeAccess aa= AABuilder.buildFiledAccessor(obj.getClass());
			aa.setValue(obj,key,value);

			return value;
		
		} catch (ClassCastException ex) {
			BeetlException bx = new BeetlException(BeetlException.ATTRIBUTE_INVALID, ex);
			bx.pushToken(lastVarAttribute.token);
			throw bx;
		} catch (BeetlException be) {
			be.pushToken(lastVarAttribute.token);
			throw be;
		}

//		return value;

	}


	@Override
	public void setVarIndex(int index) {
		varIndex = index;

	}

	@Override
	public int getVarIndex() {
		// TODO Auto-generated method stub
		return varIndex;
	}

}
