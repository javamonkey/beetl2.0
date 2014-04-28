package org.beetl.ext.spring;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
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

		WebRender render = new WebRender(group) {
			protected void modifyTemplate(Template template, String key, HttpServletRequest request,
					HttpServletResponse response, Object... args)
			{
				Map model = (Map) args[0];

				for (Object o : model.entrySet())
				{
					Entry entry = (Entry) o;
					String name = (String) entry.getKey();
					Object value = entry.getValue();
					template.binding(name, value);
				}
			}
		};
		String path = getUrl() + config.getSuffix();
		render.render(path, request, response, model);

	}

}