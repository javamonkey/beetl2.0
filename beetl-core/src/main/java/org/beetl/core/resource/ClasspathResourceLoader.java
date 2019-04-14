/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
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
import java.net.URL;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.fun.FileFunctionWrapper;
import org.beetl.core.misc.BeetlUtil;

/**
 * ClassPath加载器,如果不指定classLoader,则使用加载beetl.jar的classloader,如果不指定root，则是默认的根路径，
 * 如果不指定模板字符集，则采用配置文件的resource.charset 配置
 * 
 * 注意，采用加载方式是classloader.getClass().getResource() 而不是classloader，如果需要采用classloader，请参考源代码
 * @author joelli
 * 
 * 
 */
public class ClasspathResourceLoader implements ResourceLoader
{
	private String root = null;
	boolean autoCheck = false;
	protected String charset = "UTF-8";
	String functionRoot = "functions";
	GroupTemplate gt = null;
	String functionSuffix = "fn";
	ClassLoader classLoader = null;


	/**
	 * 使用加载beetl.jar的classloader，以及默认root为根目录
	 */
	public ClasspathResourceLoader()
	{
		//保留，用于通过配置构造一个ResouceLoader
		classLoader = this.getClass().getClassLoader();
		this.root = "";
		

	}

	/** 使用指定的classloader
	 * @param classLoader
	 */
	public ClasspathResourceLoader(ClassLoader classLoader)
	{

		this.classLoader = classLoader;
		this.root = "";
		

	}

	/**使用指定的classloader和root
	 * @param classLoader
	 * @param root 模板路径，如/com/templates/
	 */
	public ClasspathResourceLoader(ClassLoader classLoader, String root)
	{

		this.classLoader = classLoader;
		this.root = this.checkRoot(root);

	}

	/**
	 * @param classLoader
	 * @param root
	 * @param charset 
	 */
	public ClasspathResourceLoader(ClassLoader classLoader, String root, String charset)
	{

		this(classLoader, root);
		this.charset = charset;
	}

	/** 
	 * @param root ，/com/templates/如其后的resourceId对应的路径是root+"/"+resourceId
	 */
	public ClasspathResourceLoader(String root)
	{

		this();
		this.root = this.checkRoot(root);
		

	}

	public ClasspathResourceLoader(String root, String charset)
	{

		this(root);
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

		Resource resource = new ClasspathResource(key, this.getChildPath(root, key), this);
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

	@Override
	public void init(GroupTemplate gt)
	{
		Map<String, String> resourceMap = gt.getConf().getResourceMap();
		//如果配置文件也配置了root
		if (resourceMap.get("root") != null)
		{
			String temp = resourceMap.get("root");
			temp = checkRoot(temp);
			this.root = this.getChildPath(root, temp);
		}

		if (this.charset == null)
		{
			this.charset = resourceMap.get("charset");

		}

		this.functionSuffix = resourceMap.get("functionSuffix");

		this.autoCheck = Boolean.parseBoolean(resourceMap.get("autoCheck"));
		this.functionRoot = resourceMap.get("functionRoot");


	}

	
	@Override
	public boolean exist(String key)
	{
		String path = this.getChildPath(root, key);
		URL url = this.classLoader.getResource(path);
		if(url==null){
			//兼容以前的
			url = this.classLoader.getClass().getResource(path);
		}
		return url!=null;
		

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
	public String getResourceId(Resource resource, String id)
	{
		if (resource == null)
			return id;
		else
			return BeetlUtil.getRelPath(resource.getId(), id);
	}

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public String getInfo() {
		return  "ClassLoader:"+this.classLoader+" Path:"+root;
	}
	
	/**
	 * 检查classpath路径
	 * @param path
	 * @return
	 */
	protected String checkRoot(String path){
		if(path==null||path.length()==0||path.equals("/")){
			return "";
			
		}else if(path.endsWith("/")){
			return path.substring(0,path.length()-1);
		}else if(path.startsWith("/")){
			return path.substring(1,path.length());
		}else{
			return  path;
		}
	}
	
	protected String getChildPath(String path,String child){
		if(child.length()==0){
			return path;
		}else if(child.startsWith("/")){
			return path+child;			
		}else{
			return path+"/"+child;
		}
	}
	
	
}
