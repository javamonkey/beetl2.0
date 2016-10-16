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
import org.beetl.core.misc.BeetlUtil;

/** 文件模板加载器
 * @author joelli
 *
 */
public class FileResourceLoader implements ResourceLoader
{

	String root = null;
	String charset = "UTF-8";
	boolean autoCheck = false;
	String functionRoot = "funtion";
	String functionSuffix = "fn";
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
		if (this.autoCheck)
		{
			return key.isModified();
		}
		else
		{
			return false;
		}
	}

	public boolean isAutoCheck()
	{
		return autoCheck;
	}

	public void setAutoCheck(boolean autoCheck)
	{
		this.autoCheck = autoCheck;
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
		if (resourceMap.get("root") != null)
		{

			String temp = resourceMap.get("root");
			File test = new File(root, temp);

			this.root = test.toString();
		}

		if (this.charset == null)
		{
			this.charset = resourceMap.get("charset");

		}
		this.functionSuffix = resourceMap.get("functionSuffix");
		this.autoCheck = Boolean.parseBoolean(resourceMap.get("autoCheck"));
		this.functionRoot = resourceMap.get("functionRoot");
		File root = new File(this.root, this.functionRoot);
		this.gt = gt;
		if (root.exists())
		{
			String ns = "";
			String path = "/".concat(this.functionRoot).concat("/");
			BeetlUtil.autoFileFunctionRegister(gt, root, ns, path, this.functionSuffix);
			
		}

	}

	
	@Override
	public boolean exist(String key)
	{
		// TODO Auto-generated method stub
		return new File(root, key).exists();
	}

	@Override
	public String getResourceId(Resource resource, String id)
	{
		if (resource == null)
			return id;
		else
			return BeetlUtil.getRelPath(resource.getId(), id);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "FileResourceLoader,Root="+this.root;
	}

}
