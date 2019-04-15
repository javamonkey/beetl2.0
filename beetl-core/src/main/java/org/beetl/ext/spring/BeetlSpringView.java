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

import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRender;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.web.servlet.view.AbstractTemplateView;

/**
 * @author Chen Rui
 *
 */
public class BeetlSpringView extends AbstractTemplateView
{

	/* ----- ----- ----- ----- 属性 ----- ----- ----- ----- */
	/**
	 * 视图使用的Beetl GroupTemplate，由ViewResolver注入，如果不设置，取上下文中唯一的GroupTemplate对象
	 */
	protected GroupTemplate groupTemplate = null;

	/**
	 * 视图使用的Beetl GroupTemplate，由ViewResolver注入，如果不设置，取上下文中唯一的GroupTemplate对象
	 *
	 * @param groupTemplate
	 *            视图使用的Beetl GroupTemplate，由ViewResolver注入，如果不设置，取上下文中唯一的GroupTemplate对象
	 */
	public void setGroupTemplate(GroupTemplate groupTemplate)
	{
		this.groupTemplate = groupTemplate;
	}
	
	

	public GroupTemplate getGroupTemplate() {
		return groupTemplate;
	}



	/* ----- ----- ----- ----- 构造函数 ----- ----- ----- ----- */
	/**
	 * 缺省构造函数
	 */
	public BeetlSpringView()
	{
	}

	/* ----- ----- ----- ----- 实现方法 ----- ----- ----- ----- */
	/**
	 * 渲染指定视图
	 *
	 * @param model
	 * @param request
	 * @param response
	 * @throws NoSuchBeanDefinitionException
	 *             如果未设置GroupTemplate，且Spring上下文中也没有唯一的GroupTemplate bean
	 * @throws NoUniqueBeanDefinitionException
	 *             如果未设置GroupTemplate，且Spring上下文中有多个GroupTemplate bean
	 */
	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws NoSuchBeanDefinitionException, NoUniqueBeanDefinitionException
	{
		// 如果未指定groupTemplate，取上下文中唯一的GroupTemplate对象
		if (groupTemplate == null)
		{
			groupTemplate = getApplicationContext().getBean(GroupTemplate.class);
		}

		// 渲染方法
		WebRender render = new WebRender(groupTemplate) {
			@Override
			protected void modifyTemplate(Template template, String key, HttpServletRequest request,
					HttpServletResponse response, Object... args)
			{
				Map<?, ?> model = (Map<?, ?>) args[0];

				for (Entry<?, ?> entry : model.entrySet())
				{
					String name = (String) entry.getKey();
					Object value = entry.getValue();
					template.binding(name, value);
				}
			}
		};
		String path = getUrl();
		render.render(path, request, response, model);
	}
	
	@Override
	public boolean checkResource(Locale locale) throws Exception {
//	    BeetlGroupUtilConfiguration config = getApplicationContext().getBean(BeetlGroupUtilConfiguration.class);
	    String url = getUrl();
	    //去掉ajax 部分。
	    if (url.contains("#")) {
			String[] split = url.split("#");
			if (split.length > 2) {
				throw new Exception("视图名称有误：" + url);
			}
			return groupTemplate.getResourceLoader().exist(split[0]);
		}else{
			return groupTemplate.getResourceLoader().exist(url);
		}
		
	}
	
}
