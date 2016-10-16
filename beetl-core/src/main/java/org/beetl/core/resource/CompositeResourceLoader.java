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

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.BeetlException;

/**   
 * 复合加载器，依据对应的匹配器调用响应的加载器
 * @author 李飞 (lifei@wellbole.com 
 * 
 **/
public class CompositeResourceLoader implements ResourceLoader
{

	/**
	 * 匹配器列表
	 */
	private List<Matcher> matchers = new ArrayList<Matcher>();

	/**
	 * 匹配器-加载器映射表
	 */
	private Map<Matcher, ResourceLoader> matcherResourceLoaderMap = new HashMap<Matcher, ResourceLoader>();

	/**
	 * 是否自动检查文件是否变动
	 */
	private boolean autoCheck = false;

	/**
	 * 添加一个资源加载器
	 * @param matcher 匹配器
	 * @param resourceLoader 匹配时对应的资源加载器
	 */
	public void addResourceLoader(Matcher matcher, ResourceLoader resourceLoader)
	{
		//检查是否存在该匹配器
		if (this.matcherResourceLoaderMap.containsKey(matcher))
		{
			//已经添加了。
			return;
		}
		this.matcherResourceLoaderMap.put(matcher, resourceLoader);
		this.matchers.add(matcher);
	}

	/** 一次性设置资源加载器,方便配置使用
	 * @param map
	 */
	public void setResourceLoaderMap(Map<Matcher, ResourceLoader> map)
	{
		this.matcherResourceLoaderMap = map;
	}

	@Override
	public void close()
	{
		Iterator<ResourceLoader> it = matcherResourceLoaderMap.values().iterator();
		ResourceLoader rl = null;
		while (it.hasNext())
		{
			rl = it.next();
			rl.close();
		}
	}

	@Override
	public boolean exist(String key)
	{
		ResourceLoaderKeyEntry rlke = this.match(key);
		if (rlke == null)
			return false;
		return rlke.getResourceLoader().exist(rlke.getNewKey());
	}

	@Override
	public Resource getResource(String key)
	{
		ResourceLoaderKeyEntry rlke = this.match(key);
		if (rlke == null)
		{
			return new UnReachableResource(key, this);
		}
		return rlke.getResourceLoader().getResource(rlke.getNewKey());
	}

	@Override
	public void init(GroupTemplate gt)
	{
		//逐个初始化
		for (ResourceLoader rl : this.matcherResourceLoaderMap.values())
		{
			rl.init(gt);
		}
		Map<String, String> resourceMap = gt.getConf().getResourceMap();
		this.autoCheck = Boolean.parseBoolean(resourceMap.get("autoCheck"));
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

	/**
	 * @Description: 遍历匹配器列表进行 匹配操作  
	 * @param key 
	 * @return 匹配到了返回一个加载器新key实体。否则报异常（说明代码写的有问题）
	 */
	private ResourceLoaderKeyEntry match(String key)
	{
		for (Matcher matcher : this.matchers)
		{
			//匹配了
			String newKey = matcher.match(key);
			if (newKey != null)
			{
				//返回对应的资源加载器
				return new ResourceLoaderKeyEntry(newKey, this.matcherResourceLoaderMap.get(matcher));
			}
		}
		return null;
	}

	/**
	 * @Description: 内部类，用来返回  ResourceLoader 和 key对
	 */
	private final static class ResourceLoaderKeyEntry
	{
		private final String newKey;
		private final ResourceLoader resourceLoader;

		public ResourceLoaderKeyEntry(String newKey, ResourceLoader resourceLoader)
		{
			this.newKey = newKey;
			this.resourceLoader = resourceLoader;
		}

		public final String getNewKey()
		{
			return newKey;
		}

		public final ResourceLoader getResourceLoader()
		{
			return resourceLoader;
		}
	}

	private final static class UnReachableResource extends Resource
	{

		UnReachableResource(String key, ResourceLoader loader)
		{
			super(key, loader);
		}

		@Override
		public Reader openReader()
		{
			BeetlException be = new BeetlException(BeetlException.TEMPLATE_LOAD_ERROR, "复合资源加载器未匹配路径:" + this.id);
			be.resourceId = this.id;
			throw be;
		}

		@Override
		public boolean isModified()
		{

			return true;
		}
	}

	@Override
	public String getResourceId(Resource resource, String id)
	{
		if (resource == null)
			return id;
		//判断如果是同一前缀，则需要考虑相对路径
		ResourceLoaderKeyEntry rlke = this.match(id);
		if (resource.getResourceLoader() == rlke.getResourceLoader())
		{
			return resource.getResourceLoader().getResourceId(resource, id);
		}
		else
		{
			return id;
		}
	}

	@Override
	public String getInfo() {
		return "CompositeResourceLoader "+this.matcherResourceLoaderMap;
	}
}
