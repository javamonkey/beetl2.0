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

import org.beetl.core.SuperVar;

public abstract class ByteWriter
{

	public abstract void write(char[] cbuf) throws IOException;

	public void write(String str) throws IOException
	{

		if (str != null)
			this.write(str.toCharArray());
	}

	public abstract void write(byte[] bs) throws IOException;

	public abstract void write(SuperVar sv) throws IOException;

	public abstract ByteWriter getTempWriter();

	/* 将来也许能优化，避免数组的copy */
	public abstract Object getTempContent();

	public abstract void flush() throws IOException;

	public abstract ByteWriter getParent();

	/**
	 * 将临时流flush到父流
	 * 
	 * @throws IOException
	 */
	public abstract void flushToParent() throws IOException;

	public void write(Object o) throws IOException
	{
		if (o != null)
		{
			this.write(o.toString());
		}

	}

	public void write(int c) throws IOException
	{
		this.write(String.valueOf(c));
	}

	public void write(long c) throws IOException
	{
		this.write(String.valueOf(c));
	}

	public void write(double c) throws IOException
	{
		this.write(String.valueOf(c));
	}

	public void write(short c) throws IOException
	{
		this.write(String.valueOf(c));
	}

	public void write(float c) throws IOException
	{
		this.write(String.valueOf(c));
	}

}
