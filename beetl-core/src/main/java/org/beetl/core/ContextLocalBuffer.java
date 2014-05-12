package org.beetl.core;

import java.lang.ref.SoftReference;

public class ContextLocalBuffer
{
	static int charBufferSize = 256;
	static int byteBufferSize = 256;

	private char[] charBuffer = new char[charBufferSize];
	private byte[] byteBuffer = new byte[byteBufferSize];
	static ThreadLocal<SoftReference<ContextLocalBuffer>> threadLocal = new ThreadLocal<SoftReference<ContextLocalBuffer>>() {
		protected SoftReference<ContextLocalBuffer> initialValue()
		{
			return new SoftReference(new ContextLocalBuffer());
		}
	};

	public static ContextLocalBuffer get()
	{
		SoftReference<ContextLocalBuffer> re = threadLocal.get();
		ContextLocalBuffer ctxBuffer = re.get();
		if (ctxBuffer == null)
		{
			ctxBuffer = new ContextLocalBuffer();
			threadLocal.set(new SoftReference(ctxBuffer));
		}
		return ctxBuffer;
	}

	public char[] getCharBuffer()
	{
		return this.charBuffer;
	}

	public byte[] getByteBuffer()
	{
		return this.byteBuffer;
	}

	public char[] getCharBuffer(int expected)
	{
		if (this.charBuffer.length >= expected)
		{
			return charBuffer;
		}
		else
		{
			//?预先设置多一点
			this.charBuffer = new char[(int) (expected * 1.2)];
		}
		return this.charBuffer;
	}

	public byte[] getByteBuffer(int expected)
	{
		if (this.byteBuffer.length >= expected)
		{
			return byteBuffer;
		}
		else
		{
			//?预先设置多一点
			this.byteBuffer = new byte[(int) (expected * 1.2)];
		}
		return this.byteBuffer;
	}

}
