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

import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.BodyContent;
import org.beetl.core.Resource;
import org.beetl.core.Tag;
import org.beetl.core.Template;

/**
 * 提供一个布局功能，每个页面总是由一定布局，如页面头，菜单，页面脚，以及正文 layout标签允许为正文指定一个布局，如下使用方式
 * <p>
 * 
 * content.html内容如下：
 * 
 * <pre>
 * &lt;%layout(&quot;/org/bee/tl/samples/layout.html&quot;){%&gt;
 *    this is 正文  
 *    ..........
 *    &lt;%}%&gt;
 * </pre>
 * 
 * layout.html 是布局文件，内容如下·
 * 
 * <pre>
 * this is header
 *    this is content:${layoutContent}
 *    this is footer:
 * </pre>
 * <p>
 * 运行content.html模板文件后，，正文文件的内容将被替换到layoutContent的地方，变成如下内容
 * 
 * <pre>
 * this is header
 *    this is content:this is 正文  
 *    ............
 *    this is footer:
 * </pre>
 * 
 * 如果向布局传入参数，则可以使用这种格式
 * <p></p>
 * layout(path,{'paraName1':value1,'paraName2',value2})
 * 
 * 如果变量layoutContent与模板有冲突，可以作为第三个参数传入到layout变量里，如：
 * layout(path,{},"xxxLayoutContent");
 * @author joelli
 * @since 2.0
 * 
 */
public class LayoutTag extends Tag
{
	public static String defaultLayoutName = "layoutContent";

	@Override
	public void render()
	{
		if (args.length == 0 || args.length > 3)
		{
			throw new RuntimeException("参数错误，期望child,map");
		}
		String layoutFile = getRelResourceId();
		Template t = this.gt.getTemplate(layoutFile, this.ctx.getResourceId());

		t.binding(ctx.globalVar);
		t.dynamic(ctx.objectKeys);

		if (args.length >= 2)
		{
			Map<String, Object> map = (Map<String, Object>) args[1];
			for (Entry<String, Object> entry : map.entrySet())
			{
				t.binding(entry.getKey(), entry.getValue());
			}
		}

		BodyContent content = this.getBodyContent();
		if (args.length == 3)
		{

			t.binding((String) args[2], content);
		}
		else
		{
			t.binding(defaultLayoutName, content);
		}
		t.renderTo(ctx.byteWriter);

	}

	protected String getRelResourceId()
	{

		Resource sibling = ctx.getResource();
		return gt.getResourceLoader().getResourceId(sibling, (String) this.args[0]);

	}

}
