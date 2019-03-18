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

        if (source.sd.endIsCr) {
            //回车放到脚本里，添加一个换行符
            script.append(TextParser.cr1);
        }

        if (source.isEof()) {
            this.setEndLine();
            return null;
        }
        return this.findNext();

    }

}
