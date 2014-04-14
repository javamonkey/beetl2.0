package org.beetl.ext.jfinal;

import java.io.File;
import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.FileResourceLoader;

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
			String path = BeetlRenderFactory.class.getResource("/").getFile();
			String root = new File(path).getParentFile().getParentFile().getCanonicalPath();

			Configuration cfg = Configuration.defaultConfiguration();
			String charset = cfg.getCharset();
			String realPath = cfg.getProperty("RESOURCE.root");
			if (realPath != null)
			{
				root = root + File.separator + realPath + File.separator;
			}
			FileResourceLoader resourceLoader = new FileResourceLoader(root, charset);
			groupTemplate = new GroupTemplate(resourceLoader, cfg);

		}
		catch (IOException e)
		{
			throw new RuntimeException("Can notload properties for beetl");
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
