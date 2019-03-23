package org.beetl.core.text;

public class ScriptFragment extends Fragment {


    Source source = null;
    StringBuilder script = new StringBuilder();

    public ScriptFragment(Source source) {
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



}
