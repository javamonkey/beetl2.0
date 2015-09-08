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
package org.beetl.core;

import org.beetl.core.statement.Statement;

/**
 * 
 * 标签函数，用于处理一段模板快
 * 
 * <p></p>;
 * &lt;% cache(key){ %&gt;
 * <p></p>
 * ip=10.1.1.1
 * <p></p>
 * port=9090
 * <p></p>
 * &lt;%}&gt;
 * 
 * <p></p>
 * 
 * @author joeli
 */
public abstract class Tag
{
	protected Object[] args = null;
	protected GroupTemplate gt;
	protected Context ctx;
	protected ByteWriter bw;
	protected Statement bs;

	protected void doBodyRender()
	{

		bs.execute(ctx);

	}

	protected BodyContent getBodyContent()
	{
		ByteWriter writer = ctx.byteWriter;
		ByteWriter tempWriter = ctx.byteWriter.getTempWriter(writer);
		ctx.byteWriter = tempWriter;
		doBodyRender();
		ctx.byteWriter = writer;
		return tempWriter.getTempConent();
	}

	public abstract void render();

	public void init(Context ctx, Object[] args, Statement st)
	{
		this.ctx = ctx;
		this.bw = ctx.byteWriter;
		this.gt = ctx.gt;
		this.args = args;
		this.bs = st;
	}

}
