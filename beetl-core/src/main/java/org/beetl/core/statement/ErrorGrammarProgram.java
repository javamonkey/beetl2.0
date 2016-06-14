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
import org.beetl.core.ErrorHandler;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.exception.BeetlException;

/**
 * 语法错的时候处理错误
 * @author joelli
 *
 */

public class ErrorGrammarProgram extends Program
{
	BeetlException exception = null;

	public ErrorGrammarProgram(Resource res, GroupTemplate gt, String cr)
	{
		super();
		this.res = res;
		this.rs = res;
		this.gt = gt;
		this.metaData = new ProgramMetaData() {
			public void initContext(Context ctx)
			{
				//do nothing;
			}

			protected void putGlobaToArray(Context ctx)
			{
				//do nothing;
			}

			public AjaxStatement getAjax(String anchor)
			{
				return new AjaxStatement(null, null,true) {
					public void execute(Context ctx)
					{
						ErrorGrammarProgram.this.execute(ctx);

					}
				};
			}
		};
		this.metaData.lineSeparator = cr;
	}

	public void execute(Context ctx)
	{
		ErrorHandler errorHandler = this.gt.getErrorHandler();
		if (errorHandler == null)
			throw exception;
		//		Writer w = BeetlUtil.getWriterByByteWriter(ctx.byteWriter);
		//		errorHandler.processExcption(exception, w);
		throw exception;
	}

	public BeetlException getException()
	{
		return exception;
	}

	public void setException(BeetlException exception)
	{
		this.exception = exception;
		this.exception.gt = this.gt;
		//		this.exception.pushResource(this.id);
		this.exception.cr = this.metaData.lineSeparator;
	}

}
