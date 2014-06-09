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

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.ByteWriter;
import org.beetl.core.Tag;
import org.beetl.core.Template;
import org.beetl.core.misc.BeetlUtil;

public class IncludeTag extends Tag
{

	@Override
	public void render()
	{
		String resourceId = BeetlUtil.getRelPath(ctx.getResourceId(), (String) this.args[0]);
		;

		Template t = this.gt.getTemplate(resourceId);
		t.isRoot = false;
		//快速复制父模板的变量
		t.binding(this.ctx.globalVar);
		if (ctx.objectKeys != null && ctx.objectKeys.size() != 0)
		{
			t.dynamic(ctx.objectKeys);
		}

		if (this.args.length == 2)
		{
			Map<String, Object> map = (Map<String, Object>) this.args[1];
			for (Entry<String, Object> entry : map.entrySet())
			{
				Object value = entry.getValue();
				if (value instanceof Map || value instanceof Collection)
				{
					t.binding((String) entry.getKey(), value, true);
				}
				else
				{
					t.binding((String) entry.getKey(), value);
				}

			}

		}

		ByteWriter bw = ctx.byteWriter;
		t.renderTo(bw);

	}

	protected String getRelResourceId()
	{

		String resourceId = ((String) this.args[0]);
		String relResourceId = null;
		if (resourceId != null && resourceId.length() != 0)
		{
			char cs = resourceId.charAt(0);
			if (!(cs == '\\' || cs == '/'))
			{
				//相对路径
				String siblings = this.ctx.getResourceId();
				int i = siblings.length() - 1;
				for (; i > 0; i--)
				{
					char c = siblings.charAt(i);
					if (c == '\\' || c == '/')
					{
						break;
					}
				}

				String parent = siblings.substring(0, i + 1);

				relResourceId = parent.concat(resourceId);
			}
			else
			{
				relResourceId = resourceId;
			}
			if (BeetlUtil.isOutsideOfRoot(relResourceId))
			{
				throw new RuntimeException("不能访问外部文件或者模板");
			}
			return relResourceId;
		}
		else
		{
			throw new RuntimeException("资源ID为空，参数错");
		}

	}
}
