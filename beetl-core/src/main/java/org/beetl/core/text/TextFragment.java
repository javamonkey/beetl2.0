package org.beetl.core.text;

import java.util.HashSet;
import java.util.Set;

public class TextFragment extends Fragment {
	StringBuilder text = new StringBuilder();

	//TODO 改成数组
	Set<Integer> spacesCheck = new HashSet<Integer>();

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
				//在脚本内容里添加换行符
				int crNum = (this.endLine-this.startLine)+(this.endWithCr()?1:0);
				scriptFragement.appendLine(crNum);

				return scriptFragement;
			} else if (source.isHtmlTagStart()) {
				this.setEndLine();
				HtmlTagStartFragment htmlTagStart = new HtmlTagStartFragment(source);
				int crNum = (this.endLine-this.startLine)+(this.endWithCr()?1:0);
				htmlTagStart.appendLine(crNum);
				return htmlTagStart;

			} else if (source.isHtmlTagEnd()) {
				this.setEndLine();
				HtmlTagEndFragment htmlTagEndFragment = new HtmlTagEndFragment(source);
				int crNum = (this.endLine-this.startLine)+(this.endWithCr()?1:0);
				htmlTagEndFragment.appendLine(crNum);
				return htmlTagEndFragment;
			} else if((matchCr=source.isMatchCR())!=0){
				text.append(source.consumeAndGetCR(matchCr));
			}
			else {
				char c = source.consumeAndGet();
				//效率低，想个办法，总不能每读一个字符，就判断一下吧 TODO3
				if(!isSpace(c)&&!spacesCheck.contains(source.curLine)){
					spacesCheck.add(source.curLine);
				}
				text.append(c);
			}
		}
		this.setEndLine();

		return null;
	}

	public boolean onlySpaceInLine(int line){
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
		if(text.length()==0){
			return false;
		}
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
