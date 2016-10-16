package org.beetl.core.resourceloader;

import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.resource.StringTemplateResource;

public class MapResourceLoader implements ResourceLoader
{
	Map data;

	public MapResourceLoader(Map data)
	{
		this.data = data;
	}

	@Override
	public Resource getResource(String key)
	{
		String content = (String) data.get(key);
		if (content == null)
			return null;
		return new StringTemplateResource(content, this);
	}

	@Override
	public boolean isModified(Resource key)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exist(String key)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GroupTemplate gt)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getResourceId(Resource resource, String id)
	{
		return id;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
