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
package org.beetl.core.tag;

import java.util.LinkedHashMap;

import org.beetl.core.Context;
import org.beetl.core.statement.Statement;

/**
 * {@link GeneralVarTagBinding} 的html标签封装，带变量绑定的html标签调用的标签
 * @author joelli
 *
 */
public class HTMLTagVarBindingWrapper extends Tag 
{

	GeneralVarTagBinding tag = null;

	@Override
	public void render()
	{
		tag.render();

	}


	public void mapName2Index(LinkedHashMap<String, Integer> map)
	{
		
		tag.mapName2Index(map);
	}

	public void init(Context ctx, Object[] args, Statement st)
	{
		super.init(ctx, args, st);
		if (args.length == 0 || args.length > 3)
		{
			throw new RuntimeException("参数错误，期望child,Map .....");
		}
		String child = (String) args[0];
		// 已经注册的Tag
		TagFactory tagFactory = null;
		String functionTagName = child.replace(':', '.');
		tagFactory = this.gt.getTagFactory(functionTagName);
		if (tagFactory == null)
		{
			throw new RuntimeException("标签初始化错误，未找到指定的标签实现类" + functionTagName);
		}
		Tag temp = tagFactory.createTag();
		if (temp == null)
		{
			throw new RuntimeException("找不到注册的Tag");

		}
		else if (!(temp instanceof GeneralVarTagBinding))
		{
			throw new RuntimeException(tag.getClass() + " 必须是TagVarBinding的实现类");
		}

		this.tag = ((GeneralVarTagBinding)temp);
		tag.init(ctx, args, st);

	}

}
