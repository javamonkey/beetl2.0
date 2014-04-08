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
	String errorCode = null;
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
			this.errorTokenText = ex.token.text;
		}

		this.msg = ex.getMessage();
		this.errorTokenLine = ex.token.line;
		this.type = errorLocalMap.get(errorCode);
		if (type == null)
		{
			type = errorCode;
		}

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

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
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
