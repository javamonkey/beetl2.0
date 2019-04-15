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

/**try{
 * }catch(error){
 * }
 * 
 * @author joelli
 *
 */
public class TryCatchStatement extends Statement {

	BlockStatement tryPart;
	BlockStatement catchPart;
	VarDefineNode error;

	public TryCatchStatement(BlockStatement tryPart, BlockStatement catchPart, VarDefineNode error,
			GrammarToken token) {
		super(token);
		this.tryPart = tryPart;
		this.catchPart = catchPart;
		this.error = error;
	}

	@Override
	public void execute(Context ctx) {
		try {
			tryPart.execute(ctx);

		} catch (Exception ex) {
			if (catchPart != null) {
				if (error != null) {
					if (ex instanceof BeetlException) {
						ctx.vars[error.varIndex] = ex;
					} else {
						ctx.vars[error.varIndex] = new BeetlException(BeetlException.ERROR, ex.getMessage(), ex);
					}

				}
				catchPart.execute(ctx);

			} else {

				if (ex instanceof BeetlException) {
					throw (BeetlException) ex;
				} else {
					BeetlException be = new BeetlException(BeetlException.ERROR, ex.getMessage(), ex);
					be.pushToken(tryPart.token);
					throw be;
				}
			}
		}

	}


}
