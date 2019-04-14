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
package org.beetl.core;

/*
 
 Copyright (c) 2011-2013  闲大赋 (李家智)
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

import org.beetl.core.io.FloatingIOWriter;
import org.beetl.core.io.IntIOWriter;
import org.beetl.core.io.LongIOWriter;

/** 混合了字节和字符的Writer
 * @author joelli
 *
 */
public abstract class ByteWriter
{

	protected ContextBuffer localBuffer = null;
	protected Context ctx = null;
	protected ByteWriter parent;

	public ByteWriter(Context ctx)
	{
		this.ctx = ctx;
		this.localBuffer = ctx.localBuffer;
	}

	public abstract void write(char[] cbuf) throws IOException;

	public abstract void write(char[] cbuf, int len) throws IOException;

	public abstract void writeString(String str) throws IOException;

	/**
	 * @param chars
	 * @param len
	 * @throws IOException
	 */
	public abstract void writeNumberChars(char[] chars, int len) throws IOException;

	public abstract void write(byte[] bs) throws IOException;

	public abstract void write(byte[] bs, int count) throws IOException;

	//	public abstract void write(BodyContent bc) throws IOException;

	public abstract ByteWriter getTempWriter(ByteWriter parent);

	public abstract BodyContent getTempConent();

	/**
	 * 将内容填充到bw里
	 * @param bw
	 */
	public abstract void fill(ByteWriter bw) throws IOException;

	public abstract void flush() throws IOException;

	public void write(BodyContent bodyContent) throws IOException
	{
		bodyContent.fill(this);
	}

	public void writeDouble(Double d) throws IOException
	{
		FloatingIOWriter fd = new FloatingIOWriter(d);
		fd.write(this, localBuffer.getCharBuffer());
	}

	public void writeFloat(Float d) throws IOException
	{
		FloatingIOWriter fd = new FloatingIOWriter(d);
		fd.write(this, localBuffer.getCharBuffer());
	}

	public void writeInteger(Integer i) throws IOException
	{

		IntIOWriter.writeInteger(this, i);

	}

	public void writeShort(Short i) throws IOException
	{

		IntIOWriter.writeShort(this, i);

	}

	public void writeLong(Long i) throws IOException
	{

		LongIOWriter.writeLong(this, i);
	}

	public void writeObject(Object o) throws IOException
	{
		if (o != null)
		{

			this.writeString(o.toString());

		}

	}

	public ContextBuffer getLocalBuffer()
	{
		return localBuffer;
	}

	public ByteWriter getParent() {
		return parent;
	}
	
	

}
