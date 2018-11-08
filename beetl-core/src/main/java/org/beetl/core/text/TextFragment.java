package org.beetl.core.text;

public class TextFragment extends Fragment {
    StringBuilder text = new StringBuilder();
    // 记录换行个数，以便在script脚本中保留换行
    int crCount;
    String varName;

    public TextFragment(Source source) {
        super(source);
        this.varName = source.getParser().getRandomeTextVarName();;
    }

    @Override
    public StringBuilder getScript() {

        if (text.length() == 0) {
            return text;
        }
        StringBuilder script = new StringBuilder();
        int i = 0;
        while (i < crCount) {
            script.append(TextParser.systemCr);
            i++;
        }
        script.append("<$" + varName + ">>");
        // 添加一个静态变量
        source.parser.getTextVars().put(varName, text.toString());
        return script;
    }

    @Override
    public Fragment consumeAndReturnNext() {

        while (!source.isEof()) {
            if (source.isPlaceHolderStart()) {
                this.setEndLine();
                return new PlaceHolderFragment(source);
            } else if (source.isScriptStart()) {
                this.setEndLine();
                return new ScriptFragment(source);
            } else {
                char[] cs = source.consumeAndGet();
                text.append(cs);
            }
        }
        this.setEndLine();
        return null;
    }

}
