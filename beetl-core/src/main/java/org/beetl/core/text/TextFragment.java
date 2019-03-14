package org.beetl.core.text;

import java.util.*;

public class TextFragment extends Fragment {
	StringBuilder text = new StringBuilder();
	boolean insertCr = false;
	//TODO 改成数组
	Set<Integer> spacesCheck = new HashSet<Integer>();

	public TextFragment(Source source) {
		super(source);

	}

	@Override
	public StringBuilder getScript() {
		
		StringBuilder script = new StringBuilder();
		if (insertCr) {
			script.append(source.parser.cr1);

		}
		if (text.length() == 0) {
			return script;
		}
		Integer varName = source.getParser().getRandomeTextVarName();
		script.append("<$" + varName + ">>");
		for (int i = this.startLine + (insertCr ? 1 : 0); i < this.endLine; i++) {
			script.append(source.parser.cr1);
		}
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
				//在脚本内容里添加换行符
				int crNum = (this.endLine-this.startLine)+(this.endWithCr()?1:0);
				for(int i=0;i<crNum;i++) {
					scriptFragement.script.append("\n");
				}
				return scriptFragement;
			} else if (source.isHtmlTagStart()) {
				this.setEndLine();
				return new HtmlTagStartFragment(source);

			} else if (source.isHtmlTagEnd()) {
				this.setEndLine();
				return new HtmlTagEndFragment(source);
			} else if((matchCr=source.isMatchCR())!=0){
				text.append(source.consumeAndGetCR(matchCr));
			}
			else {
				char c = source.consumeAndGet();
				if(!isSpace(c)&&!spacesCheck.contains(source.curLine)){
					spacesCheck.add(source.curLine);
				}
				text.append(source.consumeAndGet());
			}
		}
		this.setEndLine();

		return null;
	}

	public boolean containSpaceInLine(int line){
		return !this.spacesCheck.contains(line);
	}
	protected void setEndLine() {
		
		if(text.length()<0){
			return ;
		}
		if(endWithCr()) {
			this.endLine = source.curLine-1;;
		}else {
			this.endLine = source.curLine;
		}
		

	}
	
	protected boolean endWithCr() {
		
		char lastChar = text.charAt(text.length()-1);
		if(lastChar=='\n'||lastChar=='\r'){
			return true;
		}else {
			return false;
		}
		
		
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


	public void formatStartPart() {
		int len = text.length();
		int pos=0;
		for (pos = 0; pos < len; pos++) {
			char c = text.charAt(pos);

			if (!isSpace(c)) {
				text = new StringBuilder(text.substring(pos));
				return;
			}
		}

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
