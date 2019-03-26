package org.beetl.core.text;

public class CRFragment extends Fragment {
    char[] cr;

    public CRFragment(Source source) {
        super(source);
        int size = source.lastCrSize;
        cr = source.consumeAndGetCR(size);
    }

    @Override
    public StringBuilder getScript() {
        //优化
        return new StringBuilder(cr.length).append(cr);
    }


    @Override
    public Fragment consumeAndReturnNext() {
        //回车算上一行内容
        this.endLine = this.source.curLine - 1;
        while (!source.isEof()) {
            if (source.isPlaceHolderStart()) {
                return new PlaceHolderFragment(source);
            } else if (source.isScriptStart()) {
                ScriptBlockFragment scriptFragement = new ScriptBlockFragment(source);
                return scriptFragement;
            } else if (source.isHtmlTagStart()) {
                HtmlTagStartFragment htmlTagStart = new HtmlTagStartFragment(source);
                return htmlTagStart;
            } else if (source.isHtmlTagEnd()) {
                HtmlTagEndFragment htmlTagEndFragment = new HtmlTagEndFragment(source);
                return htmlTagEndFragment;
            } else if (source.isCrStart()) {
                CRFragment crFragment = new CRFragment(source);
                return crFragment;
            } else {
                return new TextFragment(source);
            }
        }
        return null;
    }
    
 
}
