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
	UserNameFiledAccess  unf = new UserNameFiledAccess();
	User user = new User();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ReflectTest().testReflect();

	}
	
	public void testReflect() throws Exception{
		long loop = 1000000*2000;
		//warmer
		for(int i=0;i<10000000;i++){
			user.getName();
		}
		
		for(int i=0;i<10000000;i++){
			unf.get(user, 0, "name");
		}
		
		Log.key1Start();
		for(int i=0;i<loop;i++){
			user.getName();
		}
		Log.key1End();	
		Log.key2Start();
		for(int i=0;i<loop;i++){
			unf.get(user, 0, "name");
		}
		Log.key2End();
		
//		
	
	
	
		
		Log.display("方法调用","asmField调用");
	}
	
	
	
	
	

}
