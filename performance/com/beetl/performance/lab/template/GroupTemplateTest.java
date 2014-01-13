package com.beetl.performance.lab.template;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.res.FileResourceLoader;

import com.beetl.performance.lab.User;

public class GroupTemplateTest {

	public static void main(String[] args) throws Exception {

		String home = System.getProperty("user.dir") + File.separator
				+ "template" + File.separator;
		Configuration cf = Configuration.defaultConfiguration();
		FileResourceLoader rs = new FileResourceLoader(home, cf.getCharset());
		GroupTemplate gt = new GroupTemplate(rs, cf);

		User user = new User();
		List list = new ArrayList();
		list.add(user);

		Map map = new HashMap();
		map.put("userList", list);
		// Log.key1Start();
		Template t = gt.getTemplate("/helloworld.html");
		t.binding("userList", list);
		StringWriter sw = new StringWriter();
		t.renderTo(sw);
		System.out.println(sw.toString());

		// 第二次
		t = gt.getTemplate("/helloworld.html");
		t.binding("userList", list);
		sw = new StringWriter();
		t.renderTo(sw);

		System.out.println(sw.toString());
	}
}
