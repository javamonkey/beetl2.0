package org.beetl.ext.simulate;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.web.ParameterWrapper;
import org.beetl.ext.web.SessionWrapper;
import org.beetl.ext.web.WebVariable;

public class BaseSimulate {
	protected GroupTemplate gt;
	protected String base = null;
	protected JsonUtil jsonUtil;
	
	public BaseSimulate(GroupTemplate gt,JsonUtil jsonUtil,String base){
		this.gt = gt;		
		this.base = base;
		this.jsonUtil = jsonUtil;
		gt.registerFunctionPackage("jsonUtil", jsonUtil);
	}
	
	
	protected String  getValueFile(String path, HttpServletRequest hq, HttpServletResponse response)
	{
		String defaultFile =  base+"/" + path + ".var";
		if(gt.getResourceLoader().exist(defaultFile)){
			return defaultFile;
		}else{
			String methodFile =  base+"/" + path +"."+hq.getMethod().toLowerCase()+".var";
			if(gt.getResourceLoader().exist(methodFile)){
				return methodFile;
			}
		}
		
		return null;
	}

	/** 得出公用的脚本文件，默认是在在webroot目录下的/values/common.var
	 * @param hq
	 * @param response
	 * @return
	 */
	protected String getCommonValueFile(HttpServletRequest hq, HttpServletResponse response)
	{
		String common =  base+"/common.var";
		if(gt.getResourceLoader().exist(common)){
			return common;
		}else{
			return null;
		}
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

	protected void output(String result, HttpServletResponse response)

	{
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// ignore 
			e.printStackTrace();
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
		map.put("parameter", new ParameterWrapper(request));
		
		map.put("session", new SessionWrapper(request,webVariable.getSession()));

		map.put("servlet", webVariable);
		map.put("request", request);
		map.put("ctxPath", request.getContextPath());
		return map;
	}

}
