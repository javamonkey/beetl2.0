package org.beetl.core.resource;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;

/**
 * 
 * @author 郭玉昆(<a href="mailto:gyk001@gmail.com">gyk001@gmail.com</a>)
 * @version 2012-10-30
 * 
 */
public class ClasspathResourceLoader implements ResourceLoader
{
	private String prefix;

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

		Resource resource = new ClasspathResource(key, prefix + key);
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

}
