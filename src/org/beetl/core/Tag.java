/*
 [The "BSD license"]
 Copyright (c) 2011-2013 Joel Li (李家智)
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




/**
 * 请使用GeneralBeetlTag
 * 
 *
 * <p/>
 * &lt;% cache(key){ %>
 * <p/>
 * ip=10.1.1.1
 * <p/>
 * port=9090
 * <p/>
 * &lt;%}%>
 * 
 * <p/>
 * @author joeli
 * @create 2011-5-31
 */
public abstract class Tag
{
	protected Object[] args = null;	
	protected ByteWriter tagBody;
	protected GroupTemplate group;
	protected Context ctx;

	public void setParas(Object[] args)
	{
		this.args = args;
	}

	/**
	 * 是否需要解析运行标签体，有些情况是不用输入文本的，譬如{@link org.bee.tl.ext.includeFileTemplate includeFileTemplate}标签，
	 * 有些情况下是要用，如{@link org.bee.tl.ext.LayoutTag layout} 标签
	 */
	public boolean requriedInput()
	{
		return true;
	}
	
	

	/**
	 * @param input 标签体的内容
	 */
	public void setInput(ByteWriter tagBody)
	{
		this.tagBody = tagBody;
	}

	/**
	 * @param ctx 上下文，可以通过__this获取template，通过__pw获取Writer， __group 获取GroupTemplate
	 */
	public void setContext(Context ctx)
	{

		this.ctx = ctx;
		

	}

	/**
	 * 将标签内容输出到里
	 * @return
	 */
	public abstract void writeTo(ByteWriter writer);

}
