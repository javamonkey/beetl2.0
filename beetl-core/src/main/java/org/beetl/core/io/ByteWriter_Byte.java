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
import java.io.OutputStream;

import org.beetl.core.BodyContent;
import org.beetl.core.ByteWriter;
import org.beetl.core.Context;

public class ByteWriter_Byte extends ByteWriter
{

	protected OutputStream os;
	protected String cs;
	DefaultEncoder encode = null;

	//	protected Charset charset = null;
	//	CharsetEncoder encoder = null;
	//	ByteBuffer byteBuffer = null;
	//	byte[] bs = new byte[256];

	public ByteWriter_Byte(OutputStream os, String cs, Context ctx)
	{
		super(ctx);
		this.os = os;
		this.cs = cs;
		encode = new DefaultEncoder(cs, this.localBuffer);

	}

	public ByteWriter_Byte(OutputStream os, String cs, Context ctx, ByteWriter parent)
	{
		this(os, cs, ctx);
		this.parent = parent;

	}

	@Override
	public final void write(final char[] cbuf) throws IOException
	{
		this.write(cbuf, cbuf.length);

		//todo:性能如何？

	}

	@Override
	public final void write(final char[] cbuf, final int len) throws IOException
	{
		byte[] bs = new String(cbuf, 0, len).getBytes(cs);
		write(bs);

	}

	@Override
	public final void write(final byte[] bs) throws IOException
	{

		os.write(bs);

	}

	public void write(byte[] bs, int count) throws IOException
	{
		os.write(bs, 0, count);

	}

	public void writeString(String str) throws IOException
	{

		if (str != null)
		{
			encode.write(str, os);
			//			os.write(str.getBytes(cs));
		}

	}

	@Override
	public ByteWriter getTempWriter(ByteWriter parent)
	{
		return new ByteWriter_Byte(new NoLockByteArrayOutputStream(), cs, this.ctx, parent);
	}

	@Override
	public void flush() throws IOException
	{
		if (parent != null)
			parent.flush();
		this.os.flush();

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

	@Override
	public void writeNumberChars(char[] chars, int len) throws IOException
	{

		byte[] bs = ctx.localBuffer.getByteBuffer(len);
		for (int i = 0; i < len; i++)
		{

			bs[i] = (byte) chars[i];

		}
		this.os.write(bs, 0, len);

	}
}
