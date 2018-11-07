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
