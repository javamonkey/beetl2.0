package org.beetl.core.statement;

public class GrammarToken implements Cloneable, java.io.Serializable
{
	public int line;
	public String text;
	public int col;

	public GrammarToken(String text, int line, int col)
	{
		this.text = text;
		this.line = line;
		this.col = col;
	}

	public static GrammarToken createToken(String tagName, int line)
	{
		return new GrammarToken(tagName, line, 1);
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

	public String toString()
	{
		return text;
	}
}
