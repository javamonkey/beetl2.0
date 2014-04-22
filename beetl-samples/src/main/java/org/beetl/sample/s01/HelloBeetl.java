package org.beetl.sample.s01;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class HelloBeetl {

	public static void main(String[] args) throws Exception {
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();		
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("hello,${name}");
		t.binding("name", "beetl");		
		String str = t.render();
		System.out.println(str);

	}
}
