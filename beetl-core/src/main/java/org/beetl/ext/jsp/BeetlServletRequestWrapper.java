package org.beetl.ext.jsp;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class BeetlServletRequestWrapper extends HttpServletRequestWrapper
{
	Map paras = null;

	public BeetlServletRequestWrapper(HttpServletRequest request, Map paras)
	{
		super(request);
		this.paras = paras;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name)
	{
		return (String) paras.get(name);
	}

	@Override
	public String[] getParameterValues(String name)
	{
		return (String[]) paras.get(name);
	}

	@Override
	public Map getParameterMap()
	{
		return this.paras;
	}

	@Override
	public Enumeration getParameterNames()
	{
		return Collections.enumeration(this.paras.keySet());
	}

}
