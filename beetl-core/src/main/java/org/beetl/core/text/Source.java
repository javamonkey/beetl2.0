package org.beetl.core.text;

public class Source {
    char[] cs = null;
    int p;
    int size = 0;
    PlaceHolderDelimeter pd;
    ScriptDelimeter sd;
    TextParser parser;

    public Source(char[] cs) {
        this.cs = cs;
        this.p = 0;
        this.size = cs.length;

    }

    public void init(TextParser parser, PlaceHolderDelimeter pd, ScriptDelimeter sd) {
        this.pd = pd;
        this.sd = sd;
        pd.setSource(this);
        sd.setSource(this);
        this.parser = parser;
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

    public boolean matchAndSKip(char[] text) {
        boolean isMatch = this.isMatch(text) && !hasEscape();
        if (isMatch) {
            this.consume(text.length);
        }
        return isMatch;
    }

    public char[] matchCrAndSkip() {
        // window \r\n linux \n mac \r
        if (cs[p] == '\n') {
            this.consume();
            return this.parser.cr1;
        } else if (cs[p] == '\r') {
            this.consume();
            if (p + 1 < size && cs[p + 1] == '\n') {
                this.consume();
                return this.parser.cr2;
            }
            return this.parser.cr3;

        }
        return null;
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

    public char consumeAndGet() {
        char c = cs[p];
        p++;
        return c;
    }

    public char get() {
        return cs[p];
    }

    public boolean isEof() {
        return p == size;
    }

    public TextParser getParser() {
        return parser;
    }

    public void setParser(TextParser parser) {
        this.parser = parser;
    }

}
