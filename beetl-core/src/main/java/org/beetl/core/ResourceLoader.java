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
package org.beetl.core;

/**
 * ResourceLoader 负责根据GroupTemplate提供的Key,来获取Resource，这些Resource可以是文件，
 * 字符串，加密的文本，以及数据库Blob字段等
 * 
 * @author joelli
 * 
 * 
 */
public interface ResourceLoader
{

	/**
	 * 根据key获取Resource
	 * 
	 * @param key
	 * @return
	 */
	public Resource getResource(String key);

	/** 检测模板是否更改，每次渲染模板前，都需要调用此方法，所以此方法不能占用太多时间，否则会影响渲染功能
	 * @param key
	 * @return
	 */
	public boolean isModified(Resource key);

	public boolean exist(String key);

	/**
	 * 关闭ResouceLoader，通常是GroupTemplate关闭的时候也关闭对应的ResourceLoader
	 */
	public void close();

	/** 一些初始化方法
	 * @param gt
	 */
	public void init(GroupTemplate gt);

	/**  用于include，layout等根据相对路径计算资源实际的位置.
	 * @param resource 当前资源
	 * @param key
	 * @return
	 */
	public String getResourceId(Resource resource, String key);
	
	/**
	 * 得到资源加载器说明，用于获取不到资源的时候输出提示信息
	 * @return
	 */
	public String getInfo();

}
