package org.beetl.performance.lab.template;

import java.io.File;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.ProgramMetaData;

public class MetaCopyTest {

	public static void main(String[] args) throws Exception {

		String home = System.getProperty("user.dir") + File.separator
				+ "template" + File.separator;
		Configuration cf = Configuration.defaultConfiguration();
		FileResourceLoader rs = new FileResourceLoader(home, cf.getCharset());
		GroupTemplate gt = new GroupTemplate(rs, cf);
		Template t = gt.getTemplate("/helloworld.html");
		Program p = gt.getProgram("/helloworld.html");
		ProgramMetaData old = p.metaData;
		ProgramMetaData copy = old.copy();
		System.out.println("ok");
	}
}
