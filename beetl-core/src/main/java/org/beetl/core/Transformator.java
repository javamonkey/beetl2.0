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
package org.beetl.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.exception.TextParserException;
import org.beetl.core.statement.GrammarToken;

/**
 * 将模版转化为beetl script的代码，此为核心代码之一.似乎有一1.x有个小bug，换行导致输出乱了
 * 
 * @author jeolli
 */
public class Transformator {

	String htmlTagStart = "<#";
	String htmlTagEnd = "</#";
	String htmlTagBindingAttribute = "var";

	Stack htmlTagStack = new Stack();
	boolean isSupportHtmlTag = false;

	String placeholderStart = "$";
	String placeholderEnd = "$";
	String startStatement = "#:";
	String endStatement = null;
	boolean appendCR = false;
	String vname = "";
	int vnamesuffix = 0;
	Map<Integer, String> textMap = new TreeMap<Integer, String>();

	// 1 解析在文本处，2 解析在控制语句处，3 解析在占位符号里 4文件结束 5,html tag begin 6 html tag end
	int status = 1;
	// 最后转化的结果
	StringBuilder sb = new StringBuilder();
	// 输入
	char[] cs = null;
	int index = 0;
	// int currentLine = 0;
	LineStatus lineStatus = new LineStatus();
	// 合并行的行数
	int lineCount = 0;
	// 总共有多少行
	int totalLineCount = 0;

	String VCR = "<$__VCR>>";
	String lineSeparator = System.getProperty("line.separator");
	// 回车换行
	// char[] lineSeparatorCharArray = null;
	// 设置最多max-line行合并输出，现在不支持
	static int MAX_LINE = 78;
	// 转义符号
	static char ESCAPE = '\\';

	public Transformator() {

	}

	public Map<Integer, String> getTextMap() {
		return this.textMap;
	}

	public Transformator(String placeholderStart, String placeholderEnd, String startStatement, String endStatement) {
		this.placeholderStart = placeholderStart;
		this.placeholderEnd = placeholderEnd;
		this.startStatement = startStatement;
		this.endStatement = endStatement;

	}

	public String getPlaceholderStart() {
		return placeholderStart;
	}

	public void setPlaceholderStart(String placeholderStart) {
		this.placeholderStart = placeholderStart;
	}

	public String getPlaceholderEnd() {
		return placeholderEnd;
	}

	public void setPlaceholderEnd(String placeholderEnd) {
		this.placeholderEnd = placeholderEnd;
	}

	public String getStartStatement() {
		return startStatement;
	}

	public void setStartStatement(String startStatement) {
		this.startStatement = startStatement;
	}

	public String getEndStatement() {
		return endStatement;
	}

	public void setEndStatement(String endStatement) {
		this.endStatement = endStatement;

	}

	public void enableHtmlTagSupport(String tagStart, String tagEnd, String htmlTagBindingAttribute) {
		this.htmlTagStart = tagStart;
		this.htmlTagEnd = tagEnd;
		this.htmlTagBindingAttribute = htmlTagBindingAttribute;
		this.isSupportHtmlTag = true;
	}

	public Reader transform(Reader orginal) throws IOException, HTMLTagParserException {

		StringBuilder temp = new StringBuilder();
		int bufSzie = 1024;
		cs = new char[bufSzie];
		int len = -1;

		while ((len = orginal.read(cs)) != -1) {
			temp.append(cs, 0, len);

		}

		cs = temp.toString().toCharArray();
		// 找到回车换行符号
		findCR();

		checkAppendCR();
		parser();
		if (this.isSupportHtmlTag && this.htmlTagStack.size() != 0) {

			String tagName = (String) htmlTagStack.peek();
			GrammarToken token = GrammarToken.createToken(tagName, this.totalLineCount + 1);

			HTMLTagParserException ex = new HTMLTagParserException("解析html tag 标签出错,未找到匹配结束标签 " + tagName);

			ex.pushToken(token);
			ex.line = totalLineCount + 1;
			this.clear();
			throw ex;

		}

		orginal.close();
		return new StringReader(sb.toString());
	}

