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
	private String prefix = "";
	boolean checkModified = false;
	protected String charset = "UTF-8";

	public ClasspathResourceLoader()
	{

	}

	public ClasspathResourceLoader(String prefix)
	{

		this.prefix = prefix;

	}

	public ClasspathResourceLoader(String prefix, String charset)
	{

		this.prefix = prefix;
		this.charset = charset;
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

	public String getCharset()
	{
		return charset;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

}
