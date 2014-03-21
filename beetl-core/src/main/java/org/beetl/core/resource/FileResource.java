package org.beetl.core.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.TempException;

public class FileResource extends Resource
{

	File file = null;

	public FileResource(File file, String id, ResourceLoader loader)
	{
		super(id, loader);
		this.file = file;

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
	public boolean isModified()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
