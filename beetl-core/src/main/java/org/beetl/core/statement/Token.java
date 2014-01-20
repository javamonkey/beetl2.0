package org.beetl.core.statement;

public class Token implements Cloneable, java.io.Serializable
{
	public int line;
	public String text;
	public int col;

	public Token(String text, int line, int col)
	{
		this.text = text;
		this.line = line;
		this.col = col;
	}

	public static Token createErrorToken(String tagName, int line)
	{
		return new Token(tagName, line, 1);
	}

	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new RuntimeException(e);
		}

	}
}
