package org.beetl.core.text;

public class Source {
    char[] cs = null;
    int p;
    int size = 0;
    PlaceHolderDelimeter pd;
    ScriptDelimeter sd;
    HtmlTagConfig htmlTagConfig;
    TextParser parser;
    int curLine = 0;
    boolean isSupportHtmlTag = false;
    int lastCrSize = 0;
    
  
    public Source(char[] cs) {
        this.cs = cs;
        this.p = 0;
        this.size = cs.length;
    }

    public void init(TextParser parser, PlaceHolderDelimeter pd, ScriptDelimeter sd, HtmlTagConfig htmlTagConfig) {
        this.pd = pd;
        this.sd = sd;
        pd.setSource(this);
        sd.setSource(this);
        this.parser = parser;
        this.htmlTagConfig = htmlTagConfig;
        if (htmlTagConfig != null) {
            htmlTagConfig.init(this);
            isSupportHtmlTag = true;
        }
    }
    
    public String findCr() {
    	p =0;
    	while(!isEof()) {
    		int crCount = this.isMatchCR();
    		if(crCount!=0) {
    			return new String(this.consumeAndGetCR(crCount));
    		}
    		this.consume();
    	}
    	return null;
    }

    public boolean isPlaceHolderStart() {
        return pd.matchStart();
    }

    public boolean isPlaceHolderEnd(StringBuilder script) {
        return pd.matchEnd(script);
    }

    public boolean isScriptStart() {
        return sd.matchStart();
    }

    public boolean isScriptEnd(StringBuilder script) {
        return sd.matchEnd(script);
    }

    public boolean isHtmlTagStart() {
        return isSupportHtmlTag && htmlTagConfig.matchTagStart();
    }

    public boolean isHtmlTagEnd() {
        return isSupportHtmlTag && htmlTagConfig.matchTagEnd();
    }

    public boolean matchAndSKip(char[] text) {
        boolean isMatch = this.isMatch(text) && !hasEscape();
        if (isMatch) {
            this.consume(text.length);
        }
        return isMatch;
    }

    public boolean isSupportHtmlTag() {
        return isSupportHtmlTag;
    }





    protected void addLine() {
        this.curLine++;
    }

    public boolean hasEscape() {
        if (p > 1) {
            if (cs[p - 1] == '\\') {
                if (p > 2) {
                    return cs[p - 2] != '\\';
                }
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }


    public boolean isMatch(char[] str) {
        int cur = p;
        for (int i = 0; i < str.length; i++) {
            if (cur < size && cs[cur] == str[i]) {
                cur++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isCrStart(){
        int crLength = isMatchCR();
        if(crLength==0){
            return false;
        }
        this.lastCrSize = crLength;
        return true;

    }

    public int isMatchCR(){
        // window \r\n linux \n mac \r
        char c = cs[p];
        if (c == '\n' ) {
        	
            return 1;
        }
        if(c=='\r'){
            if(size>p+1){
                if(cs[p+1]=='\n'){
                    return 1+1;
                }
            }
            return 1;
        }

        return 0;


    }

    public char consumeAndGet(){
        char c = this.get();
        this.consume();

        return c;
    }

    public char[] consumeAndGetCR(int size){
        char[] cs = new char[size];
        for(int i=0;i<size;i++){
            cs[i] = consumeAndGet();
        }
        this.addLine();
        return cs;
    }

    public void consume() {
        p++;
    }

    public void consume(int x) {
        p = p + x;
    }


    public char get() {
        return cs[p];
    }

    public boolean isEof() {
        return p == size;
    }

    public void move(int p) {
        this.p = p;
    }

    public TextParser getParser() {
        return parser;
    }

    public void setParser(TextParser parser) {
        this.parser = parser;
    }

    @Override
    public String toString() {
        return new String(cs, 0, p);
    }
}
