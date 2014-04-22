/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.resource;

import java.io.File;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.fun.FileFunctionWrapper;

/** 文件模板加载器
 * @author joelli
 *
 */
public class FileResourceLoader implements ResourceLoader
{

	String root = null;
	String charset = "UTF-8";
	boolean autouCheck = false;
	String functionRoot = "functions";
	String functionSuffix = "html";
	GroupTemplate gt = null;

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

	@Override
	public void init(GroupTemplate gt)
	{
		Map<String, String> resourceMap = gt.getConf().getResourceMap();
		if (this.root == null)
		{
			this.root = resourceMap.get("root");

		}
		if (this.charset == null)
		{
			this.charset = resourceMap.get("charset");

		}
		if (this.functionSuffix == null)
		{
			this.functionSuffix = resourceMap.get("functionSuffix");
		}

		this.autouCheck = Boolean.parseBoolean(resourceMap.get("autouCheck"));

		File root = new File(this.root, this.functionRoot);
		this.gt = gt;
		if (root.exists())
		{
			readFuntionFile(root, "", "/".concat(functionRoot).concat("/"));
		}

	}

	protected void readFuntionFile(File funtionRoot, String ns, String path)
	{
		String expected = ".".concat(this.functionSuffix);
		File[] files = funtionRoot.listFiles();
		for (File f : files)
		{
			if (f.isDirectory())
			{
				//读取子目录
				readFuntionFile(f, f.getName().concat("."), path.concat(f.getName()).concat("/"));
			}
			else if (f.getName().endsWith(functionSuffix))
			{
				String resourceId = path + f.getName();
				String fileName = f.getName();
				fileName = fileName.substring(0, (fileName.length() - functionSuffix.length() - 1));
				String functionName = ns.concat(fileName);
				FileFunctionWrapper fun = new FileFunctionWrapper(resourceId);
				gt.registerFunction(functionName, fun);
			}
		}
	}

}
