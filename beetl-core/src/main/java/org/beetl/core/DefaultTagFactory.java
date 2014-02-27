package org.beetl.core;

import org.beetl.core.exception.TempException;

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
			throw new TempException(e.getMessage());
		}
		catch (IllegalAccessException e)
		{
			throw new TempException(e.getMessage());
		}
	}
}
