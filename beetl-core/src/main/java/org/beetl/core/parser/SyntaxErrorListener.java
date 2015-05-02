package org.beetl.core.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.BeetlUtil;
import org.beetl.core.statement.GrammarToken;

public class SyntaxErrorListener extends BaseErrorListener
{
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e)
	{

		BeetlException be = new BeetlException(BeetlException.TOKEN_ERROR);
		be.token = new GrammarToken(BeetlUtil.reportChineseTokenError(msg), line, charPositionInLine);
		throw be;

	}
}
