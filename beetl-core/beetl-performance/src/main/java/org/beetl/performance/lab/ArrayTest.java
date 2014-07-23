package org.beetl.performance.lab;

import org.beetl.performance.Log;

/**
 * 分配=1709 百分比,Infinity 重用=507 百分比,Infinity
 * 
 * @author joelli
 * 
 */
public class ArrayTest {

	/**
	 * @param args
	 */
	Object[] a = new Object[15];
	int length = a.length;

	public static void main(String[] args) {
		ArrayTest t = new ArrayTest();
		long max = 1000 * 1000 * 100;
		t.testNew(1000);
		t.testReuse(1000);

		Log.key1Start();
		t.testNew(max);
		Log.key1End();

		Log.key2Start();
		t.testReuse(max);
		Log.key2End();
		Log.display("分配", "重用");

	}

	public void testNew(long max) {
		for (int i = 0; i < max; i++) {
			a = new Object[15];
		}

	}

	public void testReuse(long max) {
		for (int i = 0; i < max; i++) {
			for (Object c : a) {
				c = null;
			}
		}

	}

}
