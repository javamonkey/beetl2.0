package org.beetl.core.resource;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;

public class StringTemplateResourceLoader implements ResourceLoader
{

	public StringTemplateResourceLoader()
	{

	}

	@Override
	public Resource getResource(String key)
	{
		return new StringTemplateResource(key, this);

	}

	@Override
	public void close()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isModified(Resource key)
	{
		return false;
	}

}
