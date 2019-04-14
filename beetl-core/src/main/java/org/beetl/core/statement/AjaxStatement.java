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

/** #ajax id:{...}
 * @author joelli
 *
 */
public class AjaxStatement extends Statement {

	public BlockStatement block;
	// ajax 片段是否默认被渲染出来
	boolean defaultRender = true;
	String ajaxId = null;
	ProgramMetaData localProgramMetaData = null;


	public AjaxStatement(BlockStatement block, GrammarToken token, boolean defaultRender) {
		super(token);
		this.block = block;
		this.defaultRender = defaultRender;
		this.ajaxId = token.text;

	}

	@Override
	public void execute(Context ctx) {
		if (ctx.template.ajaxId == null && (!defaultRender)) {
			// 渲染整个模板情况下，设置成不渲染
			return;
		}
		block.execute(ctx);

	}

	public ProgramMetaData getLocalProgramMetaData() {
		return localProgramMetaData;
	}

	public void setLocalProgramMetaData(ProgramMetaData localProgramMetaData) {
		this.localProgramMetaData = localProgramMetaData;
	}
}
