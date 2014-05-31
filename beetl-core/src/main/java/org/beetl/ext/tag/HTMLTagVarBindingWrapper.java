package org.beetl.ext.tag;

import org.beetl.core.Context;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.core.TagVarBinding;
import org.beetl.core.statement.Statement;

public class HTMLTagVarBindingWrapper extends Tag implements TagVarBinding
{

	Tag tag = null;

	@Override
	public void render()
	{
		tag.render();

	}

	public Object[] bindVars()
	{

		return ((TagVarBinding) tag).bindVars();
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
		tag = tagFactory.createTag();
		if (tag == null)
		{
			throw new RuntimeException("找不到注册的Tag");

		}
		else if (!(tag instanceof TagVarBinding))
		{
			throw new RuntimeException(tag.getClass() + " 必须是TagVarBinding的实现类");
		}

		tag.init(ctx, args, st);

	}

}
