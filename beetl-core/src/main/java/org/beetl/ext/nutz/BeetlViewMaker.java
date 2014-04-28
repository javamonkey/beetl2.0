package org.beetl.ext.nutz;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.web.WebRender;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.View;
import org.nutz.mvc.ViewMaker;
import org.nutz.mvc.view.AbstractPathView;

/**
 * Beelt for Nutz
 * 
 * @author wendal,joelli
 * 
 */
public class BeetlViewMaker implements ViewMaker
{

	public GroupTemplate groupTemplate;
	private boolean inited;

	public void init()
	{
		if (inited)
			return;

		Configuration cfg;
		try
		{
			cfg = Configuration.defaultConfiguration();
			WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
			groupTemplate = new GroupTemplate(resourceLoader, cfg);
			inited = true;
		}
		catch (IOException e)
		{
			throw new RuntimeException("加载GroupTemplate失败", e);
		}

	}

	public void depose()
	{
		if (groupTemplate != null)
			groupTemplate.close();
	}

	public View make(Ioc ioc, String type, String value)
	{
		if (!inited)
			init();
		if ("beetl".equals(type))
			return new AbstractPathView(value) {
				@SuppressWarnings("unchecked")
				public void render(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Throwable
				{

					String child = evalPath(req, obj);
					WebRender render = new WebRender(groupTemplate);
					render.render(child, req, resp);

				}
			};
		return null;
	}
}