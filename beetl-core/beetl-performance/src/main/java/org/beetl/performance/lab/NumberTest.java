package org.beetl.performance.lab;

import org.beetl.performance.Log;

public class NumberTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NumberTest().testAdd();

	}

	static Integer[] cache = new Integer[128];
	static {
		for (int i = 0; i < cache.length; i++) {
			cache[i] = new Integer(i);
		}
	}

	void testAdd() {
		int loop = 10000 * 5000;
		Object a = 333;
		Object b = 2332;

		Log.key1Start();
		for (int i = 0; i < loop; i++) {
			testAddPlan1(a, b);
		}
		Log.key1End();

		Log.key2Start();
		for (int i = 0; i < loop; i++) {
			testAddPlan2(a, b);
		}
		Log.key2End();

		Log.key3Start();
		for (int i = 0; i < loop; i++) {
			testAddPlan3(a, b);
		}
		Log.key3End();

		Log.key4Start();
		for (int i = 0; i < loop; i++) {
			testAddPlan4(a, b);
		}
		Log.key4End();

		Log.display();

	}

	public Object testAddPlan1(Object a, Object b) {
		int t = 1;
		switch (t) {
		case 1: {
			return Integer.valueOf(((Integer) a).intValue()
					+ ((Integer) b).intValue());
		}
		}
		return 0;

	}

	public Object testAddPlan2(Object a, Object b) {
		int t = 1;
		switch (t) {
		case 1: {
			return new Integer(((Integer) a).intValue()
					+ ((Integer) b).intValue());
		}
		}
		return 0;

	}

	public Object testAddPlan3(Object a, Object b) {
		int t = 1;
		switch (t) {
		case 1: {
			return ((Integer) a).intValue() + ((Integer) b).intValue();
		}
		}
		return 0;

	}

	public Object testAddPlan4(Object a, Object b) {
		int t = 1;
		switch (t) {
		case 1: {

			int c = ((Integer) a).intValue() + ((Integer) b).intValue();
			if (c > 0 && c < cache.length) {
				return cache[c];
			} else {
				return new Integer(c);
			}
		}
		}
		return 0;

	}

	public int getType(Object a, Object b) {
		if (a instanceof Integer || b instanceof Integer) {
			return 1;
		} else if (a instanceof Double || b instanceof Double) {
			return 2;
		} else {
			return 3;
		}
	}

}
