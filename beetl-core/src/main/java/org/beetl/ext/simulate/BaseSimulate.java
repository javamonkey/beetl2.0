package org.beetl.ext.simulate;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.misc.ClassSearch;
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
		if(jsonUtil!=null){
			gt.registerFunctionPackage("jsonUtil", jsonUtil);
			gt.registerFunction("jsonBody", new ReuqestBodyFunction(jsonUtil) );
		}
		
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
	
	/**
	 * 得到对应的脚本值
	 * @param request
	 * @return
	 */
	public String getValuePath(HttpServletRequest request){
		return request.getServletPath();
	}
	
	/**
	 * 无法根据请求的url找到对应的path变量，因此暂时先不支持path变量，使用$$来代替
	 * @param path
	 * @return
	 */
	protected RestPath getRealPath(String path,String method){
		return getRealPath(gt.getResourceLoader(),path,method);
	}
	
	private  RestPath getRealPath(ResourceLoader loader,String path,String method){
		method = method.toLowerCase();
		path = this.base+"/"+path;
		RestPath restPath = new RestPath();
		List<String> pathVars = new ArrayList<String>();
		String[] paths = path.split("/");
		paths = getPath(paths);
		String realPath = "";
		
		for(int i=0;i<paths.length;i++){
			String p = paths[i];
			
			if(i!=(paths.length-1)){
				String temp = realPath +"/"+p;
				boolean exist = loader.exist(temp);
				if(!exist){
					temp = realPath+"/$$";
					exist = loader.exist(temp);
					if(!exist){
						return null;
					}else{
						pathVars.add(p);
						realPath=temp;
					}
				}else{
					realPath=temp;
					continue ;
				}
			}else{
				String temp = realPath +"/"+p+"."+method+".var";
				boolean exist = loader.exist(temp);
				if(exist){
					realPath = temp;
				}else{
					 temp = realPath +"/"+p+".var";
					 exist = loader.exist(temp);
					 if(exist){
						 realPath = temp;
					 }else{
						 //检查通配符情况
						 temp = realPath +"/$$."+method+".var";
						 if(loader.exist(temp)){
							 realPath = temp;
							 pathVars.add(p);
						 }else{
							 temp = realPath +"/$$"+".var";
							 if(loader.exist(temp)){
								 realPath = temp;
								 pathVars.add(p);
							 }else{
								 //未找到
								 return null;
							 }
						 }
					 }
				}
			}
		
		}
		restPath.path = realPath;
		restPath.values = pathVars;
		return restPath;
		
	}
	
	private String[] getPath(String[] ori){
		List<String> list = new ArrayList<String>(ori.length);
		for(String str:ori){
			if(str.length()==0||str.equals("/")||str.equals("\\")){
				continue;
			}
			list.add(str);
		}
		return list.toArray(new String[0]);
	}
	
	//一个简单疯转rest路径对应的的模拟路径以及参数，
	// /user/1/dept/2 对应于路径 user/$id$/dept/$dept$.value 路径，且values里有1，2
	public static class RestPath{
		public String path;
		public List<String> values = new ArrayList<String>();
		
	}
	
	public static class ReuqestBodyFunction implements Function{
		
		JsonUtil jsonUtil;
		public ReuqestBodyFunction(JsonUtil jsonUtil){
			this.jsonUtil = jsonUtil;
		}
		
		@Override
		public Object call(Object[] paras, Context ctx) {
			HttpServletRequest req = (HttpServletRequest)ctx.getGlobal(WebVariable.REQUEST);
			GroupTemplate gt = ctx.gt;
			String name = (String)paras[0];
			ClassSearch search = gt.getClassSearch();
			Class cls = search.getClassByName(name);
			String body;
			try {
				body = getRequestBody(req.getReader());
			} catch (IOException e) {
				//不需要处理这种问题
				throw new RuntimeException(e);
			}
			if(jsonUtil==null){
				throw new SimulateException("没有设置jsonUtil，无法将json转为对象");
			}
			Object obj;
			try {
				obj = jsonUtil.toObject(body, cls);
			} catch (Exception e) {
				throw new RuntimeException("反序列化json出错");
			}
			return obj;
		}
		
		private String getRequestBody(BufferedReader reader) throws IOException {
			String line = null;  
			StringBuilder sb = new StringBuilder();
	        while((line = reader.readLine()) != null){  
		        	sb.append(line);
		        	sb.append("\n");
	       
	        }  
	        return sb.toString();
		}
		
	}

}
