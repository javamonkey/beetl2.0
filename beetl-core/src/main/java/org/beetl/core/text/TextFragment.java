package org.beetl.core.text;

public class TextFragment implements Fragment {
    Source source;
    StringBuilder text = new StringBuilder();
    // 记录换行个数，以便在script脚本中保留换行
    int crCount;
    String varName;

    public TextFragment(Source source) {
        this.source = source;
        this.varName = source.getParser().getTextVarName();;
    }

    @Override
    public StringBuilder getScript() {
        if (text.length() == 0) {
            return text;
        }
        StringBuilder script = new StringBuilder();
        int i = 0;
        while (i < crCount) {
            script.append("\n");
            i++;
        }
        script.append("<$" + varName + ">>");
        // 添加一个静态变量
        source.parser.getTextVars().put(varName, text.toString());
        return script;
    }

    @Override
    public Fragment consumeAndReturnNext() {
        char[] cr = null;
        while (!source.isEof()) {
            if (source.isPlaceHolderStart()) {
                return new PlaceHolderFragment(source);
            } else if (source.isScriptStart()) {
                return new ScriptFragment(source);
            } else {
                // 静态文本处理
                if ((cr = source.matchCrAndSkip()) != null) {
                    text.append(cr);
                    crCount++;
                } else {
                    char cs = source.consumeAndGet();
                    text.append(cs);
                }

            }

        }
        return null;

    }

}
