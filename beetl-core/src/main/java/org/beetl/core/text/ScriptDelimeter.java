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
        if(match) {
        	//初始化
        	endIsCr = false;
        }
        return match;
    }

    @Override
    public boolean matchEnd() {
    	boolean match = false;
        if (isMatchFirstGroup) {
            if (end != null) {
            	match =  source.matchAndSKip(end);
            } else {
            	match =   source.matchCrAndSkip() != null;
            	if(match) {
                	endIsCr = true;
                }
            }

        } else if (this.hasTwoGroup) {
            if (end1 != null) {
                match =  source.matchAndSKip(end1);
            } else {
                match = source.matchCrAndSkip() != null;
                if(match) {
                	endIsCr = true;
                }
            }
        }
        return match;
    }

}
