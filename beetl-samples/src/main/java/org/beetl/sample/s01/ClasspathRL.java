package org.beetl.sample.s01;

import java.net.URL;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class ClasspathRL {

	public static void main(String[] args) throws Exception {
		
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();		
		URL url = resourceLoader.getClass().getResource("/org/beetl/sample/s01/hello.txt");
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("/org/beetl/sample/s01/hello.txt");	
		String str = t.render();
		System.out.println(str);

	}
}
