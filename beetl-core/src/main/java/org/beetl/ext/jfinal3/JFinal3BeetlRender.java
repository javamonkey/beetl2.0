package org.beetl.ext.jfinal3;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.web.WebRender;

import com.jfinal.render.Render;

public class JFinal3BeetlRender extends Render {
	 GroupTemplate groupTemplate;
	public JFinal3BeetlRender( GroupTemplate groupTemplate,String view){
		super();
		super.setView(view);
		this.groupTemplate = groupTemplate;
	}
	
	@Override
	public void render() {
		response.setContentType("text/html; charset=" + this.getEncoding());
		WebRender web = new WebRender(groupTemplate);
		web.render(this.view, this.request, this.response, null);

	}

}
