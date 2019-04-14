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
import org.beetl.core.fun.ObjectUtil;
import org.beetl.core.tag.Tag;
import org.beetl.core.tag.TagFactory;

/**
 * 标签，如:
 * <pre>
 * cache(){
 * ......
 * }
 * </pre>
 * @author joelli
 *
 */
public class TagStatement extends Statement {

	String tagName;
	public Expression[] paras;
	public Statement block;

	public TagStatement(String tagName, Expression[] paras, Statement block, GrammarToken token) {
		super(token);
		this.tagName = tagName;
		this.paras = paras;
		this.block = block;

	}

	@Override
	public void execute(Context ctx) {
		Tag tag = null;
		try {
			TagFactory tagFactory = ctx.gt.getTagFactory(this.tagName);
			tag = tagFactory.createTag();
			Object[] args = null;
			if (paras.length == 0) {
				args = ObjectUtil.EMPTY_OBJECT_ARRAY;
			} else {
				args = new Object[paras.length];
				for (int i = 0; i < args.length; i++) {
					args[i] = paras[i].evaluate(ctx);
				}

			}

			tag.init(ctx, args, block);
			runTag(tag, ctx);
		} catch (BeetlException ex) {
			if (!ex.inTagBody) {
				ex.pushToken(this.token);
			}
			throw ex;
		} catch (RuntimeException ex) {
			BeetlException bex = new BeetlException(BeetlException.TAG_INSTANCE_ERROR, ex.getMessage(), ex);
			bex.pushToken(token);
			throw bex;
		}

	}

	protected void runTag(Tag tag, Context ctx) {
		try {

			tag.render();
			tag.afterRender();
		} catch (BeetlException ex) {
			// BeetlException异常时不要设置token，因为抛出的地方已经设置了
			throw ex;
		} catch (RuntimeException ex) {
			BeetlException be = new BeetlException(BeetlException.ERROR, "tag执行抛错", ex);
			be.pushToken(token);
			throw be;
		}
	}


}
