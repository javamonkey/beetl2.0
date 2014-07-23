package org.beetl.performance.lab;

import org.beetl.performance.Log;

/**
 * wrap class=829 百分比,Infinity alu改进=1294 百分比,Infinity 原来的alu=804 百分比,Infinity
 * 
 * @author joelli
 * 
 */
public class AddExpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long loop = 10000 * 500000;
		Object a = 123;
		Object b = 143;
		int type = 6;
		AddExpTest exp = new AddExpTest();

		for (int i = 0; i < 1000000; i++) {
			Object c = exp.add(a, b);
		}

		for (int i = 0; i < 1000000; i++) {
			Object c = ALU.plus(a, b);
		}

		for (int i = 0; i < 1000000; i++) {
			Object c = ALU.plus(type, a, b);
		}

		Log.key3Start();
		for (int i = 0; i < loop; i++) {
			Object c = ALU.plus(a, b);
		}
		Log.key3End();

		Log.key2Start();

		for (int i = 0; i < loop; i++) {
			Object c = ALU.plusInteger(a, b);
		}
		Log.key2End();

		Log.key1Start();
		for (int i = 0; i < loop; i++) {

			Object c = exp.add(a, b);
		}
		Log.key1End();

		Log.display("wrap class", "alu改进", "原来的alu");

	}

	public final Object add(final Object a, final Object b) {
		int x = ((Integer) a).intValue();
		int y = ((Integer) b).intValue();
		return x + y;

		// return Integer.valueOf(((Integer) a).intValue()
		// + ((Integer) b).intValue());
	}

}
