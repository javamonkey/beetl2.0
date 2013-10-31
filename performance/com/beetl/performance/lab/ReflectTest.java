package com.beetl.performance.lab;

import java.lang.reflect.Method;

import com.esotericsoftware.reflectasm.MethodAccess;

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
//		int loop = 10000*200;
		ReflectTest t = new ReflectTest();
//		Log.key1Start();
//		for(int i=0;i<loop;i++){
//			t.reflectplan(t, "getName");
//		}
//		Log.key1End();
//	
//		
//		Log.key2Start();
//		for(int i=0;i<loop;i++){
//			t.reflectCacheplan(t, "getName");
//		}
//		Log.key2End();
//	
//		Log.key1Start();
//		for(int i=0;i<loop;i++){
//			t.reflectplan(t, "getName");
//		}
//		Log.key1End();
//	
//		//太慢了，不考虑
//		
//		Log.key3Start();
//		for(int i=0;i<loop;i++){
//			t.call(t);
//		}
//		Log.key3End();
////	
//		
//		Log.key4Start();
//		for(int i=0;i<loop;i++){
//			t.asmCacheplan(t, "getName");
//		}
//		Log.key4End();
//	
//		Log.key5Start();
		for(int i=0;i<1;i++){
			t.asmCacheplan(t, methodIndex);
		}
//		Log.key5End();
//	
//		Log.display("缓存并反射调用","反射","方法调用","asm调用","缓存并asm调用");
	}
	
	public void asmCacheplan(Object o,String name){
		access.invoke(o, name);
		
	}
	
	public void call(Object o){
		
		((ReflectTest)o).getName();
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
