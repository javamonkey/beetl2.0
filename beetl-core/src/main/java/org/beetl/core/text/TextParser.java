package org.beetl.core.text;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class TextParser {

    Map<String, String> textVars = new HashMap<String, String>();
    int textNameSuffix = 0;
    PlaceHolderDelimeter pd;
    ScriptDelimeter sd;
    Source source = null;
    StringBuilder script = new StringBuilder(64);
    static char[] cr1 = "\n".toCharArray();
    static char[] cr2 = "\r\n".toCharArray();
    static char[] cr3 = "\r".toCharArray();

    public TextParser(PlaceHolderDelimeter pd, ScriptDelimeter sd) {
        this.pd = pd;
        this.sd = sd;
    }

    public void doParse(Reader orginal) throws IOException {
        StringBuilder temp = new StringBuilder();
        int bufSzie = 1024;
        char[] cs = new char[bufSzie];
        int len = -1;

        while ((len = orginal.read(cs)) != -1) {
            temp.append(cs, 0, len);

        }

        cs = temp.toString().toCharArray();
        source = new Source(cs);
        source.init(this, pd, sd);
        Fragment test = new TextFragment(source);
        Fragment next = test.consumeAndReturnNext();
        StringBuilder sb = test.getScript();
        if (sb.length() != 0) {
            script.append(test.getScript());
        }

        while (next != null) {
            test = next.consumeAndReturnNext();
            script.append(next.getScript());
            next = test;
        }

    }

    public StringBuilder getScript() {
        return script;
    }

    public Map<String, String> getTextVars() {
        return textVars;
    }

    public String getTextVarName() {
        return "txt" + (textNameSuffix++);
    }

    public static void main(String[] args) throws IOException {
        PlaceHolderDelimeter pd = new PlaceHolderDelimeter("${".toCharArray(), "}".toCharArray());
        ScriptDelimeter sd = new ScriptDelimeter("<%".toCharArray(), "%>".toCharArray());
        String text = "abcd${abc}<%var a =1;%>";
        StringReader str = new StringReader(text);
        TextParser textParser = new TextParser(pd, sd);
        textParser.doParse(str);
        System.out.println(textParser.getTextVars());
        System.out.println(textParser.getScript());

    }

}
