package org.beetl.core.text;

/**
 * 支持俩个占位符号
 * 
 * @author Administrator
 *
 */
public class Delimeter {
    Source source;
    protected char[] start, end;
    protected char[] start1, end1;
    protected boolean isMatchFirstGroup = true;
    protected boolean hasTwoGroup = false;

    public Delimeter(char[] start, char[] end) {
        this.start = start;
        this.end = end;
    }

    public Delimeter(char[] start, char[] end, char[] start1, char[] end1) {
        this(start, end);
        this.start1 = start1;
        this.end1 = end1;
        this.hasTwoGroup = true;
    }

    public boolean matchStart() {
        boolean match = false;
        match = source.matchAndSKip(start);
        if (!match && hasTwoGroup) {
            match = source.matchAndSKip(start1);
            if (match) {
                isMatchFirstGroup = false;
            }
        }
        return match;
    }

    public boolean matchEnd(StringBuilder script) {
        if (isMatchFirstGroup) {
            return source.matchAndSKip(end);
        } else if (hasTwoGroup) {
            return source.matchAndSKip(end1);
        }
        return false;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

}
