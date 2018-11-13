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

    public boolean isPlaceHolderStart() {
        return pd.matchStart();
    }

    public boolean isPlaceHolderEnd() {
        return pd.matchEnd();
    }

    public boolean isScriptStart() {
        return sd.matchStart();
    }

    public boolean isScriptEnd() {
        return sd.matchEnd();
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

    public boolean matchCrAndSkip() {

        char[] chs = doMatchCrAndSkip();
        return chs != null;
    }

    protected char[] doMatchCrAndSkip() {
        // window \r\n linux \n mac \r
        if (isEof()) {
            return null;
        }
        if (cs[p] == '\n') {
            this.consume();
            this.addLine();
            return this.parser.cr1;
        } else if (cs[p] == '\r') {
            this.consume();
            this.addLine();
            if (p < size && cs[p] == '\n') {
                this.consume();
                return this.parser.cr2;
            }
            return this.parser.cr3;

        }
        return null;
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

    public void consume() {
        p++;
    }

    public void consume(int x) {
        p = p + x;
    }

    /**
     * 通用读取方法 读取一个或者一个回车换行符号
     * 
     * @return
     */
    public char[] consumeAndGet() {
        char c = cs[p];
        if (c == '\n' || c == '\r') {
            char[] cs = doMatchCrAndSkip();
            return cs;
        } else {
            p++;
            // 性能优化，重用这个数组
            return new char[] {c};
        }

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
