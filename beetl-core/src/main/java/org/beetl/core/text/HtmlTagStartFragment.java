package org.beetl.core.text;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.statement.GrammarToken;

public class HtmlTagStartFragment extends ScriptFragment {
	HTMLTagContentParser html = null;
	boolean appendCr = false ;
	public HtmlTagStartFragment(Source source) {
		super(source);
	}

	@Override
	public StringBuilder getScript() {
		String tagName = null;
		Stack<String> htmlTagStack = source.htmlTagConfig.htmlTagStack;
		try {
			if(html.hasVarBinding&&html.hasExportBinding) {
				throw new RuntimeException("不能同时有var 和 export ，只能选一个");
			}
			if (html.hasVarBinding) {
				script.append("htmltagvar");

			} else if(html.hasExportBinding){
				//AntlrProgramBuilder 遇到此htmltagexport 会认为是htmltagvar，但变量作用域不限制
				script.append("htmltagexport");
			}else {
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
					script.append(TextParser.cr1);
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

			if (html.hasVarBinding||html.hasExportBinding) {
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
				// 记住开头
				htmlTagStack.push(tagName);
			}
			
			if(this.appendCr) {
				script.append(TextParser.cr1);
			}
			return script;
		} catch (RuntimeException re) {

			if (tagName == null) {
				tagName = "未知标签";
			}
			GrammarToken token = GrammarToken.createToken(tagName, source.curLine + 1);
			HTMLTagParserException ex = new HTMLTagParserException(re.getMessage());
			ex.pushToken(token);

			ex.line = source.curLine + 1;
			throw ex;

		}
	}

	@Override
	public Fragment consumeAndReturnNext() {
		String htmlTagBindingAttribute = source.htmlTagConfig.htmlTagBindingAttribute;
		html = new HTMLTagContentParser(source.cs, source.p, htmlTagBindingAttribute, true);
		html.parser();
		source.move(html.index);
		this.endLine = this.startLine+html.crKey.size();
		return super.findNext();
	}

	public String parseAttr(char q, String attr) {
		String phStart = source.htmlTagConfig.phStart;
		String phEnd = source.htmlTagConfig.phEnd;
		// return attr;
		// attr="aa{bb}cc" => ("aa"+(bb)+"cc") todo:
		// 太难看了，会有很多潜在问题，需要一个专门的解析器，类似字符串模版,或者正则表达式
		StringBuilder sb = new StringBuilder(attr.length() + 10);
		int start = 0;
		int end = 0;
		int index = -1;
		while ((index = attr.indexOf(phStart, start)) != -1) {

			int holdStart = index;

			while ((end = attr.indexOf(phEnd, holdStart)) != -1) {
				if (attr.charAt(end - 1) == '\\') {
					// 非占位结束符号
					holdStart = end + 1;
					continue;
				} else {
					break;
				}
			}

			if (end == -1){
				throw new RuntimeException(attr + "标签属性错误，有站位符号，但找不到到结束符号");
			}
			if (index != 0) {
				// 字符串
				sb.append(q).append(attr.substring(start, index)).append(q).append("+");
			}
			// 占位符号
			String value = attr.substring(index + phStart.length(), end);
			value = value.replace("\\}", "}");
			sb.append("(").append(value).append(")").append("+");
			start = end + phEnd.length();
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
	
	public void appendCr() {
		appendCr = true;
		
	}



}
