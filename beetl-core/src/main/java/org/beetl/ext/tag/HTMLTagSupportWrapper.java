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
