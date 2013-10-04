package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Context {
	BeetlScript script;
	ByteWriter byteWriter;
	/*全局变量*/
	Map<String,Object> globalVar = new HashMap<String,Object>(8);
	/*内容为Object的变量，beetl要求全局变量类型总是一致，如果一个key
	 * 对应的类型不一样，则需要设置objectKeys*/
	List<String> objectKeys = new ArrayList(2); 
	//存放临时变量都放在数组里
	Object[] vars = new Object[8];
	
	
	/**得到临时模板变量
	 * @param i
	 * @return
	 */
	protected Object getVar(int i){
		return vars[i];
	}
	
	/**设置临时模板变量
	 * @param i
	 * @param object
	 */
	protected void setVar(int i,Object value){
		vars[i] = value;
	}
	
	public void set(String key,Object value){
		globalVar.put(key, value);
	}
	
	public void set(String key,Object value,boolean isDynamicObject){
		globalVar.put(key, value);
		if(isDynamicObject){
			objectKeys.add(key);
		}
	}
	public Object getGlobal(String key){
		return globalVar.get(key);
	}
	
	
	
	
}
