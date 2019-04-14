/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
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

import java.util.ArrayList;
import java.util.List;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.statement.GrammarToken;

/**
 * Beetl异常基类，此异常包含了错误码，错误符号，所属的模板文件，以及错误详情，错误栈
 * @author joelli
 *
 */
public class BeetlException extends RuntimeException {
	/**
	 * 错误的Token
	 */
	public GrammarToken token = null;
	/**
	 * 错误码
	 */
	public String detailCode;
	/**
	 * 资源id
	 */
	public Resource resource = null;

	public List<Resource> errorResourceStack = new ArrayList<Resource>(3);
	public List<GrammarToken> errorTokenStack = new ArrayList<GrammarToken>(3);

	public boolean inTagBody = false;

	/**
	 * GroupTemplate
	 */
	public GroupTemplate gt = null;
	/**
	 * 模板换行符
	 */
	public String cr = null;

	/**
	 * 
	 */
	public static final String DO_NOT_SUPPORT = "DO_NOT_SUPPORT";
	/**
	 * 变量已经定义过了
	 */
	public static final String VAR_ALREADY_DEFINED = "VAR_ALREADY_DEFINED";

	/**
	 * AJAX已经定义过了
	 */
	public static final String AJAX_ALREADY_DEFINED = "AJAX_ALREADY_DEFINED";

	/**
	 * AJAX已经定义过了
	 */
	public static final String AJAX_NOT_FOUND = "AJAX_NOT_FOUND";

	/**
	 * AJAX 属性定义错误
	 */
	public static final String AJAX_PROPERTY_ERROR = "AJAX_PROPERTY_ERROR";

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
	 * 虚拟属性未定义错误
	 */
	public static final String VIRTUAL_NOT_FOUND = "VIRTUAL_NOT_FOUND";

	/**
	 * 标签实例化错误
	 */
	public static final String TAG_INSTANCE_ERROR = "TAG_INSTANCE_ERROR";

	/**
	 * 本地调用错误，如classnotfound,methodnotfound等
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
	 * 期望是个集合，数组，Iterator，Iterable类型，但却是其他类型
	 */
	public static final String COLLECTION_EXPECTED_ERROR = "COLLECTION_EXPECTED_ERROR";

	/**
	 * 期望是数字类型，但却是其他类型
	 */
	public static final String NUMBER_EXPECTED_ERROR = "NUMBER_EXPECTED_ERROR";

	/**
	 * 严格MVC错误，模板使用严格MVC，但模板内容含有不允许的语法
	 */
	public static final String STRICK_MVC = "STRICK_MVC";

	/**
	 * 不允许调用本地方法
	 */
	public static final String NATIVE_NOT_ALLOWED = "NATIVE_NOT_ALLOWED";

	// 对象的属性get方法出错
	public static final String GET_CALL_ERROR = "GET_CALL_ERROR";

	// has函数调用错误
	public static final String HAS_CALL_ILLEGAL = "HAS_CALL_ILLEGAL";

	// 语法错误
	public static final String ERROR = "ERROR";

	public static final String TOKEN_ERROR = "TOKEN_ERROR";
	public static final String PARSER_UNKNOW_ERROR = "PARSER_UNKNOW_ERROR";
	public static final String PARSER_VIABLE_ERROR = "PARSER_VIABLE_ERROR";
	public static final String PARSER_MISS_ERROR = "PARSER_MISS_ERROR";
	public static final String PARSER_PREDICATE_ERROR = "PARSER_PREDICATE_ERROR";
	// HTML TAG 解析出错
	public static final String PARSER_HTML_TAG_ERROR = "PARSER_HTML_TAG_ERROR";
	// 类型识别错误
	public static final String TYPE_SEARCH_ERROR = "TYPE_SEARCH_ERROR";

	// 本地调用格式错误,如a[0](1,2)
	public static final String PARSER_NATIVE_ERROR = "PARSER_NATIVE_ERROR";

	// 模板加载失败
	public static final String TEMPLATE_LOAD_ERROR = "TEMPLATE_LOAD_ERROR";

	// Client IO
	public static final String CLIENT_IO_ERROR_ERROR = "CLIENT_IO_ERROR_ERROR";

	// 表达式类型不一致，无法运算,如俩个字符串相乘
	public static final String EXPRESSION_NOT_COMPATIBLE = "EXPRESSION_NOT_COMPATIBLE";
	// 不允许的语法
	public static final String GRAMMAR_NOT_ALLOWED = "GRAMMAR_NOT_ALLOWED";

	public BeetlException(String detailCode, String msg) {
		super(msg);

		this.detailCode = detailCode;

	}

	public BeetlException(String detailCode) {
		super();
		this.detailCode = detailCode;
	}

	public BeetlException(String detailCode, Throwable cause) {
		super(cause);
		this.detailCode = detailCode;

	}

	public BeetlException(String detailCode, String msg, Throwable cause) {
		super(msg, cause);
		this.detailCode = detailCode;
	}

	@Override
	public String toString() {
		return detailCode;
		// return "Error:" + detailCode + "at " + token.line + super.getMessage() != null ? super.getMessage() : "";
	}

	public void pushResource(Resource resource) {

		if (this.inTagBody) {
			/**
			 * 如果当前渲染的是html标签，则出错资源应该使用该html标签的页面，而不是渲染改标签的页面
			 * 参考,HTMLTagSupportWrapper2,TagStatment
			 * <#form >
				<#block>
				<#input name="a"/>
				</#block>
				</#form>
				 input 内部渲染错误，但显示的出错页面应该是这个html页面，而不是block标签页面
				 2018-9-9
			 */
			this.inTagBody = false;
			return;
		}
		if (this.resource == null) {
			this.resource = resource;
		}
		this.errorResourceStack.add(resource);

	}

	public void pushToken(GrammarToken token) {

		if (this.token == null) {
			this.token = token;
		}

		this.errorTokenStack.add(token);
	}

	/**
	 * 返回一个描述信息
	 * @return
	 */
	public ErrorInfo toErrorInfo(){
		return new ErrorInfo(this);
	}

}
