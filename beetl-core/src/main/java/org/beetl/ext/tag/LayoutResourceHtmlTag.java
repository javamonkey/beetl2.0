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
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.tag.Tag;

/**
 * 同layoutTag，采用html方式布局
 * <#html:layout parent="" attr1="" attr2="">
 * 
 * </#html:layout>
 * 
 */
public class LayoutResourceHtmlTag extends Tag {
	public static String defaultLayoutName = "layoutContent";
	public static final String layoutNameAttr = "layoutContent";


	@Override
	public void render() {

		String layoutFile = getRelResourceId();
		Template t = this.gt.getTemplate(layoutFile, this.ctx.getResourceId());
		t.binding(ctx.globalVar);

		@SuppressWarnings("unchecked")
		Map<String, Object> attrs = ((Map<String, Object>) this.args[1]);
		String layoutName = attrs.containsKey(layoutNameAttr) ? (String) attrs.get(layoutNameAttr) : defaultLayoutName;
		for (Entry<String, Object> entry : attrs.entrySet()) {
			String attrName = entry.getKey();
			if (attrName.equals("parent") || attrName.equals(layoutNameAttr)) {
				// 子模板不设置file属性
				continue;
			}
			Object value = entry.getValue();
			t.binding(attrName, value);
		}

		BodyContent content = this.getBodyContent();
		t.binding(layoutName, content);
		t.renderTo(ctx.byteWriter);

	}

	protected String getRelResourceId() {
		Resource sibling = ctx.getResource();
		return gt.getResourceLoader().getResourceId(sibling, this.getTargetResource());
	}


	protected String getTargetResource() {
		@SuppressWarnings("unchecked")
		String targetResourceId = (String) ((Map<String, Object>) this.args[1]).get("parent");
		if (targetResourceId == null || targetResourceId.trim().length() == 0) {
			throw new BeetlException(BeetlException.ERROR, "缺少 parent 属性 ");
		}
		return targetResourceId;
	}

}
