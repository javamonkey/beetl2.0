package org.beetl.ext.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.web.WebRender;

/**
 * 在Serlvet中调用
 * <pre>
 * 
 * ServletGroupTemplate.instance().render("/xxxpage",request,response);
 * </pre>
 * 
 * GroupTemplate 通过配置文件配置，也可以在Linstner中调用ServletGroupTemplate.instance()，并手工调用
 * @author joelli
 *
 */
public class ServletGroupTemplate
{
	static ServletGroupTemplate sgt = new ServletGroupTemplate();
	GroupTemplate groupTemplate = null;

	private ServletGroupTemplate()
	{

		try
		{
			Configuration cfg = Configuration.defaultConfiguration();
			WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
			groupTemplate = new GroupTemplate(resourceLoader, cfg);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("加载GroupTemplate失败", ex);

		}

	}

	/** 获取GroupTemplate
	 * @return
	 */
	public static ServletGroupTemplate instance()
	{
		return sgt;
	}

	public void render(String child, HttpServletRequest request, HttpServletResponse response)
	{
		WebRender render = new WebRender(groupTemplate);
		render.render(child, request, response);

	}

	public GroupTemplate getGroupTemplate()
	{
		return groupTemplate;
	}

}
