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

import java.util.LinkedHashMap;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.ALU;

/**
 * 类似go语言的switch
 * @author joelli
 *
 */
public class SwitchStatement extends Statement {
	public Expression value;
	LinkedHashMap<Expression, BlockStatement> map;
	// 为了类型推测方便，实际上只要map就可以了
	public Expression[] condtionsList;
	public BlockStatement[] blocks;
	// ------------
	public BlockStatement defaultBlock;

	public SwitchStatement(Expression value, LinkedHashMap<Expression, BlockStatement> map, BlockStatement defaultBlock,
			GrammarToken token) {
		super(token);
		this.map = map;
		this.value = value;
		this.condtionsList = map.keySet().toArray(new Expression[0]);
		this.blocks = map.values().toArray(new BlockStatement[0]);
		this.defaultBlock = defaultBlock;
	}

	@Override
	public void execute(Context ctx) {
		Object o = value.evaluate(ctx);
		if (o == null) {
			BeetlException ex = new BeetlException(BeetlException.NULL);
			ex.pushToken(value.token);
			throw ex;
		}

		boolean isMatch = false;
		for (Expression exp : condtionsList) {
			if (isMatch || ALU.equals(o, exp.evaluate(ctx))) {
				isMatch = true;
				BlockStatement block = map.get(exp);
				if (block != null) {
					block.execute(ctx);
					switch (ctx.gotoFlag) {
						case IGoto.NORMAL:
							break;
						case IGoto.RETURN:
							return;
						case IGoto.BREAK:
							ctx.gotoFlag = IGoto.NORMAL;
							return;
					}
				} else {
					// 匹配下一个Block
					continue;
				}
			} else {
				continue;
			}

		}

		if (!isMatch && defaultBlock != null) {
			defaultBlock.execute(ctx);
			switch (ctx.gotoFlag) {
				case IGoto.NORMAL:
					break;
				case IGoto.RETURN:
					return;
				case IGoto.BREAK:
					ctx.gotoFlag = IGoto.NORMAL;
					return;
			}
		}

	}


}
