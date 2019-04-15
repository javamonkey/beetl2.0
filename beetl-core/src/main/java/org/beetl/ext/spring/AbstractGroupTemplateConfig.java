/*
464 [The "BSD license"]
 Copyright (c) 2011-2013  闲大赋 (李家智)
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
package org.beetl.ext.spring;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Format;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.VirtualAttributeEval;
import org.beetl.core.VirtualClassAttribute;
import org.beetl.core.tag.TagFactory;

/**
 * GroupTemplate对象配置类的抽象基类
 *
 * @author fox
 */
public abstract class AbstractGroupTemplateConfig
{
	/* ----- ----- ----- ----- 其他方法 ----- ----- ----- ----- */
	/**	
	 * 自定义函数
	 */
	private Map<String, Function> functions = Collections.emptyMap();
	/**
	 * 自定义类型默认格式化器
	 */
	private Map<Class<?>, Format> typeFormats = Collections.emptyMap();
	/**
	 * 自定义格式化器
	 */
	private Map<String, Format> formats = Collections.emptyMap();
	/**
	 * 自定义标签
	 */
	private Map<String, TagFactory> tagFactorys = Collections.emptyMap();
	/**
	 * 自定义函数包
	 */
	private Map<String, Object> functionPackages = Collections.emptyMap();
	/**
	 * 自定义虚拟属性
	 */
	private Map<Class<?>, VirtualClassAttribute> virtualClassAttributes = Collections.emptyMap();
	/**
	 * 自定义虚拟属性执行器
	 */
	private List<VirtualAttributeEval> virtualAttributeEvals = Collections.emptyList();

	/**
	 * 自定义函数
	 *
	 * @param functions
	 */
	public void setFunctions(Map<String, Function> functions)
	{
		this.functions = functions;
	}

	/**
	 * 自定义类型默认格式化器
	 *
	 * @param typeFormats
	 */
	public void setTypeFormats(Map<Class<?>, Format> typeFormats)
	{
		this.typeFormats = typeFormats;
	}

	/**
	 * 自定义格式化器
	 *
	 * @param formats
	 */
	public void setFormats(Map<String, Format> formats)
	{
		this.formats = formats;
	}

	/**
	 * 自定义标签
	 *
	 * @param tagFactorys
	 */
	public void setTagFactorys(Map<String, TagFactory> tagFactorys)
	{
		this.tagFactorys = tagFactorys;
	}

	/**
	 * 自定义函数包
	 *
	 * @param functionPackages
	 */
	public void setFunctionPackages(Map<String, Object> functionPackages)
	{
		this.functionPackages = functionPackages;
	}

	/**
	 * 自定义虚拟属性
	 *
	 * @param virtualClassAttributes
	 */
	public void setVirtualClassAttributes(Map<Class<?>, VirtualClassAttribute> virtualClassAttributes)
	{
		this.virtualClassAttributes = virtualClassAttributes;
	}

	/**
	 * 自定义虚拟属性执行器
	 *
	 * @param virtualAttributeEvals
	 */
	public void setVirtualAttributeEvals(List<VirtualAttributeEval> virtualAttributeEvals)
	{
		this.virtualAttributeEvals = virtualAttributeEvals;
	}

	/* ----- ----- ----- ----- 其他方法 ----- ----- ----- ----- */
	/**
	 * 配置GroupTemplate
	 *
	 * @param groupTemplate
	 */
	public void config(GroupTemplate groupTemplate)
	{
		// 注册自定义函数
		for (Entry<String, Function> entry : functions.entrySet())
		{
			groupTemplate.registerFunction(entry.getKey(), entry.getValue());
		}

		// 注册自定义类型默认格式化器
		for (Entry<Class<?>, Format> entry : typeFormats.entrySet())
		{
			groupTemplate.registerDefaultFormat(entry.getKey(), entry.getValue());
		}
		// 注册自定义格式化器
		for (Entry<String, Format> entry : formats.entrySet())
		{
			groupTemplate.registerFormat(entry.getKey(), entry.getValue());
		}

		// 注册自定义标签
		for (Entry<String, TagFactory> entry : tagFactorys.entrySet())
		{
			groupTemplate.registerTagFactory(entry.getKey(), entry.getValue());
		}

		// 注册自定义函数包
		for (Entry<String, Object> entry : functionPackages.entrySet())
		{
			groupTemplate.registerFunctionPackage(entry.getKey(), entry.getValue());
		}

		// 自定义虚拟属性
		for (Entry<Class<?>, VirtualClassAttribute> entry : virtualClassAttributes.entrySet())
		{
			groupTemplate.registerVirtualAttributeClass(entry.getKey(), entry.getValue());
		}

		// 自定义虚拟属性执行器
		for (VirtualAttributeEval virtualAttributeEval : virtualAttributeEvals)
		{
			groupTemplate.registerVirtualAttributeEval(virtualAttributeEval);
		}
	}
}
