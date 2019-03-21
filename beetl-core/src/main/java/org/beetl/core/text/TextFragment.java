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
	protected void appendLine(int num) {
		//不可能調用
		throw new IllegalStateException();
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
			}
			else {
				char c = source.consumeAndGet();
				if(!this.isSpace(c)&&!hasText){
					hasText = true;
				}
				text.append(c);
			}
		}
		this.setEndLine();

		return null;
	}


	

	/**
	 * 去掉文本部分用于格式化的部分，是文本最后一行的
	 */
	public void formatEndPart() {
		int len = text.length();
		int pos = len-1;
		for (pos = len - 1; pos > 0; pos--) {
			char c = text.charAt(pos);
			if (!isSpace(c)) {
				text.setLength(pos);
				return ;
			}
		}


	}

	/**
	 * 删除静态文本中格式化部分内容,包含空格直到换行
	 * @return
	 */
	public void formatStartPart() {
		int len = text.length();
		int pos=0;
		char c = 0;
		for (pos = 0; pos < len; pos++) {
			c = text.charAt(pos);
			if (!isSpace(c)) {
				break;
			}
		}
		if(c=='\n'){
			pos++;

		}else if(c=='\r'){
			pos++;
			if(text.length()>pos+1&&text.charAt(pos+1)=='\n'){
				pos++;
			}
		}
		text = new StringBuilder(text.substring(pos));


	}
	
	protected void clearForForamt() {
		this.text.setLength(0);
	}



	protected int getCrLen(char c, int i) {
		if (c == '\n') {
			return 1;
		} else {

			if (text.length() > i + 1 && text.charAt(i + 1) == '\n') {
				return 2;
			}
			return 1;
		}

	}

	protected void doFormat(int i) {
		text.setLength(i);
	}

	protected boolean isSpace(char c) {
		return c == ' ' || c == '\t';
	}

	protected boolean isCr(char c) {
		return c == '\n' || c == '\r';
	}

}
