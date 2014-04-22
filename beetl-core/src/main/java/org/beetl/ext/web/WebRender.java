package org.beetl.ext.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Enumeration;

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

	public void render(String key, HttpServletRequest request, HttpServletResponse response)
	{
		Writer writer = null;
		OutputStream os = null;
		try

		{
			//			response.setContentType(contentType);
			Template template = gt.getTemplate(key);
			Enumeration<String> attrs = request.getAttributeNames();

			while (attrs.hasMoreElements())
			{
				String attrName = attrs.nextElement();
				template.binding(attrName, request.getAttribute(attrName));

			}
			WebVariable webVariable = new WebVariable();
			webVariable.setRequest(request);
			webVariable.setResponse(response);
			webVariable.setSession(request.getSession());

			template.binding("session", new SessionWrapper(webVariable.getSession()));

			template.binding("servlet", webVariable);
			template.binding("request", request);
			template.binding("ctxPath", request.getContextPath());

			modifyTemplate(template, key, request, response);

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
			handleClientError(e);
		}
		catch (BeetlException e)
		{
			handleBeetlException(e);
		}

		finally
		{
			try
			{
				if (writer != null)
					writer.flush();
				if (os != null)
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
	 */
	protected void modifyTemplate(Template template, String key, HttpServletRequest request,
			HttpServletResponse response)
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
}
