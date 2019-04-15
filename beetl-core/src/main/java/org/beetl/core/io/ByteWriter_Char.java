/*
 * [The "BSD license"] Copyright (c) 2011-2019  闲大赋 (李家智) All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met: 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer. 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or other materials provided with the
 * distribution. 3. The name of the author may not be used to endorse or promote products derived from this software
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.io;

import java.io.IOException;
import java.io.Writer;

import org.beetl.core.BodyContent;
import org.beetl.core.ByteWriter;
import org.beetl.core.Context;

public final class ByteWriter_Char extends ByteWriter {

    Writer w;
    String cs;

    public ByteWriter_Char(Writer w, String cs, Context ctx) {
        super(ctx);
        this.w = w;
        this.cs = cs;
    }

    public ByteWriter_Char(Writer w, String cs, Context ctx, ByteWriter parent) {
        this(w, cs, ctx);
        this.parent = parent;
    }

    @Override
    public final void write(char[] cbuf) throws IOException {
        w.write(cbuf);

    }

    @Override
    public void write(char[] cbuf, int len) throws IOException {
        w.write(cbuf, 0, len);

    }

    @Override
    public void writeString(String str) throws IOException {

        if (str != null) {
            int len = str.length();
            char[] buf = localBuffer.getCharBuffer(len);
            if (buf.length != 0) {
                str.getChars(0, len, buf, 0);
                this.write(buf, len);
            } else {
                w.write(str);
            }

        }

    }

    @Override
    public final void write(byte[] bs) throws IOException {
        this.writeString(new String(bs, cs));

    }

    @Override
    public final void write(byte[] bs, int count) throws IOException {
        this.writeString(new String(bs, 0, count, cs));

    }

    @Override
    public ByteWriter getTempWriter(ByteWriter parent) {
        return new ByteWriter_Char(new NoLockStringWriter(), cs, ctx, parent);
    }

    @Override
    public void flush() throws IOException {
        if (parent != null)
            parent.flush();
        this.w.flush();

    }

    @Override
    public String toString() {
        return w.toString();
    }

    @Override
    public void fill(ByteWriter bw) throws IOException {
        NoLockStringWriter blw = ((NoLockStringWriter)((ByteWriter_Char)bw).w);
        char[] buf = blw.buf;
        this.write(buf, blw.count);

    }

    @Override
    public BodyContent getTempConent() {
        NoLockStringWriter blw = (NoLockStringWriter)w;
        return new StringBodyContent(blw.buf, blw.count);
    }

    public Writer getW() {
        return w;
    }

    public void setW(Writer w) {
        this.w = w;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    @Override
    public void writeNumberChars(char[] chars, int len) throws IOException

    {
        this.w.write(chars, 0, len);

    }
}
