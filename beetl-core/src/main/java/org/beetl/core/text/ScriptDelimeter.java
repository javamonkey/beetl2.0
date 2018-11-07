package org.beetl.core.text;

public class ScriptDelimeter extends Delimeter {

    public ScriptDelimeter(char[] start, char[] end) {
        super(start, end);
    }

    public ScriptDelimeter(char[] start, char[] end, char[] start1, char[] end1) {
        super(start, end, start1, end1);
    }

    @Override
    public boolean matchEnd() {
        if (isMatchFirstGroup) {
            if (end != null) {
                return source.matchAndSKip(end);
            } else {
                return source.matchCrAndSkip() != null;
            }

        } else if (this.hasTwoGroup) {
            if (end1 != null) {
                return source.matchAndSKip(end1);
            } else {
                return source.matchCrAndSkip() != null;
            }
        }
        return false;
    }

}
