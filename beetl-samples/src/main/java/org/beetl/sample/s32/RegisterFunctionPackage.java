package org.beetl.sample.s32;

import java.io.File;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

public class RegisterFunctionPackage {
public static void main(String[] args) throws Exception {
		
	String root = System.getProperty("user.dir")+File.separator+"template";
	FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");		
		Configuration cfg = Configuration.defaultConfiguration();
	GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
	Template t = gt.getTemplate("/s32/pagefunction.html");	
	String str = t.render();		
	System.out.println(str);

	}
}
