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

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.beetl.core.Configuration;
import org.beetl.core.ErrorHandler;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ServletContextAware;

/**
 * 
 * 
 *  <pre>&lt;bean id="beetlConfig" class="org.beetl.ext.spring.BeetlGroupUtilConfiguration" init-method="init" &gt;
			
	&lt;/bean &gt;
	
	&lt;bean id="viewResolver" class="org.beetl.ext.spring.BeetlSpringViewResolver"&gt;
		&lt;property name="contentType" value="text/html;charset=UTF-8"&gt;&lt;/property&gt;
	&lt;/bean&gt;
	</pre>
 * beetl 在spring mvc 中的配置
 * <p></p>
 * 用户继承此类，并实现 initOther方法,以注册自己的函数，标签等
 * @author javamonkey , Chen Rui
 *
 */
public class BeetlGroupUtilConfiguration extends AbstractGroupTemplateConfig implements ServletContextAware
{
	protected GroupTemplate groupTemplate;
	protected String root = "/";
	protected String webPath = null;
	/**
	 * 配置属性
	 */
	protected Properties configProperties = null;
	/**
	 * 配置文件地址
	 */
	protected Resource configFileResource = null;
	/**
	 * Beetl资源加载器，如果未指定，会自动依据ApplicationContext和配置文件识别
	 */
	protected ResourceLoader resourceLoader = null;
	/**
	 * 异常处理器
	 */
	protected ErrorHandler errorHandler = null;
	/**
	 * 共享变量
	 */
	protected Map<String, Object> sharedVars = null;

	public void init()
	{
		try
		{
			initGroupTemplate();

			config(groupTemplate);

			initOther();

		}
		catch (IOException e)
		{
			throw new RuntimeException("加载GroupTemplate失败", e);
		}
	}

	/**
	 * 配置属性
	 *
	 * @param configProperties
	 */
	public void setConfigProperties(Properties configProperties)
	{
		this.configProperties = configProperties;
	}

	/**
	 * 配置文件地址
	 *
	 * @param configFileResource
	 */
	public void setConfigFileResource(Resource configFileResource)
	{
		this.configFileResource = configFileResource;
	}

	/**
	 * Beetl资源加载器，如果未指定，会自动依据ApplicationContext和配置文件识别
	 *
	 * @param resourceLoader
	 */
	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}

	/**
	 * 异常处理器
	 *
	 * @param errorHandler
	 */
	public void setErrorHandler(ErrorHandler errorHandler)
	{
		this.errorHandler = errorHandler;
	}

	/**
	 * 共享参数
	 *
	 * @param sharedVars
	 */
	public void setSharedVars(Map<String, Object> sharedVars)
	{
		this.sharedVars = sharedVars;
	}

	public void setServletContext(ServletContext sc)
	{

		//如果没有指定ResourceLoader，将使用WebResourceLoader,然后此为根目录
		webPath = sc.getRealPath("/");
		if(webPath!=null){
			root = webPath + root;
		}
		

	}

	private void initGroupTemplate() throws IOException
	{
		// 配置数据加载
		Configuration configuration = null;
		// 如果都未设置，取默认的配置
		if ((configProperties == null) && (configFileResource == null))
		{
			configuration = Configuration.defaultConfiguration();
		}
		else
		{

			Properties properties = new Properties();
			if (configFileResource != null)
			{
				InputStream in = null;
				try
				{
					// 如果指定了配置文件，先加载配置文件

					in = configFileResource.getInputStream();
					properties.load(in);
				}
				catch (IOException ex)
				{
					throw ex;
				}
				finally
				{
					if (in != null)
					{
						in.close();
						in = null;
					}
				}
			}

			if (configProperties != null)
			{
				
				for(Entry<Object,Object> entry:configProperties.entrySet()){
					String key = (String) entry.getKey();
					String value = (String) entry.getValue();
					properties.setProperty(key, value);
				}
				
			}

			// 使用配置项配置properties
			configuration = new Configuration(properties);
		}

		// 如果未指定，返回
		if (resourceLoader != null)
		{
			groupTemplate = new GroupTemplate(resourceLoader, configuration);
		}
		else
		{
			WebAppResourceLoader defaultLoader = new WebAppResourceLoader(root);
			groupTemplate = new GroupTemplate(defaultLoader, configuration);
		}

		if (errorHandler != null)
		{
			groupTemplate.setErrorHandler(errorHandler);
		}

		// 设置共享变量
		if (sharedVars != null)
		{
			groupTemplate.setSharedVars(sharedVars);
		}
	}

	protected void initOther()
	{

	}

	public GroupTemplate getGroupTemplate()
	{
		return this.groupTemplate;
	}

	public void setRoot(String root)
	{
		this.root = root;
	}

}