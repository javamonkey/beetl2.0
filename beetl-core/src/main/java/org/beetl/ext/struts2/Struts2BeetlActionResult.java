/*
[The "BSD license"]
Copyright (c) 2011-2013  闲大赋 (李家智)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.beetl.ext.struts2;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;
import org.apache.struts2.views.util.ResourceUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.web.WebRender;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.reflection.ReflectionProvider;

public class Struts2BeetlActionResult extends StrutsResultSupport
{

	ReflectionProvider reflectionProvider = null;
	public static GroupTemplate groupTemplate;
	private String pContentType = "text/html; charset=UTF-8";
	static
	{
		Configuration cfg;
		try
		{
			cfg = Configuration.defaultConfiguration();
			WebAppResourceLoader resourceLoader = new WebAppResourceLoader();
			groupTemplate = new GroupTemplate(resourceLoader, cfg);

		}
		catch (IOException e)
		{
			throw new RuntimeException("加载GroupTemplate失败", e);
		}
	}
	
	public Struts2BeetlActionResult() {
		
	}

	@Inject
	public void setReflectionProvider(ReflectionProvider prov)
	{
		this.reflectionProvider = prov;
	}

	protected void doExecute(String locationArg, ActionInvocation invocation) throws Exception
	{

		ActionContext ctx = invocation.getInvocationContext();

		HttpServletRequest req = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse rsp = (HttpServletResponse) ctx.get(ServletActionContext.HTTP_RESPONSE);

		if (!locationArg.startsWith("/"))
		{
			String base = ResourceUtil.getResourceBase(req);
			locationArg = base + "/" + locationArg;
		}

		Object action = invocation.getAction();
		Map<String, Object> values = reflectionProvider.getBeanMap(action);
		rsp.setContentType(this.pContentType);
		WebRender render = new WebRender(groupTemplate) {
			protected void modifyTemplate(Template template, String key, HttpServletRequest request,
					HttpServletResponse response, Object... args)
			{
				Object action = args[0];
				template.binding("_root",action);
			}
		};
		render.render(locationArg, req, rsp, action);

	}

	public void setContentType(String aContentType)
	{
		pContentType = aContentType;
	}

	public String getContentType()
	{
		return pContentType;
	}

}

