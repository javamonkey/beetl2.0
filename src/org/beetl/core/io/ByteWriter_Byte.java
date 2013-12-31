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

import org.beetl.core.ByteWriter;
import org.beetl.core.SuperVar;

public class ByteWriter_Byte extends ByteWriter {

	private OutputStream os;
	private String cs;
	private ByteWriter parent = null;

	public ByteWriter_Byte(OutputStream os, String cs) {
		this.os = os;
		this.cs = cs;
	}

	protected ByteWriter_Byte(OutputStream os, String cs, ByteWriter parent) {
		this(os, cs);
		this.parent = parent;
	}

	@Override
	public void write(char[] cbuf) throws IOException {
		byte[] bs = new String(cbuf).getBytes(cs);
		write(bs);

	}

	@Override
	public void write(byte[] bs) throws IOException {

		os.write(bs);

	}

	protected void write(byte[] bs, int count) throws IOException {
		os.write(bs, 0, count);

	}

	@Override
	public ByteWriter getTempWriter() {
		return new ByteWriter_Byte(new NoLockByteArrayOutputStream(), cs, this);
	}

	@Override
	public Object getTempContent() {
		NoLockByteArrayOutputStream bos = (NoLockByteArrayOutputStream) os;
		return bos.toByteArray();
	}

	@Override
	public void flush() throws IOException {
		this.os.flush();

	}

	@Override
	public ByteWriter getParent() {
		return parent;
	}

	@Override
	public void write(SuperVar sv) throws IOException {
		this.os.write(sv.toByte());

	}

	@Override
	public void flushToParent() throws IOException {
		if (this.parent == null) {
			throw new NullPointerException("Parent is null");
		}
		os.flush();
		NoLockByteArrayOutputStream bos = (NoLockByteArrayOutputStream) os;
		((ByteWriter_Byte) this.parent).write(bos.buf, bos.count);

	}

}
