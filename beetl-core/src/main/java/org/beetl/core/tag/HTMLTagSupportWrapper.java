package org.beetl.core.tag;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.statement.Statement;

/**
 *  {@codeHTMLTagSupportWrapper} 封装了html 标签调用，转为Beetl转为真正的{@link Tag}  执行
 * @author xiadnafu
 *
 */
public class HTMLTagSupportWrapper extends  Tag {
	
	protected String tagRoot = null;
	protected String tagSuffix = null;

	
	@Override
	public void render() {
		if (args.length == 0 || args.length > 2) {
			throw new RuntimeException("参数错误，期望child,Map .....");
		}
		//标签名称
		String child = (String) args[0];
		// 首先查找 已经注册的Tag
		TagFactory tagFactory = null;
		String functionTagName = child.replace(':', '.');
		tagFactory = this.gt.getTagFactory(functionTagName);
		if (tagFactory == null) {
			//模板实现html标签
			String path = getHtmlTagResourceId(child);
			callHtmlTag(path);

		} else {
			//标签函数实现html标签
			callTag(tagFactory);
		}

	}

	protected String getHtmlTagResourceId(String child) {
		String path = child.replace(':', '/');
		StringBuilder sb = new StringBuilder("/");
		sb.append(this.tagRoot).append("/").append(path).append(".").append(this.tagSuffix);
		return sb.toString();
	}



	protected void callTag(TagFactory tagFactory) {

		Tag tag = tagFactory.createTag();
		tag.init(ctx, args, bs);
		tag.render();
		tag.afterRender();

	}

	@Override
	public void init(Context ctx, Object[] args, Statement st) {
		super.init(ctx, args, st);
		tagRoot = ctx.gt.getConf().getResourceMap().get("tagRoot");
		tagSuffix = ctx.gt.getConf().getResourceMap().get("tagSuffix");
	}

	public Map getAttrs() {
		if (this.args.length == 1) {
			return Collections.emptyMap();
		} else {
			return (Map) this.args[1];
		}

	}
	
	
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
					return HTMLTagSupportWrapper.super.getBodyContent().toString();
				} catch (BeetlException ex) {
					ex.inTagBody = true;
					throw ex;
				}


			}
		});

		t.renderTo(ctx.byteWriter);
	}
}
