package org.beetl.core.resource;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;

/**
 * 
 * @author joelli
 * @version 2012-10-30
 * 
 */
public class ClasspathResourceLoader implements ResourceLoader
{
	private String prefix;
	boolean checkModified = false;

	public ClasspathResourceLoader()
	{
		this("");
	}

	public ClasspathResourceLoader(String prefix)
	{
		if (prefix == null || prefix.trim().isEmpty())
		{
			this.prefix = "/";
			return;
		}
		this.prefix = prefix;
		if (!prefix.startsWith("/"))
		{
			this.prefix = "/" + this.prefix;
		}
		if (!prefix.endsWith("/"))
		{
			this.prefix = this.prefix + "/";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.beetl.core.ResourceLoader#getResource(java.lang.String)
	 */
	@Override
	public Resource getResource(String key)
	{

		Resource resource = new ClasspathResource(key, prefix + key, this);
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.beetl.core.ResourceLoader#close()
	 */
	@Override
	public void close()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isModified(Resource key)
	{
		if (this.checkModified)
		{
			return key.isModified();
		}
		else
		{
			return false;
		}
	}

	public boolean isCheckModified()
	{
		return checkModified;
	}

	public void setCheckModified(boolean checkModified)
	{
		this.checkModified = checkModified;
	}

	public String getPrefix()
	{
		return prefix;
	}

	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}

}
