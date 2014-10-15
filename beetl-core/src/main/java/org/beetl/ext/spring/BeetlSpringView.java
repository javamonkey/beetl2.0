package org.beetl.ext.spring;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRender;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.web.servlet.view.AbstractTemplateView;

public class BeetlSpringView extends AbstractTemplateView
{

	/* ----- ----- ----- ----- 属性 ----- ----- ----- ----- */
	/**
	 * 视图使用的Beetl GroupTemplate，由ViewResolver注入，如果不设置，取上下文中唯一的GroupTemplate对象
	 */
	private GroupTemplate groupTemplate = null;

	/**
	 * 视图使用的Beetl GroupTemplate，由ViewResolver注入，如果不设置，取上下文中唯一的GroupTemplate对象
	 *
	 * @param url
	 *            模版访问地址
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
	public BeetlSpringView()
	{
	}

	/* ----- ----- ----- ----- 实现方法 ----- ----- ----- ----- */
	/**
	 * 渲染指定视图
	 *
	 * @param model
	 * @param request
	 * @param response
	 * @throws NoSuchBeanDefinitionException
	 *             如果未设置GroupTemplate，且Spring上下文中也没有唯一的GroupTemplate bean
	 * @throws NoUniqueBeanDefinitionException
	 *             如果未设置GroupTemplate，且Spring上下文中有多个GroupTemplate bean
	 * @throws Exception
	 */
	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws NoSuchBeanDefinitionException, NoUniqueBeanDefinitionException
	{
		// 如果未指定groupTemplate，取上下文中唯一的GroupTemplate对象
		if (groupTemplate == null)
		{
			groupTemplate = getApplicationContext().getBean(GroupTemplate.class);
		}

		// 渲染方法
		WebRender render = new WebRender(groupTemplate) {
			@Override
			protected void modifyTemplate(Template template, String key, HttpServletRequest request,
					HttpServletResponse response, Object... args)
			{
				Map<?, ?> model = (Map<?, ?>) args[0];

				for (Entry<?, ?> entry : model.entrySet())
				{
					String name = (String) entry.getKey();
					Object value = entry.getValue();
					template.binding(name, value);
				}
			}
		};
		String path = getUrl();
		render.render(path, request, response, model);
	}
}
