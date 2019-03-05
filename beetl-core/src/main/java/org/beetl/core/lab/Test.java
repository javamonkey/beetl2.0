package org.beetl.core.lab;


import org.beetl.core.Configuration;
import org.beetl.core.ContextLocalBuffer;
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

		ContextLocalBuffer.isSoft = true;
		ContextLocalBuffer.MAX_SIZE = 1024 * 10;
		ContextLocalBuffer.BYTE_MAX_SIZE = ContextLocalBuffer.MAX_SIZE * 4;
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("org/beetl/core/lab/");
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setEngine("org.beetl.core.engine.OnlineTemplateEngine");
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
