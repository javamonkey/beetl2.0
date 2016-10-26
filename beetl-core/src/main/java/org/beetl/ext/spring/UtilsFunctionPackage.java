package org.beetl.ext.spring;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.Cookie;

import org.beetl.core.Context;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;
import org.springframework.web.util.WebUtils;

/**
 * 整合了Spring自带静态工具类功能的FP类
 *
 * @author Chen Rui
 */
public class UtilsFunctionPackage {
	/* --- --- 以下方法定义在org.springframework.util包下 --- --- */
	/* --- CollectionUtils包功能 --- */
	/**
	 * 测试source集合中是否包含candidates集任意元素
	 *
	 * @param source
	 * @param candidates
	 * @return 测试source集合中是否包含candidates集任意元素
	 */
	public boolean containsAny(Collection<?> source, Collection<?> candidates) {
		return CollectionUtils.containsAny(source, candidates);
	}

	/**
	 * 返回在source集合总第一个也属于candidates集的元素
	 *
	 * @param source
	 * @param candidates
	 * @return 返回在source集合总第一个也属于candidates集的元素
	 */
	public Object findFirstMatch(Collection<?> source, Collection<?> candidates) {
		return CollectionUtils.findFirstMatch(source, candidates);
	}

	/* --- PatternMatchUtils包功能 --- */
	/**
	 * 以Ant表达式语法(*表达式)判断输入字符串是否匹配表达式<br>
	 * 传入多个表达式时，只要有一个满足即可
	 *
	 * @param input
	 *            测试字符串
	 * @param patterns
	 *            匹配表达式
	 * @return 以Ant表达式语法(*表达式)判断输入字符串是否匹配表达式
	 */
	public boolean antMatch(String input, String... patterns) {
		return PatternMatchUtils.simpleMatch(patterns, input);
	}

	/* --- StringUtils包功能 --- */
	/**
	 * 返回指定路径的文件的扩展名<br>
	 * 注意返回结果不带"."
	 *
	 * @param path
	 * @return
	 */
	public String fileExtension(String path) {
		return StringUtils.getFilenameExtension(path);
	}

	/**
	 * 无视大小写的endsWith判断
	 *
	 * @param input
	 *            测试文本
	 * @param suffix
	 *            指定后缀
	 * @return 无视大小写的endsWith判断
	 */
	public boolean endsWithIgnoreCase(String input, String suffix) {
		return StringUtils.endsWithIgnoreCase(input, suffix);
	}

	/**
	 * 无视大小写的startsWith判断
	 *
	 * @param input
	 *            测试文本
	 * @param prefix
	 *            指定前缀
	 * @return 无视大小写的startsWith判断
	 */
	public boolean startsWithIgnoreCase(String input, String prefix) {
		return StringUtils.startsWithIgnoreCase(input, prefix);
	}

	/**
	 * 测试输入值是否为空白, null视为空白, 无视字符串中的空白字符
	 *
	 * @param input
	 *            输入文本
	 * @return 测试输入值是否为空白
	 */
	public boolean isBlank(String input) {
		return !StringUtils.hasText(input);
	}

	/**
	 * 首字母大写
	 *
	 * @param input
	 *            输入文本
	 * @return 首字母大写
	 */
	public String capitalize(String input) {
		return StringUtils.capitalize(input);
	}

	/**
	 * 首字母小写
	 *
	 * @param input
	 *            输入文本
	 * @return 首字母小写
	 */
	public String uncapitalize(String input) {
		return StringUtils.uncapitalize(input);
	}

	/**
	 * 在集合或数组元素之间拼接指定分隔符返回字符串
	 *
	 * @param collection
	 *            传入集合或数组, null表示空集, 其他类型表示单元素集合
	 * @param delim
	 *            分隔符
	 * @return 在集合或数组元素之间拼接指定分隔符返回字符串
	 */
	public String join(Object collection, String delim) {
		return joinEx(collection, delim, "", "");
	}

	/**
	 * 在集合或数组元素之间拼接指定分隔符返回字符串, 并在前后拼接前后缀
	 *
	 * @param collection
	 *            传入集合或数组, null表示空集, 其他类型表示单元素集合
	 * @param delim
	 *            分隔符
	 * @param prefix
	 *            前缀
	 * @param suffix
	 *            后缀
	 * @return 在集合或数组元素之间拼接指定分隔符返回字符串
	 */
	public String joinEx(Object collection, String delim, String prefix, String suffix) {
		if (collection == null) {
			return StringUtils.collectionToDelimitedString(Collections.emptyList(), delim, prefix, suffix);
		} else if (collection instanceof Collection) {
			return StringUtils.collectionToDelimitedString((Collection<?>) collection, delim, prefix, suffix);
		} else if (collection.getClass().isArray()) {
			return StringUtils.collectionToDelimitedString(CollectionUtils.arrayToList(collection), delim, prefix, suffix);
		} else {
			return StringUtils.collectionToDelimitedString(Collections.singletonList(collection), delim, prefix, suffix);
		}
	}

	/* --- --- 以下方法定义在org.springframework.web.util包下 --- --- */
	/* --- HtmlUtils包功能 --- */
	/**
	 * 对值进行HTML转义
	 *
	 * @param input
	 *            输入文本
	 * @return 转义文本
	 */
	public String html(String input) {
		return HtmlUtils.htmlEscape(input);
	}

	/* --- JavaScriptUtils包功能 --- */
	/**
	 * 对值进行JavaScript转义
	 *
	 * @param input
	 *            输入文本
	 * @return 转义文本
	 */
	public String javaScript(String input) {
		return JavaScriptUtils.javaScriptEscape(input);
	}

	
}