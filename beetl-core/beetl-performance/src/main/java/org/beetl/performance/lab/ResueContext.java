package org.beetl.performance.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.beetl.performance.Log;

/**
 * 重用context 没有好的效果
 * 
 * @author joelli
 * 
 */
public class ResueContext {

	/**
	 * @param args
	 */

	Map<String, Object> globalVar = new HashMap<String, Object>(8);
	List<String> objectKeys = new ArrayList<String>(2);
	Object[] vars = new Object[8];
	static Stack<ResueContext> stack = new Stack<ResueContext>();
	static {
		stack.push(new ResueContext());
	}

	public static void main(String[] args) {
		int count = 5000000;
		Log.key1Start();
		for (int i = 0; i < count; i++) {
			create();
		}
		Log.key1End();

		Log.key2Start();
		for (int i = 0; i < count; i++) {
			resuse();
		}
		Log.key2End();
		Log.display();
	}

	private static void create() {
		Map<String, Object> globalVar = new HashMap<String, Object>(8);
		List<String> objectKeys = new ArrayList<String>(2);
		Object[] vars = new Object[8];
	}

	private static void resuse() {
		ResueContext c = (ResueContext) stack.pop();
		c.globalVar.clear();
		c.objectKeys.clear();
		stack.push(c);
	}

}
