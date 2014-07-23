package org.beetl.performance.lab;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.IteratorStatus;
import org.beetl.performance.Log;

/**
 * 普通=1341 百分比,Infinity 还是普通的=1471 百分比,Infinity 希望更好的=554 百分比,Infinity
 * 希望不太差的=539 百分比,Infinity
 * 
 * @author joelli
 * 
 */
public class IteratorMakeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 1000 * 10000;
		Object o = new Integer(1 + 1);
		Map map = new HashMap();
		for (int i = 0; i < max; i++) {
			IteratorStatus.getIteratorStatus(map);
		}

		for (int i = 0; i < max; i++) {
			IteratorStatus.getIteratorStatus(map, ((Integer) o).intValue());
		}
		Log.key2Start();
		for (int i = 0; i < max; i++) {
			IteratorStatus.getIteratorStatus(map, 0);
		}
		Log.key2End();

		Log.key3Start();
		for (int i = 0; i < max; i++) {
			IteratorStatus.getIteratorStatus(map, 2);
		}
		Log.key3End();

		Log.key1Start();
		for (int i = 0; i < max; i++) {
			IteratorStatus.getIteratorStatus(map);
		}
		Log.key1End();

		Log.key4Start();
		for (int i = 0; i < max; i++) {
			IteratorStatus.getIteratorStatus(map, ((Integer) o).intValue());
		}
		Log.key4End();

		Log.display("普通", "还是普通的", "希望更好的", "希望不太差的");

	}

}
