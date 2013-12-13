package com.beetl.samples.init;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.res.FileResourceLoader;

public class HelloBeetl {

	public static void main(String[] args) throws Exception {
		FileResourceLoader frl = new FileResourceLoader("e:/temp");
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(frl, cfg);
		Template t = gt.getTemplate("/hello.txt");
		Map map = new HashMap();
		map.put("name", "world");
		t.binding(map);
		t.binding(varName, o,false)
		String str = t.render();

	}
}
