package org.beetl.core;

/**
 * 一个缓存的字节和字符数组，用于减少beetl渲染各个过程中渲染字符数组
 * 
 * @author joelli
 *
 */
public class ContextBuffer {

	public static int minSize = 256;
	/**
	 * 初始化的字符数组大小
	 */
	public static int charBufferSize = minSize;

	/**
	 * 初始化的字节大小
	 */
	public static int byteBufferSize = minSize;

	/*没有空间时候返回*/
	private static char[] EMPTY_CHAR_ARRAY = new char[0];
	private static byte[] EMPTY_BYTE_ARRAY = new byte[0];

	/**
	 * 最大空间
	 */
	int maxSize = 0;
	/**
	 * 是否是个临时buffer，如果是，不能保存在ContextLocalBuffers
	 */
	boolean inner = true;

	private char[] charBuffer = new char[charBufferSize];
	private byte[] byteBuffer = new byte[byteBufferSize];



	public ContextBuffer(int maxSize, boolean inner){
		this(maxSize);
		this.inner = inner;
	}

	public ContextBuffer(int maxSize){
		if(maxSize<minSize){
			throw new IllegalArgumentException("buffer期望设置需要大于 "+minSize);
		}
		this.maxSize = maxSize;
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
		} else if (expected < maxSize) {
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
		} else if (expected < maxSize) {
			// 预先设置多一点
			byteBuffer = new byte[(int) (expected * 1.2)];
			return byteBuffer;
		} else {
			return EMPTY_BYTE_ARRAY;
		}

	}



}
