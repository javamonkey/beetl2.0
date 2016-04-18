package org.beetl.ext.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

public interface WebRenderExt {
	public void modify(Template template,GroupTemplate gt,HttpServletRequest request,HttpServletResponse response);
}
