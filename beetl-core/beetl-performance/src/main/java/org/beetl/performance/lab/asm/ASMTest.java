package org.beetl.performance.lab.asm;

import org.beetl.performance.lab.User;

public class ASMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] bs = ASMGen.dump();
		MyClassLoader loader = new MyClassLoader();
		Class c = loader.defineClass(
				"com.beetl.performance.lab.asm.UserAsmAccessor1", bs);
		Object o = c.newInstance();
		Access a = (Access) o;
		int id = (Integer) a.get(new User(), 2);
		System.out.println(id);

	}

}

class MyClassLoader extends ClassLoader {
	public Class defineClass(String name, byte[] b) {
		return defineClass(name, b, 0, b.length);
	}
}
