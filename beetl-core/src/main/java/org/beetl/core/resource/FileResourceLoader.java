package org.beetl.core.resource;

import java.io.File;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;

public class FileResourceLoader implements ResourceLoader
{

	String root = null;
	String charset = null;

	public FileResourceLoader(String root, String charset)
	{
		this.root = root;
		this.charset = charset;
	}

	@Override
	public Resource getResource(String key)
	{
		File file = new File(root, key);
		Resource resource = new FileResource(file, key, this);
		resource.setResourceLoader(this);
		return resource;

	}

	@Override
	public void close()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isModified(String key)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
