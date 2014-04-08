package org.beetl.core.resource;

import java.io.File;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;

public class FileResourceLoader implements ResourceLoader
{

	String root = null;
	String charset = "UTF-8";
	boolean autouCheck = false;

	public FileResourceLoader()
	{
		this.root = System.getProperty("user.dir");
	}

	public FileResourceLoader(String root)
	{
		this.root = root;
	}

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
	public boolean isModified(Resource key)
	{
		if (this.autouCheck)
		{
			return key.isModified();
		}
		else
		{
			return false;
		}
	}

	public boolean isAutouCheck()
	{
		return autouCheck;
	}

	public void setAutouCheck(boolean autouCheck)
	{
		this.autouCheck = autouCheck;
	}

	public String getRoot()
	{
		return root;
	}

	public void setRoot(String root)
	{
		this.root = root;
	}

	public String getCharset()
	{
		return charset;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

}
