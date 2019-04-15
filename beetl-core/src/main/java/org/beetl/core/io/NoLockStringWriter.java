/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
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
package org.beetl.core.io;

import java.io.IOException;
import java.io.Writer;

public class NoLockStringWriter extends Writer
{

	//todo reuse parent writer buf??
	protected char buf[];
	protected int count;

	public NoLockStringWriter()
	{
		this.buf = new char[64];
	}

	public NoLockStringWriter(char buf[])
	{
		this.buf = buf;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException
	{
		int newcount = count + len;
		if (newcount > buf.length)
		{
			buf = copyOf(buf, Math.max(buf.length << 1, newcount));
		}
		System.arraycopy(cbuf, off, buf, count, len);
		count = newcount;
	}

	public static char[] copyOf(char[] original, int newLength)
	{
		char[] copy = new char[newLength];
		System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
		return copy;
	}

	public void write(String str) throws IOException
	{
		if (str != null)
		{
			int len = str.length();
			if (len < buf.length)
			{
				str.getChars(0, len, buf, 0);
				this.write(buf, 0, len);

			}
			else
			{

				this.write(str.toCharArray());
			}

		}
	}

	@Override
	public void flush() throws IOException
	{

	}

	@Override
	public void close() throws IOException
	{
		// TODO Auto-generated method stub

	}

	public String toString()
	{
		return new String(buf, 0, count);
	}

}
