package org.beetl.core.util;

public class NumberUtil {
	static Integer[] INTEGER = new Integer[256];
	static {
		for (int i = 0; i < INTEGER.length; i++) {
			INTEGER[i] = new Integer(i);
		}
	}

	public static Integer valueOf(int i) {
		if (i < INTEGER.length) {
			return INTEGER[i];
		} else {
			return new Integer(i);
		}
	}

}
