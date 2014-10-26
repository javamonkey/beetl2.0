package org.beetl.ext.spring;

import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 使用指定名字的Spring Bean为Beetl的Tag对象 注意这个Tag Bean应该是prototype而非单例的，否则在程序中会有问题
 *
 * @author Chen Rui
 */
public class SpringBeanTagFactory implements TagFactory, ApplicationContextAware
{
	/* ----- ----- ----- ----- 属性 ----- ----- ----- ----- */
	/**
	 * 目标Bean名
	 */
	private String name = null;
	/**
	 * Spring 应用程序上下文
	 */
	private ApplicationContext applicationContext = null;

	/**
	 * 目标Bean名
	 *
	 * @param name
	 */
	@Required
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Spring 应用程序上下文
	 *
	 * @param applicationContext
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
	{
		this.applicationContext = applicationContext;
	}

	/* ----- ----- ----- ----- 其他方法 ----- ----- ----- ----- */
	/**
	 * 返回上下文中对应Tag bean对象
	 *
	 * @return
	 */
	@Override
	public Tag createTag()
	{
		return applicationContext.getBean(name, Tag.class);
	}
}
