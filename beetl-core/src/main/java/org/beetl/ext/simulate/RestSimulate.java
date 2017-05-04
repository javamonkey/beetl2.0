package org.beetl.ext.simulate;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.ScriptEvalError;
import org.beetl.core.misc.ClassSearch;
import org.beetl.ext.web.WebRender;
import org.beetl.ext.web.WebVariable;
/**
 * 模拟REST后台处理，返回一定的json数据,
 * 1) TOOD,无法解决路径问题，不支持path变量,目前用$来代替path
 * 2) 将Request的Body 映射成一个对象，或者Map结构。
 * @author xiandafu
 *
 */
public class RestSimulate  extends BaseSimulate {
	

	public RestSimulate(GroupTemplate gt){
		this(gt,null,"/values");
	}
	
	public RestSimulate(GroupTemplate gt,JsonUtil jsonUtil){
		this(gt,jsonUtil,"/values");
	}
	
	
	public RestSimulate(GroupTemplate gt,JsonUtil jsonUtil,String base){
		super(gt,jsonUtil,base);
		gt.registerFunction("bodyClass", new ReuqestBodyFunction(jsonUtil));
		
	}
	
	public void execute(HttpServletRequest req,HttpServletResponse rsp){
		String path = req.getServletPath();
		path = path+req.getMethod().toLowerCase()+".var";
		RestPath restPath = this.getRealPath(path,req.getMethod().toLowerCase());
		if(restPath==null){
			throw new SimulateException("找不到脚本路径 "+path);
		}
		String valueFile = getValueFile(restPath.path, req, rsp);	
		
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
			//rest path 变量放入参数
			paras.put("pathVars", restPath.values);
			
			if (valueFile!=null)
			{
				data = gt.runScript(valueFile, paras);
			}

		}
		catch (ScriptEvalError e)
		{
			throw new SimulateException("伪模型脚本有错！", e);
		}

		commonData.putAll(data);
		
		if(commonData.containsKey("json")){
			Object jsonData = commonData.get("json");
			if(jsonData instanceof String){
				this.output((String)jsonData, rsp);
				
			}else{
				if(jsonUtil==null){
					throw new SimulateException("模拟属于采用了json，但没有设置JsonUtil");
				}
				String str = jsonUtil.toJson(jsonData);
				this.output(str, rsp);
				
			}
			return ;
		}else{
			throw new SimulateException("REST 期望返回json数据");
		}
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
		RestPath restPath = new RestPath();
		List<String> pathVars = new ArrayList<String>();
		String[] paths = path.split("/");
		String realPath = "";
		
		for(int i=0;i<paths.length;i++){
			String p = paths[i];
			if(p.length()==0||p.equals("/")){
				continue ;
			}
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
							 temp = realPath +"/$$."+".var";
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
			Object obj = jsonUtil.toObject(body, cls);
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
