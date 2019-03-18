package org.beetl.core.text;

public class ScriptDelimeter extends Delimeter {

    boolean endIsCr = false;

    public ScriptDelimeter(char[] start, char[] end) {
        super(start, end);
    }

    public ScriptDelimeter(char[] start, char[] end, char[] start1, char[] end1) {
        super(start, end, start1, end1);
    }

    @Override
    public boolean matchStart() {
        boolean match = super.matchStart();
        if (match) {
            // 初始化
            endIsCr = false;
        }
        return match;
    }

    @Override
    public boolean matchEnd() {
        boolean match = false;
        if (isMatchFirstGroup) {
            match = matchEnd(this.end);

        } else if (this.hasTwoGroup) {
            match = matchEnd(this.end1);
        }
        return match;
    }

    private boolean matchEnd(char[] end){
        if (end != null) {
            return source.matchAndSKip(end);
        } else {
            int matchCount = source.isMatchCR();
            if (matchCount!=0) {
                endIsCr = true;
                source.consumeAndGetCR(matchCount);
                return true;
            }
        }

        return false;
    }

}
