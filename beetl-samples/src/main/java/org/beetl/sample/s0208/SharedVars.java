package org.beetl.sample.s0208;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class SharedVars {
public static void main(String[] args) throws Exception {
		
	ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();		
	Configuration cfg = Configuration.defaultConfiguration();
	GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
	Map<String,Object> shared = new HashMap<String,Object>();
	shared.put("name", "beetl");
	gt.setSharedVars(shared);
	Template t = gt.getTemplate("/org/beetl/sample/s0208/t1.txt");	
	String str = t.render();
	System.out.println(str);
	t = gt.getTemplate("/org/beetl/sample/s0208/t2.txt");	
	str = t.render();
	System.out.println(str);


	}
}
