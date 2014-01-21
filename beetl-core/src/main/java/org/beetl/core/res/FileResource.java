package org.beetl.core.res;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.beetl.core.Resource;
import org.beetl.core.exception.TempException;

public class FileResource extends Resource
{

	File file = null;
	String id = null;

	public FileResource(File file, String id)
	{
		this.file = file;
		this.id = id;

	}

	@Override
	public Reader openReader()
	{
		Reader br;
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),
					((FileResourceLoader) this.getResourceLoader()).charset));
		}
		catch (UnsupportedEncodingException e)
		{
			return null;
		}
		catch (FileNotFoundException e)
		{
			throw new TempException(e.getMessage());

		}
		return br;
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
		return this.id;
	}

}
