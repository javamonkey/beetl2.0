package org.beetl.ext.tag;

import java.io.IOException;

import org.beetl.core.tag.Tag;

public class TrimHtml extends Tag
{

	@Override
	public void render()
	{
		String content = this.getBodyContent().toString();
		try
		{
			this.bw.writeString(trimLine(content));
		}
		catch (IOException e)
		{
			//do nothing
		}

	}

	private String trimLine(String html)
	{
		StringBuilder sb = new StringBuilder(html.length());
		for (String s : html.split("\n"))
			sb.append(s.trim());

		return sb.toString();
	}
}
