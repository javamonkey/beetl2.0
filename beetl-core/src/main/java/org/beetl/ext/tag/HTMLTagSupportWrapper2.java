package org.beetl.ext.tag;

import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;

/**
 * 新的实现，tabody延迟渲染
 * @author xiadnafu
 *
 */
public class HTMLTagSupportWrapper2 extends HTMLTagSupportWrapper {
	@Override
	protected void callHtmlTag(String path) {
		Template t = null;
		t = gt.getTemplate(path, this.ctx.getResourceId());

		t.binding(ctx.globalVar);

		if (args.length == 2) {
			Map<String, Object> map = (Map<String, Object>) args[1];
			for (Entry<String, Object> entry : map.entrySet()) {
				t.binding(entry.getKey(), entry.getValue());

			}
		}
		/*
		 * 模板需要调用方法 与默认实现不同，并没有先渲染body体，而是延迟处理， 等待调用的时候在获取tag体内容
		 * 
		 */
		t.binding("tagBody", new Object() {
			@Override
			public String toString() {
				try {
					return HTMLTagSupportWrapper2.super.getBodyContent().toString();
				} catch (BeetlException ex) {
					ex.inTagBody = true;
					throw ex;
				}


			}
		});

		t.renderTo(ctx.byteWriter);
	}
}
