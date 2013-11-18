package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Context {

	protected ByteWriter byteWriter;
	/*全局变量*/
	protected Map<String,Object> globalVar = new HashMap<String,Object>(8);
	/*内容为Object的变量，beetl要求全局变量类型总是一致，如果一个key
	 * 对应的类型不一样，则需要设置objectKeys*/
	protected List<String> objectKeys = new ArrayList(2); 
	protected String[] staticTextArray = null;
	//存放临时变量都放在数组里
	protected Object[] vars = null;		
	protected Object[] cachedArray = null;
	
	protected boolean byteOutputMode =  false ;
	
	
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
