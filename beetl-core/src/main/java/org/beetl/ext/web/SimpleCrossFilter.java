package org.beetl.ext.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.beetl.core.GroupTemplate;

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

			String commonFile = getCommonValueFile(req, rsp);
			Map commonData = gt.runScript(commonFile, null);
			Map data = gt.runScript(valueFile, null);
			commonData.putAll(data);
			Iterator it = commonData.keySet().iterator();
			while (it.hasNext())
			{
				String key = (String) it.next();
				Object value = commonData.get(key);
				setValue(key, value, req);
			}

			render.render(path, req, rsp);
		}
		else
		{

			chain.doFilter(request, response);
		}

	}

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

	protected void output(String result, ServletResponse response) throws IOException
	{
		response.getWriter().print(result);
	}

	protected abstract GroupTemplate getGroupTemplate();

	protected boolean canProcceed(ServletRequest request, ServletResponse response)
	{
		return true;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

}
