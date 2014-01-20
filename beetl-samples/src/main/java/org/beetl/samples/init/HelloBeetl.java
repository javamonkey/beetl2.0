package org.beetl.samples.init;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.Template;
import org.beetl.core.res.ClasspathResourceLoader;

public class HelloBeetl {

	public static void main(String[] args) throws Exception {
		ResourceLoader resourceLoader = new ClasspathResourceLoader("/");
		//FileResourceLoader frl = new FileResourceLoader("e:/temp");
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("hello.txt");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "beetl world");
		t.binding(map);
		// t.binding(varName, o,false)
		String str = t.render();
		System.out.println(str);

	}
}