	private void findCR() {

		// 是回车换行,
		StringBuilder cr = new StringBuilder(2);
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '\n' || cs[i] == '\r') {
				cr.append(cs[i]);
				if (cs.length != (i + 1)) {
					char next = cs[i] == '\r' ? '\n' : '\r';
					if (cs[i + 1] == next) {
						cr.append(next);
					}
				}
				lineSeparator = cr.toString();

				// this.textMap.put("__VCR", lineSeparator);
				return;
			}
		}
	}

	public Reader transform(String str) throws IOException, HTMLTagParserException {
		cs = str.toCharArray();
		// 找到回车换行符号
		findCR();

		checkAppendCR();
		parser();
		if (this.isSupportHtmlTag && this.htmlTagStack.size() != 0) {
			String tagName = (String) htmlTagStack.peek();
			GrammarToken token = GrammarToken.createToken(tagName, this.totalLineCount + 1);

			HTMLTagParserException ex = new HTMLTagParserException("解析html tag 标签出错,未找到匹配结束标签 " + tagName);
			ex.pushToken(token);
			ex.line = totalLineCount + 1;
			this.clear();
			throw ex;
		}
		return new StringReader(sb.toString());
	}

	public void parser() throws HTMLTagParserException {

		while (true) {
			switch (status) {
				case 1: {
					readCommonString();
					break;
				}
				case 2: {
					readStatement();
					break;
				}
				case 3: {
					readPlaceHolder();
					break;
				}
				case 5:
					readHTMLTagBegin();
					break;
				case 6:
					readHTMLTagEnd();
					break;
				case 4: {

					return;
				}

			}
		}

	}

	public void readHTMLTagBegin() throws HTMLTagParserException {
		String tagName = null;
		try {
			StringBuilder script = new StringBuilder();
			HTMLTagParser html = new HTMLTagParser(cs, index, htmlTagBindingAttribute, true);

			html.parser();
			if (html.hasVarBinding) {
				script.append("htmltagvar");

			} else {
				script.append("htmltag");

			}
			tagName = html.getTagName();
			script.append("('").append(tagName).append("',");

			Map<String, String> map = html.getExpMap();
			Map<String, Character> quat = html.getQuatMap();
			if (map.size() != 0) {
				script.append("{");
			}
			for (Entry<String, String> entry : map.entrySet()) {

				String key = entry.getKey();
				String value = entry.getValue();
				if (html.crKey.contains(key)) {
					script.append(this.lineSeparator);
				}
				script.append(key).append(":");
				String attrValue = this.parseAttr(quat.get(key), value);
				script.append(attrValue);

				script.append(",");
			}

			script.setLength(script.length() - 1);
			if (map.size() != 0) {
				script.append("}");
			}

			if (html.hasVarBinding) {
				if (map.size() == 0) {
					// 保持三个参数，第一个为标签函数名，第二个为属性，第三个为申明的变量
					script.append(",{}");
				}
				if (html.varBidingStr.trim().length() == 0) {
					String defaultVarName = null;
					int index = tagName.lastIndexOf(":");
					if (index == -1) {
						defaultVarName = tagName;
					} else {
						defaultVarName = tagName.substring(index + 1);
					}
					script.append(",").append("'").append(defaultVarName).append("'");
				} else {
					script.append(",").append("'").append(html.varBidingStr).append("'");
				}

			}

			script.append("){");
			if (html.isEmptyTag()) {
				script.append("}");
			} else {
				htmlTagStack.push(tagName);
			}

			sb.append(script);
			this.index = html.getIndex();
			status = 1;
			this.lineStatus.setStatment();
		} catch (RuntimeException re) {

			if (tagName == null) {
				tagName = "未知标签";
			}
			GrammarToken token = GrammarToken.createToken(tagName, this.totalLineCount + 1);
			HTMLTagParserException ex = new HTMLTagParserException(re.getMessage());
			ex.pushToken(token);
			// todo
			// ex.token = token;
			ex.line = totalLineCount + 1;
			throw ex;

		}

	}

	public void readHTMLTagEnd() throws HTMLTagParserException {
		String tagName = null;
		try {
			HTMLTagParser html = new HTMLTagParser(cs, index, htmlTagBindingAttribute, false);

			html.parser();
			tagName = html.getTagName();
			if (htmlTagStack.empty()) {
				throw new RuntimeException("解析html tag出错");
			}
			String lastTag = (String) this.htmlTagStack.peek();
			if (tagName.equals(lastTag)) {
				this.htmlTagStack.pop();
				sb.append("}");
			} else {
				throw new RuntimeException("解析html tag出错,期望匹配标签" + lastTag);
			}
			this.index = html.getIndex();
			status = 1;
			this.lineStatus.setStatment();
		} catch (RuntimeException re) {

			if (tagName == null) {
				tagName = "未知标签";
			}
			GrammarToken token = GrammarToken.createToken(tagName, this.totalLineCount + 1);
			HTMLTagParserException ex = new HTMLTagParserException(re.getMessage());
			ex.pushToken(token);
			// ex.token = token;
			ex.line = totalLineCount + 1;
			throw ex;
		}

	}

	public void readPlaceHolder() {
		index = index + this.placeholderStart.length();
		lineStatus.addHolderCount();
		sb.append("<<");

		while (index <= cs.length) {
			if (match(this.placeholderEnd)) {
				// 如果前面一个是转义符
				if (this.isEscape(sb, index)) {
					sb.append(cs[index++]);
					continue;
				}

				index = index + this.placeholderEnd.length();
				sb.append(">>");
				status = 1;
				return;
			} else if (status != 4) {
				sb.append(cs[index]);
				index++;

			} else {
				break;
			}
		}
		status = 4;
	}

	public void readStatement() {
		index = index + this.startStatement.length();
		lineStatus.setStatment();
		boolean findEndStatement = false;
		int startLine = totalLineCount;
		while (index < cs.length) {
			if (endStatement != null && match(this.endStatement)) {

				findEndStatement = true;
				// 如果前面一个是转义符
				if (this.isEscape(sb, index)) {
					sb.append(cs[index++]);
					continue;
				}
				index = index + this.endStatement.length();
				status = 1;
				// 如果是以回车符作为控制语句结束符号
				if (appendCR) {

					lineStatus.setStatment();
					if (this.lineStatus.onlyStatment()) {
						// 只有控制语句，则如果文本变量都是空格，这些文本变量则认为是格式化的，非输出语句
						// 需要更改输出
						reforamtStatmentLine();
						lineStatus.reset();
						sb.append(endStatement);
					}

				} else {
					lineStatus.setStatment();
				}
				return;
			} else if (status != 4) {
				char ch = cs[index++];
				if (ch == '\r' || ch == '\n') {

					totalLineCount++;
					sb.append(this.lineSeparator);
					skipCR(ch);

					if (this.lineStatus.onlyStatment()) {
						// 只有控制语句，则如果文本变量都是空格，这些文本变量则认为是格式化的，非输出语句
						// 需要更改输出
						reforamtStatmentLine();
						lineStatus.reset();
					}

					// 如果回车符号还是定界符结束符号
					if (this.endStatement == null) {
						status = 1;
						return;

					}


				} else {
					// 正常路径
					sb.append(ch);
				}

			} else {
				break;
			}
		}

		status = 4;
		if (!findEndStatement && endStatement != null) {
			// throw new RuntimeException("未发现定界结束符号");
			GrammarToken token = GrammarToken.createToken(this.endStatement, this.totalLineCount + 1);

			TextParserException ex = new TextParserException("起始的第" + (startLine + 1) + "行的定界符'" + this.startStatement
					+ "'未找到匹配的结束符'" + this.endStatement + "'");
			ex.pushToken(token);
			ex.line = totalLineCount + 1;
			this.clear();
			throw ex;
		}
	}

	public void readCommonString() {
		StringBuilder temp = new StringBuilder();
		boolean hasLetter = false;
		boolean hasCheck = false;
		while (index <= cs.length) {
			if (match(this.placeholderStart)) {
				if (this.isEscape(temp, index)) {

					temp.append(cs[index++]);
					continue;
				}
				if (temp.length() != 0) {
					if (lineCount >= 1) {
						createMutipleLineTextNode(temp);
						lineCount = 0;
					} else {
						createTextNode(temp);
					}
				}

				status = 3;
				return;
			} else if (match(this.startStatement)) {
				if (this.isEscape(temp, index)) {
					temp.append(cs[index++]);
					continue;
				}
				if (temp.length() != 0) {
					if (lineCount >= 1) {
						createMutipleLineTextNode(temp);
						lineCount = 0;
					} else {
						createTextNode(temp);
					}
				}

				status = 2;
				return;
			} else if (isSupportHtmlTag && match(htmlTagEnd)) {

				if (temp.length() != 0) {
					if (lineCount >= 1) {
						createMutipleLineTextNode(temp);
						lineCount = 0;
					} else {
						createTextNode(temp);
					}
				}
				index = index + this.htmlTagEnd.length();
				status = 6;
				return;

			} else if (isSupportHtmlTag && match(htmlTagStart)) {

				if (temp.length() != 0) {
					if (lineCount >= 1) {
						createMutipleLineTextNode(temp);
						lineCount = 0;
					} else {
						createTextNode(temp);
					}
				}
				status = 5;
				index = index + this.htmlTagStart.length();
				return;

			} else if (status != 4) {
				char ch = cs[index++];
				if (ch == '\r' || ch == '\n') {
					totalLineCount++;
					this.skipCR(ch);
					if (!hasLetter && this.lineStatus.onlyText()) {
						// 多行，直到碰到占位符号才停止
						temp.append(this.lineSeparator);
						lineCount++;
						lineStatus.reset();
						continue;

					}
					if (this.lineStatus.onlyStatment()) {
						// 只有控制语句，则如果文本变量都是空格，这些文本变量则认为是格式化的，非输出语句
						// 需要更改输出
						if (temp.length() != 0) createTextNode(temp);
						reforamtStatmentLine();
						lineStatus.reset();
						sb.append(lineSeparator);
						continue;
					} else {

						// createTextNode(temp.append(lineSeparator));
						// // 总是需要回车换行
						// sb.append(this.lineSeparator);
						// lineStatus.reset();

						lineCount++;
						lineStatus.reset();
						temp.append(this.lineSeparator);
						continue;
					}

				} else {

					if (!hasCheck && ch != ' ' && ch != '\t') {
						hasLetter = true;
						hasCheck = true;
					}
					// 正常调用路径
					temp.append(ch);
				}

			} else {
				break;
			}
		}
		if (temp.length() != 0) createTextNode(temp);
		status = 4;
		return;

	}

	private void reforamtStatmentLine() {

		/*
		 * 是否需要删除控制语句俩边的空格，约定，如果一行只有控制语句以及空格或者tab，那么空格或者tab 将不是输出内容，而是格式化字符串，比如： 空格... <%for (item in userList!){ 空格+回车
		 * %>
		 */
		int count = lineStatus.getSpaceCount();
		for (int i = count - 1; i >= 0; i--) {
			int start = lineStatus.getSpaceTextStart(i);
			int end = lineStatus.getSpaceTextEnd(i);
			String varName = sb.substring(start + 2, end - 2);
			String orgText = this.textMap.get(Integer.parseInt(varName));
			sb.replace(start, end, orgText);
		}
		lineStatus.reset();
	}

	private void createTextNode(StringBuilder str) {
		if (str.length() == 0) {
			return;
		}
		String name = this.getNewVarName();
		this.textMap.put(Integer.parseInt(name), new String(str));
		String textVarName = "<$" + name + ">>";

		if (isSpace(str)) {
			lineStatus.addSpaceText(this.sb.length(), this.sb.length() + textVarName.length());
		} else {
			lineStatus.addTextCount();
		}

		this.sb.append(textVarName);
		str.setLength(0);

	}

	private void skipCR(char c) {
		if (index < cs.length) {
			char o = cs[index];
			if (c == '\r' && o == '\n') {
				index++;
			} else if (c == '\n' && o == '\r') {
				index++;
			}
		}
	}

	private void createMutipleLineTextNode(StringBuilder str) {
		int index = str.lastIndexOf(lineSeparator);
		String firstPart = str.substring(0, index);
		String secondPart = str.substring(index + lineSeparator.length());
		if (isSpace(new StringBuilder(secondPart))) {
			// 有可能是格式化字符串，单独计算
			createTextNode(new StringBuilder(firstPart + lineSeparator));
			// 压缩多行，但补充回车
			for (int i = 0; i < lineCount; i++) {
				sb.append(lineSeparator);
			}
			// 最后一行是文本和占位符混合，因此，单独算一个文本变量
			createTextNode(new StringBuilder(secondPart));
		} else {

			createTextNode(str);
			for (int i = 0; i < lineCount; i++) {
				sb.append(lineSeparator);
			}

		}
		str.setLength(0);
	}

	private boolean isSpace(StringBuilder str) {
		for (char c : str.toString().toCharArray()) {
			if (c != ' ' && c != '\t') {
				return false;
			}
		}
		return true;
	}

	public boolean match(String expectedStr) {

		int i = 0;
		while (i < expectedStr.length()) {
			if (cs.length == (index + i)) {
				// 行尾
				status = 4;
				return false;
			}
			if (cs[index + i] != expectedStr.charAt(i)) {
				return false;
			}
			i++;
		}
		return true;

		// 如果匹配，但往前看有转义符，则还是算不匹配
		/*
		 * if (isEscape(sb, index) && (this.status == 2 || this.status == 3)) return false; else return true;
		 */
	}

	/**
	 * 在match情况下，判断前面一符号是否是转义符号，如果是，则删除转义符号 2012-2-5 李bear
	 */
	public boolean isEscape(StringBuilder temp, int index) {
		if (index != 0 && cs[index - 1] == this.ESCAPE) {
			if (index >= 2 && cs[index - 2] == this.ESCAPE) {
				// 俩个转义符号，删除一个
				if (temp.length() != 0) temp.setLength(temp.length() - 1);
				return false;
			} else {
				// 将已经添加的转义符号删除
				if (temp.length() != 0) temp.setLength(temp.length() - 1);
				return true;
			}
		} else {
			return false;
		}

		// //将已经添加的转义符号删除
		// if(temp.length()!=0)temp.setLength(temp.length()-1);
		// return true ;
	}

	public String getNewVarName() {
		return this.vname + this.vnamesuffix++;
	}

	private void checkAppendCR() {
		if (this.endStatement == null) {
			this.appendCR = true;
		} else if (this.endStatement.indexOf("\n") != -1) {
			this.appendCR = true;
		} else if (this.endStatement.indexOf("\r") != -1) {
			this.appendCR = true;
		} else {
			this.appendCR = false;
		}
	}

	public String parseAttr(char q, String attr) {
		// attr="aa{bb}cc" => ("aa"+(bb)+"cc") todo: 太难看了，会有很多潜在问题，需要一个专门的解析器，类似字符串模版,或者正则表达式
		StringBuilder sb = new StringBuilder(attr.length() + 10);
		int start = 0;
		int end = 0;
		int index = -1;
		while ((index = attr.indexOf(placeholderStart, start)) != -1) {

			int holdStart = index;

			while ((end = attr.indexOf(placeholderEnd, holdStart)) != -1) {
				if (attr.charAt(end - 1) == '\\') {
					// 非占位结束符号
					holdStart = end + 1;
					continue;
				} else {
					break;
				}
			}

			if (end == -1) throw new RuntimeException(attr + "标签属性错误，有站位符号，但找不到到结束符号");
			if (index != 0) {
				// 字符串
				sb.append(q).append(attr.substring(start, index)).append(q).append("+");
			}
			// 占位符号
			String value = attr.substring(index + this.placeholderStart.length(), end);
			value = value.replace("\\}", "}");
			sb.append("(").append(value).append(")").append("+");
			start = end + placeholderEnd.length();
		}
		// attr = "aaaa";
		if (start == 0) {
			// 全字符串
			return sb.append(q).append(attr).append(q).toString();
		}

		if (start != attr.length()) {
			// 最后一个是字符串
			sb.append(q).append(attr.substring(start, attr.length())).append(q);
		} else {
			// 删除“＋”
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		char c = '\\';
		Transformator p = new Transformator("${", "}", "<%", "%>");
		p.enableHtmlTagSupport("<#", "/#>", "var");
		try {

			// String str = " #:var u='hello';:# \n $u$";
			String str = "<%a%>a\n<%c%>";

			BufferedReader reader = new BufferedReader(p.transform(str));
			String line = null;
			System.out.println(p.getTextMap());
			String v = p.getTextMap().get(0);
			System.out.println("==============================");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}

	public void clear() {
		this.cs = null;

		this.sb = null;
	}

}

// 记录一行出现的控制语句，占位符号，以及用于格式化的空格，tab符号
class LineStatus {
	// 当前行非空格（包括tab）符号 个数
	private int textCount = 0;
	// 当前行控制语句个数
	private int statementCount = 0;
	// 当前行占位符号个数
	private int holderCount = 0;
	// 当前行用于格式化的空格（包括tab）所在sb的索引位置
	private List<Integer> startTextIndexList = new ArrayList<Integer>();
	private List<Integer> endTextIndexList = new ArrayList<Integer>();
	private int lineCount;

	public boolean onlyStatment() {
		// //如果包含普通文本，占位符
		// if ((textCount > 0 && startTextIndexList.size() != textCount) ||
		// holderCount > 0)
		// {
		// return false;
		// }
		// else
		// {
		// //如果有空格，没有控制语句
		// if (this.getSpaceCount() > 0 && this.statementCount == 0)
		// {
		// return false;
		// }
		//
		// return true;
		// }

		return this.statementCount != 0 && holderCount == 0;

	}

	/* 本行是否只有文本 */
	public boolean onlyText() {
		if (holderCount == 0 && this.statementCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addTextCount() {

		this.textCount++;
	}

	public void addHolderCount() {

		this.holderCount++;

	}

	// 表示改行有statment
	public void setStatment() {
		this.statementCount = 1;
	}

	public void addSpaceText(int start, int end) {
		startTextIndexList.add(start);
		endTextIndexList.add(end);
	}

	public int getSpaceTextStart(int i) {
		return startTextIndexList.get(i);
	}

	public int getSpaceTextEnd(int i) {
		return this.endTextIndexList.get(i);
	}

	public int getSpaceCount() {
		return this.startTextIndexList.size();
	}

	public int getTextCount() {
		return textCount;
	}

	public void reset() {

		textCount = 0;
		statementCount = 0;
		holderCount = 0;
		startTextIndexList.clear();
		endTextIndexList.clear();

	}

}
