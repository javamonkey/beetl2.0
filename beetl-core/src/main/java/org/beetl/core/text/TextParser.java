package org.beetl.core.text;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class TextParser {

    Map<String, String> textVars = new HashMap<String, String>();
    int textNameSuffix = 0;
    PlaceHolderDelimeter pd;
    ScriptDelimeter sd;
    Source source = null;
    StringBuilder script = new StringBuilder(64);
    // 操作系统可能出现的回车换行符号
    static char[] cr1 = "\n".toCharArray();
    static char[] cr2 = "\r\n".toCharArray();
    static char[] cr3 = "\r".toCharArray();
    static char[] systemCr = System.getProperty("line.separator").toCharArray();
    static String systemCrStr = System.getProperty("line.separator");
    List<Fragment> list = new LinkedList<Fragment>();

    public TextParser(PlaceHolderDelimeter pd, ScriptDelimeter sd) {
        this.pd = pd;
        this.sd = sd;
    }

    public void doParse(Reader orginal) throws IOException {

        scan1(orginal);
        scan2();

    }

    protected void scan1(Reader orginal) throws IOException {
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
        list.add(test);
        Fragment next = test.consumeAndReturnNext();
        while (next != null) {
            test = next.consumeAndReturnNext();
            list.add(next);
            next = test;
        }

    }

    /**
     * 格式化，把有些TextFragment用于格式化的静态内容删除,原则是在同一行的text和script，如果text只有空或者tab，则认为是控制符
     * 
     */
    protected void scan2() {
    	FragmentFormmater ff = new FragmentFormmater(list);
    	ff.format();
        
    }
    
    


    public StringBuilder getScript() {
        return script;
    }

    public Map<String, String> getTextVars() {
        return textVars;
    }

    public String getRandomeTextVarName() {
        return "" + (++textNameSuffix);
    }

    public static void main(String[] args) throws IOException {
        PlaceHolderDelimeter pd =
            new PlaceHolderDelimeter("${".toCharArray(), "}".toCharArray(), "#{".toCharArray(), "}".toCharArray());
        ScriptDelimeter sd = new ScriptDelimeter("<%".toCharArray(), "%>".toCharArray());
        String text = "   <%var a =1;%>\nabc";
        StringReader str = new StringReader(text);
        TextParser textParser = new TextParser(pd, sd);
        textParser.doParse(str);
        List<Fragment> firsScanResult = textParser.list;
        System.out.println(firsScanResult);

        // System.out.println(textParser.getTextVars());
        // String line = null;
        // BufferedReader reader = new BufferedReader(new StringReader(textParser.getScript().toString()));
        // System.out.println("==============================");
        // while ((line = reader.readLine()) != null) {
        // System.out.println(line);
        // }

    }

}
