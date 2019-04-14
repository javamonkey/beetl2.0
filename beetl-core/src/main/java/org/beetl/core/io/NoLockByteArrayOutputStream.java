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

import java.io.OutputStream;

public class NoLockByteArrayOutputStream extends OutputStream
{

	protected byte buf[];

	protected int count;

	public NoLockByteArrayOutputStream()
	{
		this(32);
	}

	public NoLockByteArrayOutputStream(int size)
	{

		buf = new byte[size];
	}

	public void write(int b)
	{
		int newcount = count + 1;
		if (newcount > buf.length)
		{
			buf = copyOf(buf, Math.max(buf.length << 1, newcount));
		}
		buf[count] = (byte) b;
		count = newcount;
	}

	public void write(byte b[], int off, int len)
	{

		int newcount = count + len;
		if (newcount > buf.length)
		{
			buf = copyOf(buf, Math.max(buf.length << 1, newcount));
		}
		System.arraycopy(b, off, buf, count, len);
		count = newcount;
	}

	public static byte[] copyOf(byte[] original, int newLength)
	{
		byte[] copy = new byte[newLength];
		System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
		return copy;
	}

	public void reset()
	{
		count = 0;
	}

	public byte toByteArray()[]
	{
		return copyOf(this.buf, count);
	}

	public int size()
	{
		return count;
	}

}
