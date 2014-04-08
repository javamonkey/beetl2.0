package org.beetl.core.resource;

import java.io.Reader;
import java.io.StringReader;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;

public class StringTemplateResource extends Resource
{

	public StringTemplateResource(String template, ResourceLoader resourceLoader)
	{
		super(template, resourceLoader);

	}

	@Override
	public Reader openReader()
	{

		return new StringReader(this.id);
	}

	@Override
	public boolean isModified()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
