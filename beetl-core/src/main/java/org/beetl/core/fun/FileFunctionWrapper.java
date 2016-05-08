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
package org.beetl.core.fun;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;

/**
 * Beetl允许注册模板文件为一个方法
 * @author joelli
 *
 */
public class FileFunctionWrapper implements Function
{

	String resourceId = null;

	/** 模板文件的资源标示
	 * @param resourceId
	 */
	public FileFunctionWrapper(String resourceId)
	{
		this.resourceId = resourceId;
	}

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		try
		{

			Template template = ctx.gt.getHtmlFunctionOrTagTemplate(this.resourceId);
			// 能显示异常
			template.isRoot = false;
			template.binding(ctx.globalVar);
			for (int i = 0; i < paras.length; i++)
			{
				template.binding("para".concat(String.valueOf(i)), paras[i]);
			}

			template.renderTo(ctx.byteWriter);
			Object[] vars = template.getCtx().vars;
			Object o = vars[vars.length - 1];
			if (o != Context.NOT_EXIST_OBJECT)
			{
				return o;
			}
			else
			{
				return null;
			}

		}

		catch (BeetlException ex)
		{

			throw ex;
		}
		catch (Exception ex)
		{
			BeetlException be = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用方法出错 " + this.resourceId,
					ex);

			throw be;
		}

	}

}
