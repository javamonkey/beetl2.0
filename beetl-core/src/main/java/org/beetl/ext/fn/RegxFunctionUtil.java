package org.beetl.ext.fn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class RegxFunctionUtil {
	/**
	 * 进行正则判断
	 * 
	 * @param str 判断的字符串
	 * @param regex 正则表达式
	 * @return　是否存在符合正则的字符串
	 */
	public boolean match(String str, String regex) {
		if (str == null || regex == null)
			return false;
		if (regex.trim().isEmpty())
			return true;
		return Pattern.compile(regex.trim()).matcher(str).find();
	}

	/**
	 * 进行正则替换 replace中的$1 $9 分别对应group(1-9)
	 * 
	 * @param str 需要处理的字符串
	 * @param regex 正则表达式
	 * @param replace 替换的字符串
	 * @return 进行正则表达式替换
	 */
	public String replace(String str, String regex, String replace) {
		if (str == null)
			return "";
		if (regex == null)
			return str;
		if(replace == null) replace = "";
		return str.replaceAll(regex, replace);
	}

	/**
	 * 根据正则表达式找到字符串
	 * 
	 * @param str 查找的字符串
	 * @param regex 正则表达式
	 * @return　第一个符合的正则表达式的字符串
	 */
	public String find(String str, String regex) {
		if (str == null || regex == null)
			return "";
		Matcher m = Pattern.compile(regex).matcher(str);
		if (m.find()) {
			return m.group();
		} else
			return "";
	}

	/**
	 * 找到符合正则表达式的所有字符串
	 * 
	 * @param str 查找的字符串
	 * @param regex　正则表达式
	 * @return 返回符合正则表达式的所有字符串列表
	 */
	public List<String> findList(String str, String regex) {
		ArrayList<String> ret = new ArrayList<String>();
		if (str == null || regex == null)
			return ret;
		Matcher m = Pattern.compile(regex).matcher(str);
		while (m.find()) {
			ret.add(m.group());
		}
		return ret;
	}

	/**
	 * 根据正则表达式进行切分
	 * 
	 * @param str 查找的字符串
	 * @param regex 正则表达式
	 * @return 切分后的字符串
	 */
	public List<String> split(String str, String regex) {
		if (str == null || regex == null)
			return new ArrayList<String>();
		return Arrays.asList(str.split(regex));
	}

	/**
	 * 根据正则表达式进行切分
	 * 
	 * @param str 查找的字符串
	 * @param regex 正则表达式
	 * @param limit 分成的字符串的个数
	 * @return 切分后的字符串
	 */
	public List<String> splitLimit(String str, String regex, int limit) {
		if (str == null || regex == null)
			return new ArrayList<String>();
		return Arrays.asList(str.split(regex, limit));
	}

	public static void main(String[] args) {
//		RegxFunctionUtil fun = new RegxFunctionUtil();
//		int i = 0;
//		System.out.println("Match function");
//		System.out.println(String.valueOf(i++)+"\tfalse\t"+fun.match(null, null));
//		System.out.println(String.valueOf(i++)+"\tfalse\t"+fun.match("wahaha", null));
//		System.out.println(String.valueOf(i++)+"\tfalse\t"+fun.match(null, "ha"));
//		System.out.println(String.valueOf(i++)+"\ttrue\t"+fun.match("waha", "ah"));
//		System.out.println(String.valueOf(i++)+"\ttrue\t"+fun.match("waha", ""));
//		System.out.println(String.valueOf(i++)+"\tfalse\t"+fun.match("", "www"));
//		System.out.println(String.valueOf(i++)+"\tfalse\t"+fun.match("waaa", "s"));
//		System.out.println("replace function");
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace(null, null,null));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace(null, "ah",null));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace("wahaha", null,null));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace(null, null,"aq"));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace(null, "ah","aq"));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace("wahaha", "ah",null));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace("wahaha", null,"aq"));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.replace("wahaha", "ah",""));
//		System.out.println(String.valueOf(i++)+"\twaqaqa\t"+fun.replace("wahaha", "ah","aq"));
//		System.out.println(String.valueOf(i++)+"\twahaha\t"+fun.replace("wahaha", "ad","aq"));
//		System.out.println(String.valueOf(i++)+"\twqhqha\t"+fun.replace("wahaha", "a(h)a","q$1q"));
//		System.out.println("find function");
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.find("contain 900g/bag", null));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.find(null, "[0-9]+"));
//		System.out.println(String.valueOf(i++)+"\t900\t"+fun.find("contain 900g/bag", "[0-9]+"));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.find("contain g/bag", "[0-9]+"));
//		System.out.println(String.valueOf(i++)+"\t900\t"+fun.find("contain 900g/1200bag", "[0-9]+"));
//		
//		System.out.println("findlist function");
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.findList("contain 900g/bag", null));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.findList(null, "[0-9]+"));
//		System.out.println(String.valueOf(i++)+"\t900\t"+fun.findList("contain 900g/bag", "[0-9]+"));
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.findList("contain g/bag", "[0-9]+"));
//		System.out.println(String.valueOf(i++)+"\t900  1200\t"+fun.findList("contain 900g/1200bag", "[0-9]+"));
//		System.out.println("splite function");
//		System.out.println(String.valueOf(i++)+"\tblank\t"+fun.split(null, "-"));
//		System.out.println(String.valueOf(i++)+"\t中国-美国\t"+fun.split("中国-美国",null));
//		System.out.println(String.valueOf(i++)+"\t中 国 - 美 国\t"+fun.split("中国-美国", ""));
//		System.out.println(String.valueOf(i++)+"\t中国  美国\t"+fun.split("中国-美国", "-"));
		
	}
}
