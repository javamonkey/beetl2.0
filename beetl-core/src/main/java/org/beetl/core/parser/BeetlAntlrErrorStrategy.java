package org.beetl.core.parser;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.misc.NotNull;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.BeetlParserException;
import org.beetl.core.statement.GrammarToken;

public class BeetlAntlrErrorStrategy extends DefaultErrorStrategy
{
	@Override
	public void recover(Parser recognizer, RecognitionException e)
	{

		//不会执行到此处，因为在report部分就抛出异常了
		super.recover(recognizer, e);
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e)
	{
		// if we've already reported an error and have not matched a token
		// yet successfully, don't report any errors.
		if (inErrorRecoveryMode(recognizer))
		{
			//			System.err.print("[SPURIOUS] ");
			return; // don't report spurious errors
		}
		beginErrorCondition(recognizer);
		if (e instanceof NoViableAltException)
		{
			reportNoViableAlternative(recognizer, (NoViableAltException) e);
		}
		else if (e instanceof InputMismatchException)
		{
			reportInputMismatch(recognizer, (InputMismatchException) e);
		}
		else if (e instanceof FailedPredicateException)
		{
			reportFailedPredicate(recognizer, (FailedPredicateException) e);
		}
		else
		{
			//			System.err.println("unknown recognition error type: " + e.getClass().getName());
			BeetlException exception = new BeetlException(BeetlException.PARSER_UNKNOW_ERROR, e.getClass().getName(), e);
			exception.token = this.getGrammarToken(e.getOffendingToken());
			throw exception;
		}
	}

	protected void reportNoViableAlternative(@NotNull Parser recognizer, @NotNull NoViableAltException e)
	{
		TokenStream tokens = recognizer.getInputStream();
		String input;
		if (tokens instanceof TokenStream)
		{
			if (e.getStartToken().getType() == Token.EOF)
				input = "<文件尾>";
			else
				input = tokens.getText(e.getStartToken(), e.getOffendingToken());
		}
		else
		{
			input = "<未知输入>";
		}
		//		String msg = "no viable alternative at input " + escapeWSAndQuote(input);
		BeetlException exception = new BeetlParserException(BeetlException.PARSER_VIABLE_ERROR,
				escapeWSAndQuote(input), e);
		exception.token = this.getGrammarToken(e.getOffendingToken());
		throw exception;
	}

	protected void reportInputMismatch(@NotNull Parser recognizer, @NotNull InputMismatchException e)
	{
		String msg = "缺少输入 " + getTokenErrorDisplay(e.getOffendingToken()) + " 期望 "
				+ e.getExpectedTokens().toString(recognizer.getTokenNames());
		BeetlException exception = new BeetlParserException(BeetlException.PARSER_MISS_ERROR, msg, e);
		exception.token = this.getGrammarToken(e.getOffendingToken());
		throw exception;

	}

	protected void reportFailedPredicate(@NotNull Parser recognizer, @NotNull FailedPredicateException e)
	{
		String ruleName = recognizer.getRuleNames()[recognizer.getContext().getRuleIndex()];
		BeetlException exception = new BeetlParserException(BeetlException.PARSER_PREDICATE_ERROR, ruleName, e);
		exception.token = this.getGrammarToken(e.getOffendingToken());
		throw exception;
	}

	/** Make sure we don't attempt to recover from problems in subrules. */
	@Override
	public void sync(Parser recognizer)
	{
	}

	/** Make sure we don't attempt to recover inline; if the parser
	* successfully recovers, it won't throw an exception.
	*/
	@Override
	public Token recoverInline(Parser recognizer) throws RecognitionException
	{
		// SINGLE TOKEN DELETION
		Token matchedSymbol = singleTokenDeletion(recognizer);
		if (matchedSymbol != null)
		{
			// we have deleted the extra token.
			// now, move past ttype token as if all were ok
			recognizer.consume();
			return matchedSymbol;
		}

		// SINGLE TOKEN INSERTION
		if (singleTokenInsertion(recognizer))
		{
			return getMissingSymbol(recognizer);
		}

		// even that didn't work; must throw the exception

		BeetlException exception = new BeetlParserException(BeetlException.PARSER_MISS_ERROR);
		exception.token = this.getGrammarToken(recognizer.getCurrentToken());
		throw exception;
		//		
		//		throw new InputMismatchException(recognizer);
	}

	protected void reportMissingToken(@NotNull Parser recognizer)
	{
		if (inErrorRecoveryMode(recognizer))
		{
			return;
		}

		beginErrorCondition(recognizer);

		Token t = recognizer.getCurrentToken();
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = "缺少输入 " + expecting.toString(recognizer.getTokenNames()) + " 在 " + getTokenErrorDisplay(t);

		BeetlException exception = new BeetlParserException(BeetlException.PARSER_MISS_ERROR, msg);
		exception.token = this.getGrammarToken(t);
		throw exception;
	}

	protected void reportUnwantedToken(@NotNull Parser recognizer)
	{
		if (inErrorRecoveryMode(recognizer))
		{
			return;
		}

		beginErrorCondition(recognizer);

		Token t = recognizer.getCurrentToken();
		String tokenName = getTokenErrorDisplay(t);
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = "多余输入 " + tokenName + " 期望 " + expecting.toString(recognizer.getTokenNames());
		BeetlException exception = new BeetlParserException(BeetlException.PARSER_MISS_ERROR, msg);
		exception.token = this.getGrammarToken(t);
		throw exception;
	}

	protected GrammarToken getGrammarToken(Token token)
	{
		return GrammarToken.createToken(token.getText(), token.getLine());
	}

}
