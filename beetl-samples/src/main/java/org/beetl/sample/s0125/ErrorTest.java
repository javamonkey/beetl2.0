package org.beetl.sample.s0125;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class ErrorTest {
public static void main(String[] args) throws Exception {
		
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();		
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("/org/beetl/sample/s0125/error1.txt");	
		String str = t.render();
		
		t = gt.getTemplate("/org/beetl/sample/s0125/error2.txt");	
		str = t.render();
		System.out.println(str);

	}
}
