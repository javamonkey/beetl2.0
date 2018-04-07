package org.beetl.core;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/** 一个缓存的字节和字符数组，用于减少beetl渲染各个过程中渲染字符数组
 * @author joelli
 *
 */
public class ContextLocalBuffer
{
	/**
	 *  初始化的字符数组大小
	 */
	public static int charBufferSize = 256;

	/**
	 * 初始化的字节大小
	 */
	public static int byteBufferSize = 256;

	private char[] charBuffer = new char[charBufferSize];
	private byte[] byteBuffer = new byte[byteBufferSize];
//	static ThreadLocal<SoftReference<ContextLocalBuffer>> threadLocal = new ThreadLocal<SoftReference<ContextLocalBuffer>>() {
//		protected SoftReference<ContextLocalBuffer> initialValue()
//		{
//			return new SoftReference(new ContextLocalBuffer());
//		}
//	};
	
	static ThreadLocalMap threadLocal = new ThreadLocalMap();

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
	
	public static void clear() {
		threadLocal.clear();
	}
	
	

	public char[] getCharBuffer()
	{
		return this.charBuffer;
	}

	public byte[] getByteBuffer()
	{
		return this.byteBuffer;
	}
	
	

	/** 得到一个期望长度的buffer
	 * @param expected
	 * @return
	 */
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

	/**得到期望字节数组大小
	 * @param expected
	 * @return
	 */
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
	
	static class ThreadLocalMap{
		public ConcurrentMap<Thread,SoftReference<ContextLocalBuffer>> map = new ConcurrentHashMap<Thread,SoftReference<ContextLocalBuffer>>();
		public SoftReference<ContextLocalBuffer>  get() {
			Thread thread = Thread.currentThread();
			SoftReference<ContextLocalBuffer>  soft = map.get(thread);
			if(soft==null) {
				 soft = new SoftReference(new ContextLocalBuffer());
				 map.put(thread, soft);
			}
			return soft ;
		}
		
		public void set(SoftReference<ContextLocalBuffer> o) {
			Thread thread = Thread.currentThread();
			map.put(thread, o);
		}
		
		public void clear() {
			map.clear();
		}
	}

}
