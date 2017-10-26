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
import org.beetl.core.exception.BeetlException;

public class FileResource extends Resource
{

	File file = null;
	long lastModified = 0;

	public FileResource(File file, String id, ResourceLoader loader)
	{
		super(id, loader);
		this.file = file;
		lastModified = file.lastModified();

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
			FileResourceLoader loader = (FileResourceLoader) this.resourceLoader;
			BeetlException be = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR, " 模板根目录为 " + loader.getRoot());
			be.pushResource(this);
			throw be;

		}
		return br;
	}

	@Override
	public boolean isModified()
	{
		// TODO Auto-generated method stub
		return this.lastModified != file.lastModified();
	}

}
