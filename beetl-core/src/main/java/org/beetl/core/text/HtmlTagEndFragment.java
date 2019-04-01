package org.beetl.core.text;

import java.util.Stack;

import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.statement.GrammarToken;

public class HtmlTagEndFragment extends ScriptFragment {
	HTMLTagContentParser html = null;
	boolean appendCr = false ;
    public HtmlTagEndFragment(Source source) {
        super(source);
    }

    @Override
    public StringBuilder getScript() {
    	String tagName = null;
    	Stack<String> htmlTagStack = source.htmlTagConfig.htmlTagStack;

		try
		{
			tagName = html.getTagName();
			if (htmlTagStack.empty())
			{
				throw new RuntimeException("解析html tag出错");
			}
			String lastTag = (String) htmlTagStack.peek();
			if (tagName.equals(lastTag))
			{
				htmlTagStack.pop();
				script.append("}");
			}
			else
			{
				throw new RuntimeException("解析html tag出错,期望匹配标签" + lastTag);
			}
			
			if(this.appendCr) {
				script.append(TextParser.cr1);
			}
			return script;
		}
		catch (RuntimeException re)
		{

			if (tagName == null)
			{
				tagName = "未知标签";
			}
			GrammarToken token = GrammarToken.createToken(tagName, source.curLine+ 1);
			HTMLTagParserException ex = new HTMLTagParserException(re.getMessage());
			ex.pushToken(token);
			//ex.token = token;
			ex.line = source.curLine + 1;
			throw ex;
		}
    }

    @Override
    public Fragment consumeAndReturnNext() {
    	String htmlTagBindingAttribute = source.htmlTagConfig.htmlTagBindingAttribute;
		html = new HTMLTagContentParser(source.cs, source.p, htmlTagBindingAttribute, false);
		html.parser();
		source.move(html.index);
		this.endLine = this.startLine;
		return super.findNext();
    }

    @Override
	public void appendCr() {
		appendCr = true;
		
	}



}
