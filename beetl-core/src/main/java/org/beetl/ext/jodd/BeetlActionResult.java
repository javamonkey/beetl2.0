package org.beetl.ext.jodd;

import java.io.IOException;

import jodd.madvoc.ActionRequest;
import jodd.madvoc.result.ActionResult;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.web.WebRender;

public class BeetlActionResult implements ActionResult
{

	public static final String NAME = "beetl";
	GroupTemplate groupTemplate = null;

	public BeetlActionResult()
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

	@Override
	public void render(ActionRequest actionRequest, Object resultValue) throws Exception
	{
		// TODO Auto-generated method stub
		WebRender render = new WebRender(groupTemplate);
		render.render((String) resultValue, actionRequest.getHttpServletRequest(),
				actionRequest.getHttpServletResponse());

	}

	@Override
	public Class getResultValueType()
	{

		return String.class;
	}

	@Override
	public void init()
	{

	}

	@Override
	public String getResultName()
	{
		// TODO Auto-generated method stub
		return NAME;
	}

}
