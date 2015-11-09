/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
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
package org.beetl.ext.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.beetl.core.GroupTemplate;
import org.beetl.core.exception.ScriptEvalError;

/** 用于直接访问模板页面，此fitler会根据只要要访问的模板页面，运行同样同路径下的var文件，获取模板需要的全局变量，然后渲染模板
 * @author joelli
 * @since 2.1.0
 *
 */
public abstract class SimpleCrossFilter implements Filter
{

	public SimpleCrossFilter()
	{
	}

	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		if (canProcceed(req, response))
		{
			String path = req.getServletPath();
			String valueFile = getValueFile(path, req, rsp);
			GroupTemplate gt = getGroupTemplate();

			WebRender render = new WebRender(gt);
			Map paras = this.getScriptParas(req, rsp);

			String commonFile = getCommonValueFile(req, rsp);
			Map commonData = new HashMap(), data = new HashMap();
			try
			{
				if (gt.getResourceLoader().exist(commonFile))
				{
					commonData = gt.runScript(commonFile, paras);

				}

				if (gt.getResourceLoader().exist(valueFile))
				{
					data = gt.runScript(valueFile, paras);
				}

			}
			catch (ScriptEvalError e)
			{
				throw new RuntimeException("伪模型脚本有错！", e);
			}

			commonData.putAll(data);
			Iterator it = commonData.keySet().iterator();
			while (it.hasNext())
			{
				String key = (String) it.next();
				Object value = commonData.get(key);
				setValue(key, value, req);
			}

			String renderPath = getRenderPath(path, req, rsp);

			render.render(renderPath, req, rsp);
		}
		else
		{

			chain.doFilter(request, response);
		}

	}

	/** 设置全局变量
	 * @param key
	 * @param value
	 * @param hq
	 */
	protected void setValue(String key, Object value, HttpServletRequest hq)
	{
		if (key.equals("session"))
		{
			HttpSession session = hq.getSession();
			Map map = (Map) value;
			Iterator it = map.keySet().iterator();
			while (it.hasNext())
			{
				String sessionKey = (String) it.next();
				Object sessionValue = map.get(sessionKey);
				session.setAttribute(sessionKey, sessionValue);
			}

		}
		else
		{
			hq.setAttribute(key, value);
		}
	}

	/** 根据请求的模板页面得出脚本文件，比如，请求是/userList.html,则默认是在webroot目录下的/values/userList.html.var
	 * @param path
	 * @param hq
	 * @param response
	 * @return
	 */
	protected String getValueFile(String path, HttpServletRequest hq, HttpServletResponse response)
	{
		return "/values/" + path + ".var";
	}

	/** 得出公用的脚本文件，默认是在在webroot目录下的/values/common.var
	 * @param hq
	 * @param response
	 * @return
	 */
	protected String getCommonValueFile(HttpServletRequest hq, HttpServletResponse response)
	{
		return "/values/common.var";
	}

	/** 返回渲染的模板，默认就是path。
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getRenderPath(String path, HttpServletRequest request, HttpServletResponse response)
	{
		return path;
	}

	protected void output(String result, ServletResponse response) throws IOException
	{
		response.getWriter().print(result);
	}

	protected Map getScriptParas(HttpServletRequest request, HttpServletResponse response)
	{
		Map map = new HashMap();
		Enumeration<String> attrs = request.getAttributeNames();

		while (attrs.hasMoreElements())
		{
			String attrName = attrs.nextElement();
			map.put(attrName, request.getAttribute(attrName));

		}
		WebVariable webVariable = new WebVariable();
		webVariable.setRequest(request);
		webVariable.setResponse(response);
		webVariable.setSession(request.getSession());

		map.put("session", new SessionWrapper(request,webVariable.getSession()));

		map.put("servlet", webVariable);
		map.put("request", request);
		map.put("ctxPath", request.getContextPath());
		return map;
	}

	/** 返回一个GroupTemlate
	 * @return
	 */
	protected abstract GroupTemplate getGroupTemplate();

	/** 是否处理此请求，默认总是处理
	 * @param request
	 * @param response
	 * @return
	 */
	protected boolean canProcceed(ServletRequest request, ServletResponse response)
	{
		return true;
	}

}
