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
package org.beetl.ext.tag;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.BodyContent;
import org.beetl.core.Context;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.core.Template;
import org.beetl.core.statement.Statement;

/**
 * 封装了html标签调用的标签，先寻找是否有注册的标签类，如果没有，再调用
 * htmltags目录下的html标签文件
 * @author joelli
 *
 */
public class HTMLTagSupportWrapper extends Tag
{

	protected String tagRoot = null;
	protected String tagSuffix = null;

	@Override
	public void render()
	{
		if (args.length == 0 || args.length > 2)
		{
			throw new RuntimeException("参数错误，期望child,Map .....");
		}
		String child = (String) args[0];
		// 首先查找 已经注册的Tag
		TagFactory tagFactory = null;
		String functionTagName = child.replace(':', '.');
		tagFactory = this.gt.getTagFactory(functionTagName);
		if (tagFactory == null)
		{
			String path = getHtmlTagResourceId(child);
			callHtmlTag(path);

		}
		else
		{

			callTag(tagFactory);
		}

	}

	protected String getHtmlTagResourceId(String child)
	{
		String path = child.replace(':', File.separatorChar);
		StringBuilder sb = new StringBuilder("/");
		sb.append(this.tagRoot).append("/").append(path).append(".").append(this.tagSuffix);
		return sb.toString();
	}

	protected void callHtmlTag(String path)
	{
		Template t = null;

		t = gt.getHtmlFunctionOrTagTemplate(path, this.ctx.getResourceId());

		t.binding(ctx.globalVar);
		t.dynamic(ctx.objectKeys);

		if (args.length == 2)
		{
			Map<String, Object> map = (Map<String, Object>) args[1];
			for (Entry<String, Object> entry : map.entrySet())
			{
				t.binding(entry.getKey(), entry.getValue());

			}
		}

		BodyContent bodyContent = super.getBodyContent();
		t.binding("tagBody", bodyContent);

		t.renderTo(ctx.byteWriter);
	}

	protected void callTag(TagFactory tagFactory)
	{

		Tag tag = tagFactory.createTag();
		tag.init(ctx, args, bs);
		tag.render();

	}

	public void init(Context ctx, Object[] args, Statement st)
	{
		super.init(ctx, args, st);
		tagRoot = ctx.gt.getConf().getResourceMap().get("tagRoot");
		tagSuffix = ctx.gt.getConf().getResourceMap().get("tagSuffix");
	}

}
