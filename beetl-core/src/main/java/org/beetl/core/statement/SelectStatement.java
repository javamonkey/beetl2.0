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
import org.beetl.core.misc.ALU;

/** same with switch-case
 * @author joelli
 *
 */
public class SelectStatement extends Statement {

	public Expression value;
	public Expression[] conditions;
	public BlockStatement[] blocks;
	public BlockStatement defaultBlock;

	public SelectStatement(Expression value, Expression[] conditions, BlockStatement[] blocks,
			BlockStatement defaultBlock, GrammarToken token) {
		super(token);
		this.value = value;
		this.conditions = conditions;
		this.blocks = blocks;
		this.defaultBlock = defaultBlock;
	}

	@Override
	public void execute(Context ctx) {
		Object base = null;
		if (value != null) {
			base = value.evaluate(ctx);
			if (base == null) {
				BeetlException ex = new BeetlException(BeetlException.NULL);
				ex.pushToken(value.token);
				throw ex;
			}

		}

		boolean isMatch = false;
		for (int i = 0; i < conditions.length; i++) {
			Expression exp = conditions[i];
			Object condValue = exp.evaluate(ctx);

			if (value == null) {
				if (condValue instanceof Boolean) {
					isMatch = (Boolean) condValue;
				} else {
					BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
					be.pushToken(exp.token);
					throw be;
				}
			} else {
				if (ALU.equals(base, condValue)) {
					isMatch = true;
				}
			}

			if (isMatch) {

				BlockStatement block = this.blocks[i];
				if (block != null) {
					block.execute(ctx);
				}

				break;

			}

		}

		if (!isMatch && defaultBlock != null) {
			defaultBlock.execute(ctx);
		}

	}


}
