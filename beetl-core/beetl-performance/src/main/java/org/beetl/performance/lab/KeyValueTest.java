package org.beetl.performance.lab;

import java.util.HashMap;
import java.util.Map;

import org.beetl.performance.Log;

public class KeyValueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new KeyValueTest().testMapAndArray();

	}

	void testMapAndArray() {
		String value1 = "a";
		String value2 = "b";
		String value3 = "c";
		String key1 = "key1";
		String key2 = "key2";
		String key3 = "key3";
		String[] objects = new String[3];
		int loop = 10000 * 5000;
		Log.key1Start();
		for (int i = 0; i < loop; i++) {
			objects[0] = value1;
			objects[1] = value2;
			objects[2] = value3;

		}
		Log.key1End();

		Map<String, String> map = new HashMap<String, String>(3);
		Log.key2Start();
		for (int i = 0; i < loop; i++) {
			map.put(key1, value1);
			map.put(key2, value2);
			map.put(key3, value3);

		}
		Log.key2End();

		// get test
		Log.key3Start();
		for (int i = 0; i < loop; i++) {
			value1 = objects[0];
			value2 = objects[1];
			value3 = objects[2];

		}
		Log.key3End();

		Log.key4Start();
		for (int i = 0; i < loop; i++) {
			value1 = map.get(key1);
			value2 = map.get(key2);
			value3 = map.get(key3);

		}
		Log.key4End();

		Log.display("使用数组设置", "使用Map设置", "使用数组读取", "使用map读取");

	}

}
