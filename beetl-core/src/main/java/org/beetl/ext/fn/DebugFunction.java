/*
 [The "BSD license"]
 Copyright (c) 2011-2013  闲大赋 (李家智)
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
package org.beetl.ext.fn;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 在控制台输出对象，如
 * <pre>
 * &lt;% debug(user)%&gt;,
 * </pre>
 * 该方法输出该方法的行数，以及对象的toString返回的字符串:
 * <pre>
 * System.out.println(paras[0].toString());	
 * </pre>
 * 可以调用DebugFunction.enable = false ,来禁止输出
 * @author joelli
 *
 */
public class DebugFunction implements Function
{

	public static boolean enable = true;

	public Object call(Object[] paras, Context ctx)
	{
		if (!enable)
			return "";
		String[] expStrs = (String[]) paras[paras.length - 2];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < paras.length - 2; i++)
		{
			Object o = paras[i];
			if (expStrs[i] != null)
			{
				//对于debug常量，不需要，参考AntlrProgramBuilder.parseFunExp
				sb.append(expStrs[i]).append("=");
			}

			if (o != null)
			{
				if (o instanceof CharSequence)
				{
					sb.append("\"").append(o.toString()).append("\"");
				}
				else
				{
					sb.append(o.toString());
				}

			}
			else
			{
				sb.append("null");
			}
			sb.append(",");
		}

		String line = paras[paras.length - 1].toString();
		String resourceId = ctx.getResourceId();
		sb.append(" [在").append(line).append("行@").append(resourceId).append("]");

		System.out.println(sb);

		return "";
	}
}
