package org.beetl.core.lab;


import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

/**
 * http://sports.qq.com/a/20151126/029300.htm
 * 
 * @author xiandafu
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {

		
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("lab/");
		Configuration cfg = Configuration.defaultConfiguration();

		cfg.setDirectByteOutput(true);
		cfg.getResourceMap().put("tagRoot", "");
		cfg.getPkgList().add("org.beetl.core.lab.");
		cfg.setStatementStart("<%");
		cfg.setStatementEnd("%>");
		// js 里专用
		cfg.setStatementStart2("//#");
		cfg.setStatementEnd2(null);
		cfg.setPlaceholderStart2("#{");
		cfg.setPlaceholderEnd2("}");
		cfg.initOther();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		gt.registerTag("table",TableTag.class);
		gt.registerTag("col",ColTag.class);
		TestUser user = new TestUser("a");


		for (int i = 0; i < 1; i++) {

			Template t = gt.getTemplate("/hello.txt");
			t.binding("a",1);
			t.binding("user",new TestUser("jo"));
//			TestUser user = new TestUser("jo");
//			user.lover = new TestUser("dddd");
//			t.binding("user", user);

			System.out.println(t.render());


		}

	}


}
