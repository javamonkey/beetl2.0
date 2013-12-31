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
import java.io.Writer;

import org.beetl.core.ByteWriter;
import org.beetl.core.SuperVar;

public class ByteWriter_Char extends ByteWriter {

	Writer w = null;
	String cs = null;
	ByteWriter parent = null;

	public ByteWriter_Char(Writer w, String cs) {
		this.w = w;
		this.cs = cs;
	}

	public ByteWriter_Char(Writer w, String cs, ByteWriter parent) {
		this(w, cs);
		this.parent = parent;
	}

	@Override
	public void write(char[] cbuf) throws IOException {
		w.write(cbuf);

	}

	@Override
	public void write(byte[] bs) throws IOException {
		this.write(new String(bs, cs));

	}

	@Override
	public ByteWriter getTempWriter() {
		return new ByteWriter_Char(new NoLockStringWriter(), cs, this);
	}

	@Override
	public Object getTempContent() {
		// 检查是否是Temp?
		return w.toString();
	}

	@Override
	public void flush() throws IOException {
		this.w.flush();

	}

	@Override
	public ByteWriter getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	public String toString() {
		return w.toString();
	}

	@Override
	public void write(SuperVar sv) throws IOException {
		this.w.write(sv.toString());

	}

	@Override
	public void flushToParent() throws IOException {
		// TODO Auto-generated method stub
		if (this.parent == null) {
			throw new NullPointerException("Parent is null");
		}
		w.flush();
		parent.write(w.toString());

	}

}
