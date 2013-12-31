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
import org.beetl.core.io.ByteWriter_Char;
import org.beetl.core.res.FileResourceLoader;

import com.beetl.performance.Log;
import com.beetl.performance.lab.User;

public class GroupTemplateTest {

	public static void main(String[] args) throws Exception {

		String home = System.getProperty("user.dir") + File.separator
				+ "template" + File.separator;
		Configuration cf = Configuration.defaultConfiguration();
		FileResourceLoader rs = new FileResourceLoader(home, cf.getCharset());
		GroupTemplate gt = new GroupTemplate(rs, cf);
		Template t = gt.getTemplate("/helloworld.html");
		User user = new User();
		List list = new ArrayList();
		list.add(user);
		t.binding("userList", list);
		Map map = new HashMap();
		map.put("userList", list);
		Log.key1Start();
		StringWriter sw = new StringWriter();
		ByteWriter_Char bw = new ByteWriter_Char(sw, cf.getCharset());
		t.fastRender(map, bw);
		bw.flush();
		Log.key1End();
		System.out.println(sw.toString());
	}
}
