package com.beetl.performance.lab;

import java.lang.reflect.Method;

import com.beetl.performance.Log;
import com.beetl.performance.lab.asm.field.UserNameFiledAccess;


/**
缓存并反射调用=967 百分比,Infinity
反射=6552 百分比,Infinity
方法调用=10 百分比,Infinity
asm调用=422 百分比,Infinity
缓存并asm调用=91 百分比,Infinity


 * @author joelli
 *
 */
public class ReflectTest {

	/**
	 * @param args
	 */
	
	static Method method = null;	
	static{
		try {
			method = User.class.getMethod("getName", new Class[]{});
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	UserNameFiledAccess  unf = new UserNameFiledAccess();
	User user = new User();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ReflectTest().testReflect();

	}
	
	public void testReflect() throws Exception{
		long loop = 1000000*200;
		//warmer
		for(int i=0;i<10000000;i++){
			user.getName();
		}
		
		for(int i=0;i<10000000;i++){
			unf.value(user, "name");
		}
		
		for(int i=0;i<10000000;i++){
			method.invoke(user, new Object[]{});
		}
		
		Log.key1Start();
		for(int i=0;i<loop;i++){
			user.getName();
		}
		Log.key1End();	
		
		Log.key2Start();
		for(int i=0;i<loop;i++){
			unf.value(user,  "name");
		}
		Log.key2End();
		
		Log.key3Start();
		for(int i=0;i<loop;i++){
			method.invoke(user, new Object[]{});
		}
		Log.key3End();
		
//		
	
	
	
		
		Log.display("方法调用","asmField调用","java反射");
	}
	
	
	
	
	

}
