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

import org.beetl.core.Resource;
import org.beetl.core.misc.BeetlUtil;

/**
 * Web应用加载器
 * 
 * @author joelli
 * 
 * 
 */
public class WebAppResourceLoader extends FileResourceLoader
{

	public WebAppResourceLoader()
	{

		this.root = BeetlUtil.getWebRoot() + File.separator;

	}

	/** 
	 * @param root 
	 */
	public WebAppResourceLoader(String root)
	{

		if (root != null)
			this.root = root;
		else
		{
			this.root = BeetlUtil.getWebRoot() + File.separator;
		}

	}

	public WebAppResourceLoader(String root, String charset)
	{

		this();
		this.root = root;
		this.charset = charset;
	}

	@Override
	public Resource getResource(String key)
	{

		return super.getResource(key);
	}

	@Override
	public void close()
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "WebAppResourceLoader,Root="+this.root;
	}

}
