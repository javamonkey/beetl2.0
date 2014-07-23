package org.beetl.performance.lab.template;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

public class GroupTemplateTest {

	public static void main(String[] args) throws Exception {

		String home = System.getProperty("user.dir") + File.separator
				+ "template" + File.separator;
		Configuration cf = Configuration.defaultConfiguration();
		cf.setStatementStart("<!--:");
		cf.setStatementEnd("-->");
		FileResourceLoader rs = new FileResourceLoader(home, cf.getCharset());
		GroupTemplate gt = new GroupTemplate(rs, cf);

		List<StockModel> list = StockModel.dummyItems();

		Template t = gt.getTemplate("/helloworld.html");
		t.binding("items", list);
		StringWriter sw = new StringWriter();
		t.renderTo(sw);
		System.out.println(sw.toString());

		// 第二次
		t = gt.getTemplate("/helloworld.html");
		t.binding("items", list);
		sw = new StringWriter();
		t.renderTo(sw);
		System.out.println(sw.toString());

	}
}
