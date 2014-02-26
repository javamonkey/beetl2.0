package org.beetl.core.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.beetl.core.BodyContent;
import org.beetl.core.ByteWriter;

public class ByteBodyContent implements BodyContent
{
	byte[] bs;
	int count;
	String charset = null;

	public ByteBodyContent(byte[] bs, int count, String charset)
	{
		this.bs = bs;
		this.charset = charset;
		this.count = count;

	}

	public String getBody()
	{
		return this.toString();
	}

	public String toString()
	{
		try
		{
			return new String(bs, 0, count, charset);
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void fill(ByteWriter bw) throws IOException
	{
		bw.write(bs, count);

	}
}
