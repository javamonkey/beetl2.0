/*
 [The "BSD license"]
 Copyright (c) 2011-NOW  闲大赋 (李家智)
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

/**while(exp)  whileBody
 * @author joelli
 *
 */
public class WhileStatement extends Statement implements IGoto {

	public Expression exp;
	public Statement whileBody;
	public boolean hasGoto = false;

	public WhileStatement(Expression exp, Statement whileBody, GrammarToken token) {
		super(token);
		this.exp = exp;
		this.whileBody = whileBody;
		if (this.whileBody instanceof BlockStatement) {
			this.hasGoto = ((BlockStatement) whileBody).hasGoto;
		}
	}

	@Override
	public void execute(Context ctx) {
		if (this.hasGoto) {
			while (true) {
				Object result = exp.evaluate(ctx);
				if (result instanceof Boolean) {
					if ((Boolean) result) {
						whileBody.execute(ctx);
						switch (ctx.gotoFlag) {
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
					} else {
						break;
					}

				} else {
					BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
					be.pushToken(exp.token);
					throw be;
				}

			}
		} else {

			while (true) {
				Object result = exp.evaluate(ctx);
				if (result instanceof Boolean) {
					if ((Boolean) result) {
						whileBody.execute(ctx);

					} else {
						break;
					}

				} else {
					BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
					be.pushToken(exp.token);
					throw be;
				}
			}

		}
	}


	@Override
	public boolean hasGoto() {
		return this.hasGoto;
	}

	@Override
	public void setGoto(boolean occour) {
		this.hasGoto = occour;

	}

}
