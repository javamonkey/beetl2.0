package org.beetl.core.text;

public class PlaceHolderFragment implements Fragment {
    Source source;
    StringBuilder script = new StringBuilder("<<");

    public PlaceHolderFragment(Source source) {
        this.source = source;
    }

    @Override
    public StringBuilder getScript() {
        script.append(">>");
        return script;
    }

    @Override
    public Fragment consumeAndReturnNext() {
    	//不同占位符，返回不同的标识，beetl支持俩种占位符，能表达不同语义
    	if(source.pd.isMatchFirstGroup) {
    		script = new StringBuilder("<<");
    	}else {
    		script = new StringBuilder("<#");
    	}
    	
        while (!source.isPlaceHolderEnd()) {
            script.append(source.consumeAndGet());
        }

        if (source.isEof()) {
            return null;
        }

        if (source.isScriptStart()) {
            return new ScriptFragment(source);
        } else if (source.isPlaceHolderStart()) {
            return new PlaceHolderFragment(source);
        } else {
            return new TextFragment(source);
        }
    }

}
