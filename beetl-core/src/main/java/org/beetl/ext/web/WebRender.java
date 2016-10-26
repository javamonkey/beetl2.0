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
import java.io.OutputStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;

/**
 *  通常web渲染的类，将request变量赋值给模板，同时赋值的还有session,request,ctxPath
 *  其他框架可以继承此类做更多的定制
 * @author joelli
 *
 */
public class WebRender
{
	GroupTemplate gt = null;

	public WebRender(GroupTemplate gt)
	{
		this.gt = gt;
	}

	/**
	 * @param key 模板资源id
	 * @param request
	 * @param response
	 * @param args 其他参数，将会传给modifyTemplate方法
	 */
	public void render(String key, HttpServletRequest request, HttpServletResponse response, Object... args)
	{
		Writer writer = null;
		OutputStream os = null;
		String ajaxId = null;
		Template template = null;
		boolean isError = false;
		try

		{
			//			response.setContentType(contentType);
			int ajaxIdIndex = key.lastIndexOf("#");
			if (ajaxIdIndex != -1)
			{
				ajaxId = key.substring(ajaxIdIndex + 1);
				key = key.substring(0, ajaxIdIndex);
				template = gt.getAjaxTemplate(key, ajaxId);

			}
			else
			{
				template = gt.getTemplate(key);
			}

			Enumeration<String> attrs = request.getAttributeNames();

			while (attrs.hasMoreElements())
			{
				String attrName = attrs.nextElement();
				template.binding(attrName, request.getAttribute(attrName));

			}
			WebVariable webVariable = new WebVariable();
			webVariable.setRequest(request);
			webVariable.setResponse(response);
			template.binding(WebVariable.SESSION, new SessionWrapper(request,request.getSession(false)));

			template.binding(WebVariable.SERVLET, webVariable);
			template.binding(WebVariable.REQUEST, request);
			template.binding("ctxPath", request.getContextPath());
			template.binding("$page", new HashMap()); 
			template.binding("parameter", new ParameterWrapper(request));
			

			modifyTemplate(template, key, request, response, args);

			String strWebAppExt = gt.getConf().getWebAppExt();
			if(strWebAppExt!=null){
				WebRenderExt renderExt = this.getWebRenderExt(strWebAppExt);
				renderExt.modify(template, gt, request, response);
			}
			
			
			if (gt.getConf().isDirectByteOutput())
			{
				os = response.getOutputStream();
				template.renderTo(os);
			}
			else
			{
				writer = response.getWriter();
				template.renderTo(writer);
			}

		}
		catch (IOException e)
		{
			isError = true;
			handleClientError(e);
		}
		catch (BeetlException e)
		{
			isError = true;
//			response.setStatus(500);
//			
			handleBeetlException(e);
		}

		finally
		{
			try
			{
				
				if (!isError&&writer != null)
					writer.flush();
				if (!isError&&os != null)
				{
					os.flush();
				}
			}
			catch (IOException e)
			{
				handleClientError(e);
			}
		}
	}

	/**
	 * 可以添加更多的绑定
	 * @param template 模板
	 * @param key 模板的资源id
	 * @param request 
	 * @param response
	 * @param args  调用render的时候传的参数
	 */
	protected void modifyTemplate(Template template, String key, HttpServletRequest request,
			HttpServletResponse response, Object... args)
	{

	}

	/**处理客户端抛出的IO异常
	 * @param ex
	 */
	protected void handleClientError(IOException ex)
	{
		//do nothing
	}

	/**处理客户端抛出的IO异常
	 * @param ex
	 */
	protected void handleBeetlException(BeetlException ex)
	{
		throw ex;
	}
	
	protected WebRenderExt getWebRenderExt(String clsName){
		//有效率问题，没有必要每次都初始化一个类
		try{
			WebRenderExt render = (WebRenderExt)gt.getClassLoader().loadClass(clsName).newInstance();
			return render;
		}catch(Exception ex){
			throw new RuntimeException("加载WebRenderExt错误，检查配置项WEBAPP_EXT:"+ex.getMessage(),ex);
		}
		
	}
}
