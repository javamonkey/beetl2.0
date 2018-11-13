package org.beetl.core.text;

public class TextFragment extends Fragment {
	StringBuilder text = new StringBuilder();
	boolean insertCr = false;

	public TextFragment(Source source) {
		super(source);

	}

	@Override
	public StringBuilder getScript() {
		char[] cr = source.parser.systemCr;
		StringBuilder script = new StringBuilder();
		if (insertCr) {
			script.append(cr);

		}
		if (text.length() == 0) {
			return script;
		}
		Integer varName = source.getParser().getRandomeTextVarName();
		script.append("<$" + varName + ">>");
		for (int i = this.startLine + (insertCr ? 1 : 0); i < this.endLine; i++) {
			script.append(source.parser.systemCr);
		}
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
			} else if (source.isHtmlTagStart()) {
				this.setEndLine();
				return new HtmlTagStartFragment(source);

			} else if (source.isHtmlTagEnd()) {
				this.setEndLine();
				return new HtmlTagEndFragment(source);
			} else {
				char[] cs = source.consumeAndGet();
				text.append(cs);
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
		for (int i = len - 1; i > 0; i--) {
			char c = text.charAt(i);
			if (isCr(c)) {
				// 去掉格式化部分
				text.setLength(i + getCrLen(c, i) - 1);
				// text.setLength(i);


				return;
			}
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
