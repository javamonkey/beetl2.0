package org.beetl.core.text;

public abstract class Fragment {
    protected Source source;
    protected int startLine;
    protected int endLine;

    public Fragment(Source source) {
        this.source = source;
        this.setStartLine();
    }

    public abstract StringBuilder getScript();

    public abstract Fragment consumeAndReturnNext();

    protected Fragment findNext() {
        if (source.isScriptStart()) {
            this.setEndLine();
            return new ScriptFragment(source);
        } else if (source.isPlaceHolderStart()) {
            this.setEndLine();
            return new PlaceHolderFragment(source);
        } else {
            this.setEndLine();
            return new TextFragment(source);
        }
    }

    protected void setStartLine() {
        this.startLine = source.curLine;
    }

    protected void setEndLine() {
        this.endLine = source.curLine;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " from " + this.startLine + " to " + this.endLine;
    }
}
