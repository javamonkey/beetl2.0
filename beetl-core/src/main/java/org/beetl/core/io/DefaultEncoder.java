package org.beetl.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.UnsupportedCharsetException;

import org.beetl.core.ContextBuffer;

public class DefaultEncoder {

    private final CharsetEncoder charsetEncoder;
    private final double expansionFactor;
    ContextBuffer localBuffer = null;

    public DefaultEncoder(String encoding, ContextBuffer localBuffer) {
        this.expansionFactor = (this.charsetEncoder = newEncoder(encoding)).maxBytesPerChar();
        this.localBuffer = localBuffer;
    }

    public void write(final String str, final OutputStream out) throws IOException {

        int len = str.length();
        char[] buffer = this.localBuffer.getCharBuffer(len);
        if (buffer.length != 0) {
            str.getChars(0, len, buffer, 0);
            write(buffer, len, out);
        } else {
            // 直接输出
            write(str.toCharArray(), len, out);
        }

    }

    public void write(final char[] chars, final int len, final OutputStream out) throws IOException {
        if (chars != null && len != 0) {

            final CharsetEncoder encoder;
            final ByteBuffer bb;
            byte[] buffer = this.localBuffer.getByteBuffer((int)(len * this.expansionFactor));
            if (buffer.length != 0) {
                (encoder = this.charsetEncoder).reset().encode(CharBuffer.wrap(chars, 0, len),
                    bb = ByteBuffer.wrap(buffer), true);
                encoder.flush(bb);
                out.write(buffer, 0, bb.position());
            } else {
                buffer = new byte[(int)(len * this.expansionFactor)];
                (encoder = this.charsetEncoder).reset().encode(CharBuffer.wrap(chars, 0, len),
                    bb = ByteBuffer.wrap(buffer), true);
                encoder.flush(bb);
                out.write(buffer, 0, bb.position());
            }

        }
    }

    private static CharsetEncoder newEncoder(String csn) throws UnsupportedCharsetException {
        return Charset.forName(csn).newEncoder();
    }
}
