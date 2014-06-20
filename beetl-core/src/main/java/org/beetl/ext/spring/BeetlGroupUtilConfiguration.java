/*
464 [The "BSD license"]
 Copyright (c) 2011-2013 Joel Li (李家智)
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

import java.io.IOException;

import javax.servlet.ServletContext;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;
import org.springframework.web.context.ServletContextAware;

/**
 * 
 * 
 *  <pre>&lt;bean id="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init">
			
	&lt;/bean>
	
	&lt;bean id="viewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver">
		&lt;property name="contentType" value="text/html;charset=UTF-8"></property>
	&lt;/bean>
	</pre>
 * beetl 在spring mvc 中的配置
 * <p>
 * 用户继承此类，并实现 initOther方法,以注册自己的函数，标签等
 * @author javamonkey
 *
 */
public class BeetlGroupUtilConfiguration implements ServletContextAware
{
	protected GroupTemplate groupTemplate;
	protected String root = "/";
	protected String webPath = null;
	protected String suffix = "";

	public void setServletContext(ServletContext sc)
	{

		webPath = sc.getRealPath("/");
		root = webPath + root;

	}

	public void init()
	{
		try
		{

			Configuration cfg = Configuration.defaultConfiguration();
			WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
			groupTemplate = new GroupTemplate(resourceLoader, cfg);
			initOther();

		}
		catch (IOException e)
		{
			throw new RuntimeException("加载GroupTemplate失败", e);
		}
	}

	protected void initOther()
	{
		//如注册方法，格式化函数等
		/**
		 * group.register......
		 */

	}

	public GroupTemplate getGroupTemplate()
	{
		return this.groupTemplate;
	}

	public String getSuffix()
	{
		return suffix;
	}

	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}

}