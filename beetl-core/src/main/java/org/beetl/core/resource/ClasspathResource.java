package org.beetl.core.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.BeetlException;

public class ClasspathResource extends Resource
{
	String path = null;

	File file = null;
	long lastModified = 0;

	public ClasspathResource(String key, String path, ResourceLoader loader)
	{
		super(key, loader);
		this.path = path;
	}

	@Override
	public Reader openReader()
	{

		URL url = ClasspathResource.class.getResource(path);

		InputStream is;
		try
		{
			is = url.openStream();
		}
		catch (IOException e1)
		{
			BeetlException be = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR, "classpath resource not found:"
					+ id);
			throw be;
		}

		if (is == null)
		{
			BeetlException be = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR, "classpath resource not found:"
					+ id);
			throw be;
		}

		if (url.getProtocol().equals("file"))
		{
			file = new File(url.getFile());
		}

		Reader br;
		try
		{
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			return br;
		}
		catch (UnsupportedEncodingException e)
		{
			return null;
		}
	}

	@Override
	public boolean isModified()
	{
		if (file != null)
		{
			return file.lastModified() != this.lastModified;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getId()
	{
		return id;
	}

}
