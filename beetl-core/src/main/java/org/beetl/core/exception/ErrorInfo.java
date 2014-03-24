package org.beetl.core.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorInfo
{
	String type = "";
	String errorTokenText = "";
	int errorTokenLine = 0;
	String msg;
	Throwable cause;
	static Map<String, String> errorLocalMap = new HashMap<String, String>();
	static
	{
		errorLocalMap.put(BeetlException.ERROR, "错误");
		errorLocalMap.put(BeetlException.PARSER_UNKNOW_ERROR, "语法错误");
		errorLocalMap.put(BeetlException.PARSER_VIABLE_ERROR, "语法错误");
		errorLocalMap.put(BeetlException.PARSER_MISS_ERROR, "缺少符号");
		errorLocalMap.put(BeetlException.PARSER_PREDICATE_ERROR, "语法错误");
		errorLocalMap.put(BeetlException.PARSER_PREDICATE_ERROR, "语法错误");
		errorLocalMap.put(BeetlException.TYPE_SEARCH_ERROR, "未找到指定类型，请配置类搜索路径或者增加类包名");
		errorLocalMap.put(BeetlException.PARSER__NATIVE__ERROR, "本地调用格式出错，不允许此格式");
		errorLocalMap.put(BeetlException.TAG_INSTANCE_ERROR, "创建Tag错");
		errorLocalMap.put(BeetlException.TEMPLATE_LOAD_ERROR, "加载模板错");
		errorLocalMap.put(BeetlException.OPT_ERROR, "优化失败");
		errorLocalMap.put(BeetlException.NULL, "变量为空");
		errorLocalMap.put(BeetlException.BOOLEAN_EXPECTED_ERROR, "期望为Boolean类型");
		errorLocalMap.put(BeetlException.FORMAT_NOT_FOUND, "未找到格式化函数");
		errorLocalMap.put(BeetlException.FUNCTION_INVALID, "方法定义错误");
		errorLocalMap.put(BeetlException.FUNCTION_NOT_FOUND, "未找到方法");

	}

	public ErrorInfo(BeetlException ex)
	{
		cause = ex.getCause();
		String detailCode = ex.detailCode;
		if (detailCode.startsWith("TEMPLATE"))
		{
			this.msg = ex.getMessage();
			this.type = errorLocalMap.get(detailCode);
			return;
		}
		else if (detailCode.startsWith("PARSER"))
		{
			this.errorTokenText = ex.getMessage();
		}
		else
		{
			this.errorTokenText = ex.token.text;
		}

		this.msg = ex.getMessage();
		this.errorTokenLine = ex.token.line;
		this.type = errorLocalMap.get(detailCode);

	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getErrorTokenText()
	{
		return errorTokenText;
	}

	public void setErrorTokenText(String errorTokenText)
	{
		this.errorTokenText = errorTokenText;
	}

	public int getErrorTokenLine()
	{
		return errorTokenLine;
	}

	public void setErrorTokenLine(int errorTokenLine)
	{
		this.errorTokenLine = errorTokenLine;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public Throwable getCause()
	{
		return cause;
	}

	public void setCause(Throwable cause)
	{
		this.cause = cause;
	}

	public static Map<String, String> getErrorLocalMap()
	{
		return errorLocalMap;
	}

	public static void setErrorLocalMap(Map<String, String> errorLocalMap)
	{
		ErrorInfo.errorLocalMap = errorLocalMap;
	}

}
