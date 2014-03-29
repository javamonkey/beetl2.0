package org.beetl.core.exception;

import org.beetl.core.GroupTemplate;
import org.beetl.core.statement.GrammarToken;

public class BeetlException extends RuntimeException
{
	public GrammarToken token = null;
	public String detailCode;
	public String resourceId = null;
	public GroupTemplate gt = null;
	public String cr = null;

	/**
	 * 指示beetl现在不支持的功能
	 */
	public static final String DO_NOT_SUPPORT = "DO_NOT_SUPPORT";
	/**
	 * 变量已经定义过了
	 */
	public static final String VAR_ALREADY_DEFINED = "VAR_ALREADY_DEFINED";
	/**
	 * 变量只读，通过template.set()的变量，即用于渲染模板的变量都是只读的，不能在模板中被改写
	 */
	public static final String VAR_READONLY = "VAR_READONLY";

	/**
	 * 模板引用未定义的变量
	 */
	public static final String VAR_NOT_DEFINED = "VAR_NOT_DEFINED";

	/**
	 * 函数未定义错误
	 */
	public static final String FUNCTION_NOT_FOUND = "FUNCTION_NOT_FOUND";

	/**
	 * 函数定义错误
	 */
	public static final String FUNCTION_INVALID = "FUNCTION_INVALID";
	/**
	 * 标签未定义错误
	 */
	public static final String TAG_NOT_FOUND = "TAG_NOT_FOUND";

	/**
	 * 标签实例化错误
	 */
	public static final String TAG_INSTANCE_ERROR = "TAG_INSTANCE_ERROR";

	/**
	 * 本地调用错误，如classnotfound等
	 */
	public static final String NATIVE_CALL_INVALID = "NATIVE_CALL_INVALID";
	/**
	 * 被调用的class抛出了异常
	 */
	public static final String NATIVE_CALL_EXCEPTION = "NATIVE_CALL_EXCEPTION";
	/**
	 * 不允许本地调用
	 */
	public static final String NATIVE_SECUARITY_EXCEPTION = "NATIVE_SECUARITY_EXCEPTION";
	/**
	 * 格式化函数不存在错误
	 */
	public static final String FORMAT_NOT_FOUND = "FORMAT_NOT_FOUND";
	public static final String DEFAULT_FORMAT_NOT_FOUND = "DEFAULT_FORMAT_NOT_FOUND";

	/**
	 * 表达式运行错误
	 */
	public static final String EXPRESSION_INVALID = "EXPRESSION_INVALID";
	/**
	 * 引用属性错误
	 */
	public static final String ATTRIBUTE_INVALID = "ATTRIBUTE_INVALID";
	public static final String ATTRIBUTE_NOT_FOUND = "ATTRIBUTE_NOT_FOUND";
	/**
	 * 模板里使用了[]指示应该是Map或者List，但实际上不是此类型
	 */
	public static final String CAST_LIST_OR_MAP_ERROR = "CAST_LIST_OR_MAP_ERROR";
	public static final String NULL = "NULL";
	/**
	 * 虚拟属性使用错误
	 */
	public static final String VIRTUAL_ATTRIBUTE_NOT_FOUND_EVAL = "VIRTUAL_ATTRIBUTE_NOT_FOUND_EVAL";
	/**
	 * 除0错误
	 */
	public static final String DIV_ZERO_ERROR = "DIV_ZERO_ERROR";
	/**
	 * 数组index错
	 */
	public static final String ARRAY_INDEX_ERROR = "ARRAY_INDEX_ERROR";

	/**
	 * 必须是数组
	 */
	public static final String ARRAY_TYPE_ERROR = "ARRAY_TYPE_ERROR";
	/**
	 * 期望表达式返回bool值，但却是其他类型
	 */
	public static final String BOOLEAN_EXPECTED_ERROR = "BOOLEAN_EXPECTED_ERROR";
	/**
	 * 严格MVC错误，模板使用严格MVC，但模板内容含有不允许的语法
	 */
	public static final String STRICK_MVC = "STRICK_MVC";

	/**
	 * 不允许调用本地方法
	 */
	public static final String NATIVE_NOT_ALLOWED = "NATIVE_NOT_ALLOWED";

	//对象的属性get方法出错
	public static final String GET_CALL_ERROR = "GET_CALL_ERROR";

	//断言异常，与assert函数一起使用
	public static final String ASSERT_ERROR = "ASSERT_ERROR";

	//语法错误
	public static final String ERROR = "ERROR";
	public static final String OPT_ERROR = "OPT_ERROR";

	public static final String PARSER_UNKNOW_ERROR = "PARSER_UNKNOW_ERROR";
	public static final String PARSER_VIABLE_ERROR = "PARSER_VIABLE_ERROR";
	public static final String PARSER_MISS_ERROR = "PARSER_MISS_ERROR";
	public static final String PARSER_PREDICATE_ERROR = "PARSER_PREDICATE_ERROR";
	//HTML TAG 解析出错
	public static final String PARSER_HTML_TAG_ERROR = "PARSER_HTML_TAG_ERROR";
	//类型识别错误
	public static final String TYPE_SEARCH_ERROR = "TYPE_SEARCH_ERROR";

	//本地调用格式错误,如a[0](1,2)
	public static final String PARSER_NATIVE_ERROR = "PARSER_NATIVE_ERROR";

	//模板加载失败
	public static final String TEMPLATE_LOAD_ERROR = "TEMPLATE_LOAD_ERROR";

	//Client IO 
	public static final String CLIENT_IO_ERROR_ERROR = "CLIENT_IO_ERROR_ERROR";

	//表达式类型不一致，无法运算,如俩个字符串相乘
	public static final String EXPRESSION_NOT_COMPATIBLE = "EXPRESSION_NOT_COMPATIBLE";

	public BeetlException(String detailCode, String msg)
	{
		super(msg);

		this.detailCode = detailCode;

	}

	public BeetlException(String detailCode)
	{
		super();
		this.detailCode = detailCode;
	}

	public BeetlException(String detailCode, String msg, Throwable cause)
	{
		super(msg, cause);
		this.detailCode = detailCode;
	}

	public String toString()
	{
		return "Error:" + detailCode + "at " + token.line + super.getMessage() != null ? super.getMessage() : "";
	}

}
