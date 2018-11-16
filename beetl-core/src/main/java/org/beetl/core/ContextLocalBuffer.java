package org.beetl.core;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 一个缓存的字节和字符数组，用于减少beetl渲染各个过程中渲染字符数组
 * 
 * @author joelli
 *
 */
public class ContextLocalBuffer {
	/**
	 * 初始化的字符数组大小
	 */
	public static int charBufferSize = 256;

	/**
	 * 初始化的字节大小
	 */
	public static int byteBufferSize = 256;

	/* 最大分配的缓存 */
	public static int MAX_SIZE = 1024 * 4;
	// 考虑字节输出，一个字符可能占用4个字节，所以乘以4
	public static int BYTE_MAX_SIZE = 1024 * 4 * 4;
	// 采用soft还是weak来保持缓存
	public static boolean isSoft = true;
	// 是否采用ThreadLocal来提供性能
	public static boolean isThreadLocal = true;

	private char[] charBuffer = new char[charBufferSize];
	private byte[] byteBuffer = new byte[byteBufferSize];

	private char[] EMPTY_CHAR_ARRAY = new char[0];
	private byte[] EMPTY_BYTE_ARRAY = new byte[0];

	static ThreadLocalMap threadLocal = new ThreadLocalMap();

	public static ContextLocalBuffer get() {
		if (!isThreadLocal) {
			// 渲染过程使用一个buffer
			return new ContextLocalBuffer();
		}
		Reference<ContextLocalBuffer> re = threadLocal.get();
		ContextLocalBuffer ctxBuffer = re.get();
		if (ctxBuffer == null) {
			Reference<ContextLocalBuffer> one = createOne();

			ctxBuffer = one.get();
			if (ctxBuffer == null) {
				// 对于弱引用，刚弄出来就清空了，很不巧
				return new ContextLocalBuffer();
			}
			threadLocal.set(one);
		}
		return ctxBuffer;
	}

	public static void clear() {
		threadLocal.clear();
	}

	public char[] getCharBuffer() {
		return this.charBuffer;
	}

	public byte[] getByteBuffer() {
		return this.byteBuffer;
	}

	/**
	 * 得到一个期望长度的buffer,调用者应该检测是否返回null，表示
	 * 
	 * @param expected
	 * @return
	 */
	public char[] getCharBuffer(int expected) {
		if (this.charBuffer.length >= expected) {
			return charBuffer;
		} else if (expected < MAX_SIZE) {
			// ?预先设置多一点
			this.charBuffer = new char[(int) (expected * 1.2)];
		} else {
			return EMPTY_CHAR_ARRAY;
		}
		return this.charBuffer;
	}

	/**
	 * 得到期望字节数组大小
	 * 
	 * @param expected
	 * @return
	 */
	public byte[] getByteBuffer(int expected) {
		if (this.byteBuffer.length >= expected) {
			return byteBuffer;
		} else if (expected < MAX_SIZE) {
			// ?预先设置多一点
			byteBuffer = new byte[(int) (expected * 1.2)];
			return byteBuffer;
		} else {
			return EMPTY_BYTE_ARRAY;
		}

	}

	static class ThreadLocalMap {
		public ConcurrentMap<Thread, Reference<ContextLocalBuffer>> map = new ConcurrentHashMap<Thread, Reference<ContextLocalBuffer>>();

		public Reference<ContextLocalBuffer> get() {
			Thread thread = Thread.currentThread();
			Reference<ContextLocalBuffer> soft = map.get(thread);
			if (soft == null) {
				soft = createOne();
				map.put(thread, soft);
			}
			return soft;
		}

		public void set(Reference<ContextLocalBuffer> o) {
			Thread thread = Thread.currentThread();
			map.put(thread, o);
		}

		public void clear() {
			map.clear();
		}
	}

	static Reference<ContextLocalBuffer> createOne() {
		if (isSoft) {
			return new SoftReference<ContextLocalBuffer>(new ContextLocalBuffer());
		} else {

			return new WeakReference<ContextLocalBuffer>(new ContextLocalBuffer());
		}

	}

}
