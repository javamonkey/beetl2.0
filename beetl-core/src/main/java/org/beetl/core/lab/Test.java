package org.beetl.core.lab;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class Test
{
	public static void main(String[] args) throws Exception
	{

		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
		TestUser user = new TestUser("aa");
		t.binding("user", user);

		t.binding("s1", new Long(1));
		t.binding("s2", new Long(1));

		//		gt.setSharedVars(map);
		String str = t.render();
		System.out.println(str);

		t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
		user = new TestUser("aa");
		t.binding("user", user);

		t.binding("s1", new Long(1));
		t.binding("s2", new Long(1));

		//		gt.setSharedVars(map);
		str = t.render();
		System.out.println(str);
		//		Thread.sleep(1000 * 8);
		//		t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
		//		str = t.render();
		//		System.out.println(str);
	}
}
