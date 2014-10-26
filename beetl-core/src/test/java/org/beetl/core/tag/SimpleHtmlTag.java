package org.beetl.core.tag;

import java.io.IOException;
import java.util.Map;

import org.beetl.core.Tag;

public class SimpleHtmlTag extends Tag
{

	@Override
	public void render()
	{
		String tagName = (String) this.args[0];
		Map map = (Map) args[1];
		String value = (String) map.get("attr");
		try
		{
			this.ctx.byteWriter.writeString(value);
		}
		catch (IOException e)
		{

		}

	}

}
