package org.beetl.ext.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.web.WebRender;
import org.springframework.web.servlet.view.AbstractTemplateView;

public class BeetlSpringView extends AbstractTemplateView
{

	protected void renderMergedTemplateModel(Map model, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		BeetlGroupUtilConfiguration config = (BeetlGroupUtilConfiguration) this.getApplicationContext().getBean(
				"beetlConfig");
		GroupTemplate group = config.getGroupTemplate();

		WebRender render = new WebRender(group);
		String path = getUrl() + config.getSuffix();
		render.render(path, request, response);

	}

}