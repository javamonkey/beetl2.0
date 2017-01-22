package org.beetl.ext.jfinal3;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;

import com.jfinal.kit.PathKit;
import com.jfinal.render.Render;
import com.jfinal.render.RenderFactory;

public class JFinal3BeetlRenderFactory extends RenderFactory {
	public  GroupTemplate groupTemplate = null;
	
	public Render getRender(String view) {
		return new JFinal3BeetlRender(groupTemplate,view);
	}
	
	public void config(){
		String root = PathKit.getWebRootPath();
		WebAppResourceLoader resourceLoader = new WebAppResourceLoader(root);
		config(resourceLoader);
	}
	
	public void config(String root){
		
		WebAppResourceLoader resourceLoader = new WebAppResourceLoader(root);
		config(resourceLoader);
	}
	
	public void config(ResourceLoader rs){
		
		if (groupTemplate != null)
		{
			groupTemplate.close();
		}
				
		try
		{

			Configuration cfg = Configuration.defaultConfiguration();
			groupTemplate = new GroupTemplate(rs, cfg);
		}
		catch (IOException e)
		{
			throw new RuntimeException("加载GroupTemplate失败", e);
		}
	}
	
	
}
