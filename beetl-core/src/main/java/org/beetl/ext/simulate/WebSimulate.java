package org.beetl.ext.simulate;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
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
import org.beetl.core.exception.ScriptEvalError;
import org.beetl.core.misc.ClassSearch;
import org.beetl.ext.web.WebRender;
import org.beetl.ext.web.WebVariable;
/**
 * 在渲染模板前，调用beetl脚本模拟数据，提供模板需要渲染的数据。能模拟
 * 后台需要的模板数据
 * 后台需要的JSON
 * Ajax Beetl支持
 * @author xiandafu
 *
 */
public class WebSimulate  extends BaseSimulate{
	

	public WebSimulate(GroupTemplate gt){
		this(gt,null,"/values");
	}
	
	public WebSimulate(GroupTemplate gt,JsonUtil jsonUtil){
		this(gt,jsonUtil,"/values");
	}
	
	
	public WebSimulate(GroupTemplate gt,JsonUtil jsonUtil,String base){
		super(gt,jsonUtil,base);
	}
	
	public void execute(HttpServletRequest req,HttpServletResponse rsp){
		String path = this.getValuePath(req);
		RestPath restPath = this.getRealPath(path,req.getMethod().toLowerCase());
		if(restPath==null){
			throw new SimulateException("找不到脚本路径 "+path);
		}
		String valueFile =restPath.path;	
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
			//认为是需要json请求
			rsp.setContentType("text/json; charset=utf-8");
			Object jsonData = commonData.get("json");
			if(jsonData instanceof String){
				this.output((String)jsonData, rsp);
				
			}else{
				if(jsonUtil==null){
					throw new SimulateException("模拟属于采用了json，但没有设置JsonUtil");
				}
				String str = null;
				try {
					str = jsonUtil.toJson(jsonData);
				} catch (Exception e) {
					throw new SimulateException("序列化JSON出错", e);
				}
				this.output(str, rsp);
				
			}
			return ;
			
		}else{
			//如果是beetl ajax请求
			String ajaxFlag = null;
			if(data.containsKey("ajax")){
				ajaxFlag = (String)data.get("ajax");
			}
			
			Iterator it = commonData.keySet().iterator();
			while (it.hasNext())
			{
				String key = (String) it.next();
				Object value = commonData.get(key);
				setValue(key, value, req);
			}
			String renderPath = null;
			if(commonData.containsKey("view")){
				renderPath = (String) commonData.get("view");
			}else{
				renderPath = getRenderPath( req);
			}
			
			if(ajaxFlag!=null){
				renderPath = renderPath+"#"+ajaxFlag;
			}
			render.render(renderPath, req, rsp);
		}
		
		
	}
	
	

	/** 返回渲染的模板，默认就是path。
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 */
	protected String getRenderPath(HttpServletRequest request)
	{
		return request.getServletPath();
	}
	
	

	
}
