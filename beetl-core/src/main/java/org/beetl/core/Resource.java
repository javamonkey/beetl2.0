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
package org.beetl.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/** 代表模板资源，如文件，数据库Clob字段，后者加密模板等等
 * @author joelli
 *
 */
public abstract class Resource
{

	protected ResourceLoader resourceLoader = null;
	protected String id = null;

	public Resource(String id, ResourceLoader loader)
	{
		this.id = id;
		this.resourceLoader = loader;
	}

	/**
	 * 打开一个新的Reader
	 * 
	 * @return
	 */
	public abstract Reader openReader();

	/**
	 * 检测资源是否改变
	 * 
	 * @return
	 */
	public abstract boolean isModified();

	/**
	 * 得到Resource对应的ResourceLoader
	 * 
	 * @return
	 */
	public ResourceLoader getResourceLoader()
	{
		return this.resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}

	public String getId()
	{
		return this.id;
	}

	/**
	 * 得到Resource指定行数的内容，用于调试，报错等显示原有模板信息,如果获取不了 返回NUll
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public String getContent(int start, int end) throws IOException
	{
		// bug, 混合回车符号也许定位不到准确行数？
		String lineSeparator = System.getProperty("line.separator");
		Reader br = openReader();
		BufferedReader reader = new BufferedReader(br);
		String line = null;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while((line=reader.readLine())!=null){
			index++;
			if(index>=start&&index<=end){
				sb.append(line).append(lineSeparator);
				if(index==end){
					break;
				}
			}
		}
		return sb.toString();

	

	}
	
	public String toString() {
		return this.id;
	}
}
