package org.beetl.performance;

/**
 * 
 * @author joelli
 * @since 1.1
 * 
 */
public class Log {
	static long startAll;
	static long endAll;
	static long key1Start;
	static long key1End;
	static long key2Start;
	static long key2End;
	static long key3Start;
	static long key3End;
	static long key4Start;
	static long key4End;
	static long key5Start;
	static long key5End;

	public static void startAll() {
		startAll = System.currentTimeMillis();
	}

	public static void endAll() {
		endAll = endAll + (System.currentTimeMillis() - startAll);
		startAll = 0;
	}

	public static void key1Start() {
		key1Start = System.currentTimeMillis();
	}

	public static void key1End() {
		key1End = key1End + (System.currentTimeMillis() - key1Start);
		key1Start = 0;
	}

	public static void key2Start() {
		key2Start = System.currentTimeMillis();
	}

	public static void key2End() {
		key2End = key2End + (System.currentTimeMillis() - key2Start);
		key2Start = 0;
	}

	public static void key3Start() {
		key3Start = System.currentTimeMillis();
	}

	public static void key3End() {
		key3End = key3End + (System.currentTimeMillis() - key3Start);
		key3Start = 0;
	}

	public static void key4Start() {
		key4Start = System.currentTimeMillis();
	}

	public static void key4End() {
		key4End = key4End + (System.currentTimeMillis() - key4Start);
		key4Start = 0;
	}

	public static void key5Start() {
		key5Start = System.currentTimeMillis();
	}

	public static void key5End() {
		key5End = key5End + (System.currentTimeMillis() - key5Start);
		key5Start = 0;
	}

	public static void display() {
		long total = endAll;
		System.out.println("key1=" + key1End + " 百分比," + key1End * 1.0 / total);
		System.out.println("key2=" + key2End + " 百分比," + key2End * 1.0 / total);
		System.out.println("key3=" + key3End + " 百分比," + key3End * 1.0 / total);
		System.out.println("key4=" + key4End + " 百分比," + key4End * 1.0 / total);
		System.out.println("key5=" + key5End + " 百分比," + key5End * 1.0 / total);

	}

	public static void display(String... cat) {
		long total = endAll;
		System.out.println(cat[0] + "=" + key1End + " 百分比," + key1End * 1.0
				/ total);
		System.out.println((cat.length >= 2 ? cat[1] : "key2") + "=" + key2End
				+ " 百分比," + key2End * 1.0 / total);
		System.out.println((cat.length >= 3 ? cat[2] : "key3") + "=" + key3End
				+ " 百分比," + key3End * 1.0 / total);
		System.out.println((cat.length >= 4 ? cat[3] : "key4") + "=" + key4End
				+ " 百分比," + key4End * 1.0 / total);
		System.out.println((cat.length >= 5 ? cat[4] : "key5") + "=" + key5End
				+ " 百分比," + key5End * 1.0 / total);

	}

}