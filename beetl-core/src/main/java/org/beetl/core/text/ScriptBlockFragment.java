package org.beetl.core.text;

public class ScriptBlockFragment extends ScriptFragment {



    public ScriptBlockFragment(Source source) {
        super(source);
        this.source = source;
    }

    @Override
    public StringBuilder getScript() {
        return script;
    }

    @Override
    public Fragment consumeAndReturnNext() {
        while (!source.isEof()&&!source.isScriptEnd()) {
        	script.append(source.consumeAndGet());
        }
        if (source.isEof()) {
            this.setEndLine();
            return null;
        }
        return this.findNext();

    }
    
	public void appendCr() {
		script.append(TextParser.cr1);
		
	}



}
