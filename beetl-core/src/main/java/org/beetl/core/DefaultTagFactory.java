package org.beetl.core;

import org.beetl.core.exception.BeetlException;

public class DefaultTagFactory implements TagFactory
{
	Class tagCls;

	public DefaultTagFactory(Class tagCls)
	{
		this.tagCls = tagCls;
	}

	@Override
	public Tag createTag()
	{
		try
		{
			Tag tag = (Tag) tagCls.newInstance();
			return tag;
		}
		catch (InstantiationException e)
		{
			BeetlException bex = new BeetlException(BeetlException.TAG_INSTANCE_ERROR, "实例化 " + tagCls + " 出错");
			throw bex;
		}
		catch (IllegalAccessException e)
		{
			BeetlException bex = new BeetlException(BeetlException.TAG_INSTANCE_ERROR, "不能实例化 " + tagCls);
			throw bex;
		}
	}
}
