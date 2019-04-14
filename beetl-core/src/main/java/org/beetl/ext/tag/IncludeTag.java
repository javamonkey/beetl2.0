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
package org.beetl.ext.tag;

import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.ByteWriter;
import org.beetl.core.Resource;
import org.beetl.core.Template;
import org.beetl.core.tag.Tag;

public class IncludeTag extends Tag {

	@Override
	public void render() {
		String resourceId = getRelResourceId();

		Template t = gt.getTemplate(resourceId, this.ctx.getResourceId());
		// 快速复制父模板的变量
		t.binding(this.ctx.globalVar);
		if (this.args.length == 2) {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) this.args[1];
			for (Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				t.binding(entry.getKey(), value);
			}
		}

		ByteWriter bw = ctx.byteWriter;
		t.renderTo(bw);

	}

	protected String getRelResourceId() {

		Resource sibling = ctx.getResource();
		// 不要使用resource的loder，因为有可能是
		return gt.getResourceLoader().getResourceId(sibling, (String) this.args[0]);

	}
}
