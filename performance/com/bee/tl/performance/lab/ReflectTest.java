package com.bee.tl.performance.lab;

import java.lang.reflect.Method;

import com.bee.tl.performance.Log;
import com.esotericsoftware.reflectasm.MethodAccess;

/**
 * key1=1032 百分比,Infinity
key2=6384 百分比,Infinity
key3=0 百分比,NaN
key4=463 百分比,Infinity
key5=89 百分比,Infinity

 * @author joelli
 *
 */
public class ReflectTest {

	/**
	 * @param args
	 */
	
	static Method method = null;
	static MethodAccess access = MethodAccess.get(ReflectTest.class);
	static int methodIndex = 0;
	static {
		try {
			method = ReflectTest.class.getMethod("getName", new Class[]{});
			methodIndex = access.getIndex("getName");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ReflectTest().testReflect();

	}
	
	public void testReflect() throws Exception{
		int loop = 10000*200;
		ReflectTest t = new ReflectTest();
		Log.key1Start();
		for(int i=0;i<loop;i++){
			t.reflectplan(t, "getName");
		}
		Log.key1End();
	
		
		Log.key2Start();
		for(int i=0;i<loop;i++){
			t.reflectCacheplan(t, "getName");
		}
		Log.key2End();
	
		Log.key1Start();
		for(int i=0;i<loop;i++){
			t.reflectplan(t, "getName");
		}
		Log.key1End();
	
		//太慢了，不考虑
		
//		Log.key3Start();
//		for(int i=0;i<loop;i++){
//			t.asmplan(t, "getName");
//		}
//		Log.key3End();
//	
		
		Log.key4Start();
		for(int i=0;i<loop;i++){
			t.asmCacheplan(t, "getName");
		}
		Log.key4End();
	
		Log.key5Start();
		for(int i=0;i<loop;i++){
			t.asmCacheplan(t, methodIndex);
		}
		Log.key5End();
	
		Log.display();
	}
	
	public void asmplan(Object o,String name){
		MethodAccess access = MethodAccess.get(ReflectTest.class);
		access.invoke(o, name);
		
	}
	
	public void asmCacheplan(Object o,String name){
		
		access.invoke(o, name);
		
	}
	
	public void asmCacheplan(Object o,int index){
		
		access.invoke(o, index);
		
	}
	
	
	
	public void reflectplan(Object o,String name)throws Exception{
		//Method method = o.getClass().getMethod(name, new Class[]{});
		method.invoke(o, new Object[]{});
	}
	
	public void reflectCacheplan(Object o,String name)throws Exception{
		Method m = o.getClass().getMethod(name, new Class[]{});
		m.invoke(o, new Object[]{});
	}
	
	public String getName(){
		return "a";
	}

}
