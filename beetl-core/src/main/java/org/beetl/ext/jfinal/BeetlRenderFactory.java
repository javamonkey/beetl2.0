package org.beetl.ext.jfinal;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;

import com.jfinal.render.IMainRenderFactory;
import com.jfinal.render.Render;

public class BeetlRenderFactory implements IMainRenderFactory
{

	public static String viewExtension = ".html";
	public static GroupTemplate groupTemplate = null;

	static
	{
		try
		{

			Configuration cfg = Configuration.defaultConfiguration();
			WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
			groupTemplate = new GroupTemplate(resourceLoader, cfg);

		}
		catch (IOException e)
		{
			throw new RuntimeException("加载GroupTemplate失败", e);
		}
	}

	public Render getRender(String view)
	{
		return new BeetlRender(groupTemplate, view);
	}

	public String getViewExtension()
	{
		return viewExtension;
	}

}
