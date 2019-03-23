package org.beetl.core.text;

import java.util.Stack;

import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.statement.GrammarToken;

public class HtmlTagEndFragment extends Fragment {
	HTMLTagContentParser html = null;
	StringBuilder script = new StringBuilder();
    public HtmlTagEndFragment(Source source) {
        super(source);
        // TODO Auto-generated constructor stub
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
		return super.findNext();
    }



}
