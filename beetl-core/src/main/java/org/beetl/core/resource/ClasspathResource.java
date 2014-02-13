package org.beetl.core.resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.beetl.core.Resource;
import org.beetl.core.exception.TempException;

public class ClasspathResource extends Resource
{
	private String id;
	String path = null;

	public ClasspathResource(String key, String path)
	{
		this.id = key;
		this.path = path;
	}

	@Override
	public Reader openReader()
	{
		InputStream is = ClasspathResource.class.getResourceAsStream(path);
		if (is == null)
		{
			throw new TempException("classpath resource not found:" + id);
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
	public String getContent(int startLine, int endLine)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isModified()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getId()
	{
		return id;
	}

}
