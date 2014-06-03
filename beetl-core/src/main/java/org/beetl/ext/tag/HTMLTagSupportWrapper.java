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
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.core.Template;

public class HTMLTagSupportWrapper extends Tag
{

	@Override
	public void render()
	{
		if (args.length == 0 || args.length > 2)
		{
			throw new RuntimeException("参数错误，期望child,Map .....");
		}
		String child = (String) args[0];
		// 首先查找 已经注册的Tag
		TagFactory realTag = null;
		String functionTagName = child.replace(':', '.');
		realTag = this.gt.getTagFactory(functionTagName);
		if (realTag == null)
		{
			String path = getHtmlTagResourceId(child);
			callHtmlTag(path);

		}
		else
		{

			callTag(realTag);
		}

	}

	protected String getHtmlTagResourceId(String child)
	{
		String path = child.replace(':', File.separatorChar);
		return "/htmltag/" + path + ".tag";
	}

	protected void callHtmlTag(String path)
	{
		Template t = null;

		t = gt.getTemplate(path);

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

}
