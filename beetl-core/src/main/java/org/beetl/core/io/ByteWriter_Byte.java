package org.beetl.core.io;

/*
 [The "BSD license"]
 Copyright (c) 2011-2013 Joel Li (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
 notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
 notice, this list of conditions and the following disclaimer in the
 documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
 derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.beetl.core.BodyContent;
import org.beetl.core.ByteWriter;

import sun.nio.cs.StreamEncoder;

public class ByteWriter_Byte extends ByteWriter
{

	protected OutputStream os;
	protected String cs;
	protected Charset charset = null;
	StreamEncoder se = null;

	public ByteWriter_Byte(OutputStream os, String cs)
	{
		this.os = os;
		this.cs = cs;
		charset = Charset.forName(cs);
		try
		{
			se = StreamEncoder.forOutputStreamWriter(os, this, cs);
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void write(char[] cbuf) throws IOException
	{
		//		byte[] bs = new String(cbuf).getBytes(cs);
		//		write(bs);
		//		
		//todo:性能如何？

		//		byte[] bs = charset.encode(CharBuffer.wrap(cbuf)).array();
		//		//		byte[] bs = new String(cbuf).getBytes(cs);
		//		write(bs);
		se.write(cbuf, 0, cbuf.length);

	}

	@Override
	public void write(char[] cbuf, int len) throws IOException
	{
		se.write(cbuf, 0, cbuf.length);

	}

	public void write(String str) throws IOException
	{

		se.write(str);
		//		if (str != null)
		//		{
		//			byte[] bs = charset.encode(str).array();
		//			write(bs);
		//		}

	}

	@Override
	public void write(byte[] bs) throws IOException
	{

		os.write(bs);

	}

	public void write(byte[] bs, int count) throws IOException
	{
		os.write(bs, 0, count);

	}

	@Override
	public ByteWriter getTempWriter()
	{
		return new ByteWriter_Byte(new NoLockByteArrayOutputStream(), cs);
	}

	@Override
	public void flush() throws IOException
	{
		//		this.os.flush();
		se.flush();

	}

	@Override
	public void fill(ByteWriter bw) throws IOException
	{
		ByteWriter_Byte bwb = (ByteWriter_Byte) bw;
		NoLockByteArrayOutputStream byteArray = (NoLockByteArrayOutputStream) bwb.os;
		this.write(byteArray.buf, byteArray.count);

	}

	@Override
	public BodyContent getTempConent()
	{
		NoLockByteArrayOutputStream byteArray = (NoLockByteArrayOutputStream) this.os;
		return new ByteBodyContent(byteArray.buf, byteArray.count, this.cs);
	}

	public OutputStream getOs()
	{
		return os;
	}

	public void setOs(OutputStream os)
	{
		this.os = os;
	}

	public String getCs()
	{
		return cs;
	}

	public void setCs(String cs)
	{
		this.cs = cs;
	}

}
