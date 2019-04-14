/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智) xiandafu@126.com
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
package org.beetl.core.tag;

import org.beetl.core.BodyContent;
import org.beetl.core.ByteWriter;
import org.beetl.core.Context;
import org.beetl.core.GroupTemplate;
import org.beetl.core.statement.Statement;

import java.util.Map;

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
 * Beetl的标签函数可以转化HTML标签风格，参考{@link HTMLTagSupportWrapper}
 * 
 * @author joeli
 */
public abstract class Tag {
	//标签函数参数，同Function，如果是HTML标签，则参数0是html标签内容，参数1是Map，所有的html属性
	protected Object[] args = null;
	protected GroupTemplate gt;
	protected Context ctx;
	protected ByteWriter bw;
	//标签体
	protected Statement bs;
	//父标签
	protected Tag parent;

	/**
	 *  主要方法：渲染标签体
	 */
	protected void doBodyRender() {

		bs.execute(ctx);

	}

	/**
	 * 得到内容暂时保存在BodyContent。如果不需要保存直接输出，可以调用doBodyRender
	 * @return
	 */
	protected BodyContent getBodyContent() {
		ByteWriter writer = ctx.byteWriter;
		ByteWriter tempWriter = ctx.byteWriter.getTempWriter(writer);
		ctx.byteWriter = tempWriter;
		doBodyRender();
		ctx.byteWriter = writer;
		return tempWriter.getTempConent();
	}

	public abstract void render();

	public void afterRender() {
		ctx.setCurrentTag(parent);
	}

	public void init(Context ctx, Object[] args, Statement st) {
		inintBase(ctx, args, st);
		setTagParent();

	}

	protected void inintBase(Context ctx, Object[] args, Statement st){
		this.ctx = ctx;
		this.bw = ctx.byteWriter;
		this.gt = ctx.gt;
		this.args = args;
		this.bs = st;
	}

	protected void setTagParent(){
		this.parent = ctx.getCurrentTag();
		ctx.setCurrentTag(this);
	}

	public Tag getParent() {
		return parent;
	}

	public Object[] getArgs() {
		return this.args;
	}

	/**
	 * 获取html属性，注意，html属性中“-”符号会去掉转为下一个首字母大写
	 * @param attrName
	 * @return
	 */
	public Object getHtmlAttribute(String attrName){
		//html 标签 第一个参数是标签名字，第二个是所有属性
		if(args.length!=2){
			throw new IllegalStateException("非html标签");
		}
		Object obj = (Object) args[1];
		if(!(obj instanceof Map)){
			throw new IllegalStateException("非html标签");
		}

		return ((Map)obj).get(attrName);
	}


}
