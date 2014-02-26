package org.beetl.core.io;

import java.io.IOException;

import org.beetl.core.BodyContent;
import org.beetl.core.ByteWriter;

public class StringBodyContent implements BodyContent
{
	char[] buf;
	int count;
	String str = null;

	public StringBodyContent(char[] buf, int count)
	{
		this.buf = buf;
		this.count = count;
	}

	public String toString()
	{
		if (str == null)
		{
			str = new String(buf, 0, count);
		}
		return str;
	}

	@Override
	public String getBody()
	{
		return this.toString();

	}

	@Override
	public void fill(ByteWriter bw) throws IOException
	{
		bw.write(this.buf, count);

	}
}
