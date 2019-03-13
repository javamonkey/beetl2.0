package org.beetl.core.text;

public class TextFragment extends Fragment {
	StringBuilder text = new StringBuilder();
	boolean insertCr = false;

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
				text.append(source.consumeAndGet());
			}
		}
		this.setEndLine();

		return null;
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
		for (int i = len - 1; i > 0; i--) {
			char c = text.charAt(i);
			
			if (!isSpace(c)) {
				return;
			}
		}
		text.setLength(0);

	}

	public void foramtSpace() {
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char c = text.charAt(i);
			if (!isSpace(c)) {
				return;
			}
		}
		text.setLength(0);
	}

	public void formatStartPart() {
		int len = text.length();
		for (int i = 0; i < len; i++) {
			char c = text.charAt(i);
			if (isCr(c)) {

				text = text.delete(0, i + getCrLen(c, i));
				// text = text.delete(0, i );
				// 脚本记录需要插入一个cr以保证格式正确
				insertCr = true;
				return;
			}
			if (!isSpace(c)) {
				return;
			}
		}
		text.setLength(0);
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
