package org.beetl.core.text;

import java.util.HashSet;
import java.util.Set;

public class TextFragment extends Fragment {
	StringBuilder text = new StringBuilder();
	boolean hasText = false;

	public TextFragment(Source source) {
		super(source);

	}

	@Override
	public StringBuilder getScript() {
		StringBuilder script = new StringBuilder();
		if(text.length()==0){
			return script;
		}
		Integer varName = source.getParser().getRandomeTextVarName();
		script.append("<$" + varName + ">>");

		// 添加一个静态变量
		source.parser.getTextVars().put(varName, text.toString());
		return script;
	}



	@Override
	public Fragment consumeAndReturnNext() {
		int matchCr = 0;
		while (!source.isEof()) {

			if (source.isPlaceHolderStart()) {
				this.setEndLine();
				return new PlaceHolderFragment(source);
			} else if (source.isScriptStart()) {
				this.setEndLine();
				ScriptFragment scriptFragement =  new ScriptFragment(source);
				return scriptFragement;
			} else if (source.isHtmlTagStart()) {
				this.setEndLine();
				HtmlTagStartFragment htmlTagStart = new HtmlTagStartFragment(source);
				return htmlTagStart;

			} else if (source.isHtmlTagEnd()) {
				this.setEndLine();
				HtmlTagEndFragment htmlTagEndFragment = new HtmlTagEndFragment(source);
				return htmlTagEndFragment;
			} else if(source.isCrStart()){
				CRFragment crFragment = new CRFragment(source);
				return crFragment;
			}
			else {
				char c = source.consumeAndGet();
				text.append(c);
			}
		}
		this.setEndLine();

		return null;
	}







	public boolean hashSpace() {
		for(int i=0;i<text.length();i++){
			char c = text.charAt(i);
			if(c != ' ' && c != '\t'){
				return false;
			}
		}
		return  true;
	}


}
