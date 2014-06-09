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
package org.beetl.core.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.statement.GrammarToken;

/**
 * 将{@link BeetlException)表达成ErrorInfo
 * @author joelli
 *
 */
public class ErrorInfo
{
	String type = "";
	String errorTokenText = "";
	int errorTokenLine = 0;
	String msg;
	Throwable cause;
	String errorCode = null;
	List<String> resourceCallStack = null;
	List<GrammarToken> tokenCallStack = null;
	static Map<String, String> errorLocalMap = new HashMap<String, String>();
	static
	{
		errorLocalMap.put(BeetlException.ERROR, "错误");
		errorLocalMap.put(BeetlException.PARSER_UNKNOW_ERROR, concat("语法错误", BeetlException.PARSER_UNKNOW_ERROR));
		errorLocalMap.put(BeetlException.PARSER_VIABLE_ERROR, concat("语法错误", BeetlException.PARSER_VIABLE_ERROR));
		errorLocalMap.put(BeetlException.PARSER_MISS_ERROR, concat("缺少符号", BeetlException.PARSER_MISS_ERROR));
		errorLocalMap.put(BeetlException.PARSER_PREDICATE_ERROR, concat("语法错误", BeetlException.PARSER_PREDICATE_ERROR));
		errorLocalMap.put(BeetlException.TYPE_SEARCH_ERROR,
				concat("未找到指定类型，请配置类搜索路径或者增加类包名", BeetlException.TYPE_SEARCH_ERROR));
		errorLocalMap.put(BeetlException.PARSER_NATIVE_ERROR,
				concat("本地调用格式出错，不允许此格式", BeetlException.PARSER_NATIVE_ERROR));
		errorLocalMap.put(BeetlException.TAG_INSTANCE_ERROR, concat("创建Tag错", BeetlException.TAG_INSTANCE_ERROR));
		errorLocalMap.put(BeetlException.TEMPLATE_LOAD_ERROR, concat("加载模板错", BeetlException.TEMPLATE_LOAD_ERROR));
		errorLocalMap.put(BeetlException.OPT_ERROR, concat("优化失败", BeetlException.OPT_ERROR));
		errorLocalMap.put(BeetlException.NULL, concat("变量为空", BeetlException.NULL));
		errorLocalMap.put(BeetlException.BOOLEAN_EXPECTED_ERROR,
				concat("期望为Boolean类型", BeetlException.BOOLEAN_EXPECTED_ERROR));
		errorLocalMap.put(BeetlException.FORMAT_NOT_FOUND, concat("未找到格式化函数", BeetlException.FORMAT_NOT_FOUND));
		errorLocalMap.put(BeetlException.FUNCTION_INVALID, concat("方法定义错误", BeetlException.FUNCTION_INVALID));
		errorLocalMap.put(BeetlException.FUNCTION_NOT_FOUND, concat("未找到方法", BeetlException.FUNCTION_NOT_FOUND));
		errorLocalMap.put(BeetlException.STRICK_MVC, concat("严格MVC，不允许在模板里直接调用本地类", BeetlException.STRICK_MVC));
		errorLocalMap.put(BeetlException.COLLECTION_EXPECTED_ERROR,
				concat("期望遍历目标是是集合，数组，Iterator，Iterable", BeetlException.COLLECTION_EXPECTED_ERROR));

	}

	static String concat(String info, String code)
	{
		return info.concat("(").concat(code).concat(")");
	}

	public ErrorInfo(BeetlException ex)
	{
		cause = ex.getCause();
		errorCode = ex.detailCode;
		if (errorCode.startsWith("TEMPLATE"))
		{
			this.msg = ex.getMessage();
			this.type = errorLocalMap.get(errorCode);
			return;
		}
		else if (errorCode.startsWith("PARSER"))
		{
			this.errorTokenText = ex.getMessage();
		}
		else
		{
			if (ex.token != null)
			{
				this.errorTokenText = ex.token.text;
			}
			else
			{
				ex.printStackTrace();
			}

		}

		this.msg = ex.getMessage();
		this.errorTokenLine = ex.token.line;
		this.type = errorLocalMap.get(errorCode);
		if (type == null)
		{
			type = errorCode;
		}
		this.resourceCallStack = ex.errorResourceStack;
		this.tokenCallStack = ex.errorTokenStack;

	}

	/**错误的简单信息
	 * @return
	 */
	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	/**错误节点
	 * @return
	 */
	public String getErrorTokenText()
	{
		return errorTokenText;
	}

	public void setErrorTokenText(String errorTokenText)
	{
		this.errorTokenText = errorTokenText;
	}

	/**错误行数
	 * @return
	 */
	public int getErrorTokenLine()
	{
		return errorTokenLine;
	}

	public void setErrorTokenLine(int errorTokenLine)
	{
		this.errorTokenLine = errorTokenLine;
	}

	/**错误具体描述
	 * @return
	 */
	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	/**错误编码
	 * @return
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**错误栈，有可能没有
	 * @return
	 */
	public Throwable getCause()
	{
		return cause;
	}

	public void setCause(Throwable cause)
	{
		this.cause = cause;
	}

	public boolean hasCallStack()
	{
		return resourceCallStack.size() > 1;
	}

	public List<String> getResourceCallStack()
	{
		return resourceCallStack;
	}

	public void setResourceCallStack(List<String> resourceCallStack)
	{
		this.resourceCallStack = resourceCallStack;
	}

	public List<GrammarToken> getTokenCallStack()
	{
		return tokenCallStack;
	}

	public void setTokenCallStack(List<GrammarToken> tokenCallStack)
	{
		this.tokenCallStack = tokenCallStack;
	}

	public static Map<String, String> getErrorLocalMap()
	{
		return errorLocalMap;
	}

	/**可以设置新的错误码到错误描述的映射
	 * @param errorLocalMap
	 */
	public static void setErrorLocalMap(Map<String, String> errorLocalMap)
	{
		ErrorInfo.errorLocalMap = errorLocalMap;
	}

}
