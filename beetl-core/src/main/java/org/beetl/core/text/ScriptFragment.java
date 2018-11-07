package org.beetl.core.text;

public class ScriptFragment implements Fragment {

    Source source = null;
    StringBuilder script = new StringBuilder();

    public ScriptFragment(Source source) {
        this.source = source;
    }

    @Override
    public StringBuilder getScript() {
        return script;
    }

    @Override
    public Fragment consumeAndReturnNext() {
        while (!source.isScriptEnd()) {
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
