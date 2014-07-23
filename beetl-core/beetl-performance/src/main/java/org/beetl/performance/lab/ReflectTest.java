package org.beetl.performance.lab;

import java.lang.reflect.Method;

import org.beetl.performance.Log;
import org.beetl.performance.lab.asm.field.UserGeneralAccess;
import org.beetl.performance.lab.asm.field.UserNameFiledAccess;

/**
 * 方法调用=228 百分比,Infinity asmField调用=226 百分比,Infinity java反射=556 百分比,Infinity
 * asmMethod=326 百分比,Infinity
 * 
 * 
 * @author joelli
 * 
 */
public class ReflectTest {

	/**
	 * @param args
	 */

	static Method method = null;
	static {
		try {
			method = User.class.getMethod("getName", new Class[] {});
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	UserNameFiledAccess unf = new UserNameFiledAccess();
	UserGeneralAccess uga = new UserGeneralAccess();
	User user = new User();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("name".hashCode());
		new ReflectTest().testReflect();

	}

	public void testReflect() throws Exception {
		long loop = 1000000 * 200;
		// warmer
		for (int i = 0; i < 10000000; i++) {
			user.getName();
		}

		for (int i = 0; i < 10000000; i++) {
			unf.value(user, "name");
		}

		for (int i = 0; i < 10000000; i++) {
			method.invoke(user, new Object[] {});
		}

		for (int i = 0; i < 10000000; i++) {
			uga.value(user, "name");
		}

		Log.key1Start();
		for (int i = 0; i < loop; i++) {
			user.getName();
		}
		Log.key1End();

		Log.key2Start();
		for (int i = 0; i < loop; i++) {
			unf.value(user, "name");
		}
		Log.key2End();

		Log.key3Start();
		for (int i = 0; i < loop; i++) {
			method.invoke(user, new Object[] {});
		}
		Log.key3End();

		Log.key4Start();
		for (int i = 0; i < loop; i++) {
			uga.value(user, "name");
		}
		Log.key4End();

		//

		Log.display("方法调用", "asmField调用", "java反射", "asmMethod");
	}

}
