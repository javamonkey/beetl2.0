package org.beetl.core.text;

import java.util.Stack;

/**
 * html 配置
 * 
 * @author Administrator
 *
 */
public class HtmlTagConfig {
    String htmlTagStart = "<#";
    String htmlTagEnd = "</#";
    String htmlTagBindingAttribute = "var";

    char[] start = null;
    char[] end = null;
    
    //<#a attr="${abc}" >
    String phStart = "${";
    String phEnd = "}";

    Stack<String> htmlTagStack = new Stack<String>();
    Source source = null;

    public HtmlTagConfig(String htmlTagStart, String htmlTagEnd, String htmlTagBindingAttribute) {
        this.htmlTagStart = htmlTagStart;
        this.htmlTagEnd = htmlTagEnd;
        this.htmlTagBindingAttribute = htmlTagBindingAttribute;
        this.start = htmlTagStart.toCharArray();
        this.end = this.htmlTagEnd.toCharArray();
    }
    
    public HtmlTagConfig() {
    	 this.start = htmlTagStart.toCharArray();
         this.end = this.htmlTagEnd.toCharArray();
    }

    public void init(Source source) {
        this.source = source;
        phStart = new String(source.pd.start);
        phEnd = new String(source.pd.end);
    }

    public boolean matchTagStart() {
        return source.matchAndSKip(start);
    }

    public boolean matchTagEnd() {
        return source.matchAndSKip(end);
    }

    public String getHtmlTagStart() {
        return htmlTagStart;
    }

    public void setHtmlTagStart(String htmlTagStart) {
        this.htmlTagStart = htmlTagStart;
    }

    public String getHtmlTagEnd() {
        return htmlTagEnd;
    }

    public void setHtmlTagEnd(String htmlTagEnd) {
        this.htmlTagEnd = htmlTagEnd;
    }

    public String getHtmlTagBindingAttribute() {
        return htmlTagBindingAttribute;
    }

    public void setHtmlTagBindingAttribute(String htmlTagBindingAttribute) {
        this.htmlTagBindingAttribute = htmlTagBindingAttribute;
    }

    public Stack getHtmlTagStack() {
        return htmlTagStack;
    }

    public void setHtmlTagStack(Stack htmlTagStack) {
        this.htmlTagStack = htmlTagStack;
    }

}
