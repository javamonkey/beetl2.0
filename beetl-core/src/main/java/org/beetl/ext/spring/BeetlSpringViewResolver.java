/*
 [The "BSD license"]
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * Beetl ViewResolver视图解析器
 *
 * @author Chen Rui
 */
public class BeetlSpringViewResolver extends AbstractTemplateViewResolver implements InitializingBean, BeanNameAware
{
	protected final Log logger = LogFactory.getLog(getClass());
	/* ----- ----- ----- ----- 其他方法 ----- ----- ----- ----- */
	/**
	 * 这个GroupTemplate的BeanName
	 */
	
	private String beanName = null;
	
	private BeetlGroupUtilConfiguration config;

	/**
	 * 这个GroupTemplate的BeanName
	 *
	 * @param beanName
	 */
	@Override
	public void setBeanName(String beanName)
	{
		this.beanName = beanName;
		
	}

	/**
	 * 视图使用的Beetl GroupTemplate，如果不设置，取上下文中唯一的GroupTemplate对象
	 */
	private GroupTemplate groupTemplate = null;

	/**
	 * 视图使用的Beetl GroupTemplate，如果不设置，取上下文中唯一的GroupTemplate对象
	 *
	 * @param groupTemplate
	 *            视图使用的Beetl GroupTemplate，由ViewResolver注入，如果不设置，取上下文中唯一的GroupTemplate对象
	 */
	public void setGroupTemplate(GroupTemplate groupTemplate)
	{
		this.groupTemplate = groupTemplate;
	}

	/* ----- ----- ----- ----- 构造函数 ----- ----- ----- ----- */
	/**
	 * 缺省构造函数
	 */
	public BeetlSpringViewResolver()
	{
		setViewClass(BeetlSpringView.class);
	}
	
	
	

	/**
	 * 初始化检查GroupTemplate<br>
	 * 实现InitializingBean，在Bean IOC注入结束后自动调用
	 *
	 * @throws NoSuchBeanDefinitionException
	 *             如果未设置GroupTemplate，且Spring上下文中也没有唯一的GroupTemplate bean
	 * @throws NoUniqueBeanDefinitionException
	 *             如果未设置GroupTemplate，且Spring上下文中有多个GroupTemplate bean
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@Override
	public void afterPropertiesSet() throws NoSuchBeanDefinitionException, NoUniqueBeanDefinitionException,
			SecurityException, NoSuchFieldException
	{
		// 如果未指定groupTemplate，取上下文中唯一的GroupTemplate对象
		if (config == null)
		{
			config = getApplicationContext().getBean(BeetlGroupUtilConfiguration.class);
			this.groupTemplate = config.getGroupTemplate();
		}

		// 如果没有设置ContentType，设置个默认的
		if (getContentType() == null)
		{
			String charset = groupTemplate.getConf().getCharset();
			setContentType("text/html;charset=" + charset);
		}

	}

	/* ----- ----- ----- ----- 其他方法 ----- ----- ----- ----- */
	/**
	 * 视图类
	 *
	 * @return
	 */
	@Override
	protected Class<BeetlSpringView> requiredViewClass()
	{
		return BeetlSpringView.class;
	}

	/**
	 * 实例化GroupTemplate
	 *
	 * @param viewName
	 * @return
	 * @throws Exception
	 */
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception
	{

		BeetlSpringView beetlView = (BeetlSpringView) super.buildView(viewName);
		beetlView.setGroupTemplate(groupTemplate);
		String suffix = getSuffix();
		//如果配置有后缀，需要重新设定视图
		if(suffix!=null&&suffix.length()!=0){
			if (viewName.contains("#")) {
				String[] split = viewName.split("#");
				if (split.length > 2) {
				throw new Exception("视图名称有误：" + viewName);
				}
				beetlView.setUrl(getPrefix() + split[0] + getSuffix() + "#" + split[1]);
			}
		}
		return beetlView;
		
	}

	/**
	 * 生成重定向请求，这类请求不会产生BeetlView而是通过Servlet自身机制重定向到其他url资源
	 *
	 * @param url
	 * @return
	 */
	public static String redirect(String url)
	{
		return "redirect:" + url;
	}

	/**
	 * 生成转发请求，这类请求不会产生BeetlView而是通过Servlet自身机制转发到其他url资源
	 *
	 * @param url
	 * @return
	 */
	public static String forward(String url)
	{
		return "forward:" + url;
	}

	public BeetlGroupUtilConfiguration getConfig() {
		return config;
	}

	public void setConfig(BeetlGroupUtilConfiguration config) {
		this.config = config;
		this.groupTemplate = config.getGroupTemplate();
	}
	
	public void setPrefix(String prefix) {
		logger.warn("Beetl不建议使用使用spring前缀，会导致include,layout找不到对应的模板，请使用beetl的配置RESOURCE.ROOT来配置模板根目录");
		super.setPrefix(prefix);
	}
	
	
}