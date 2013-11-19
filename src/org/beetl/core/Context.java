package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.exception.TempException;


public class Context {
	
	public static Object NOT_EXIST_OBJECT = new Object();

	protected ByteWriter byteWriter;
	/*全局变量*/
	protected Map<String,Object> globalVar = new HashMap<String,Object>(8);
	/*内容为Object的变量，beetl要求全局变量类型总是一致，如果一个key
	 * 对应的类型不一样，则需要设置objectKeys*/
	protected List<String> objectKeys = new ArrayList<String>(2); 
	
	protected String[] staticTextArray = null;
	
	//全局变量和临时变量都放在数组里，全局变量放在前面
	protected Object[] vars = null;
	
	protected int tempVarStartIndex = -1;
	
	protected Object[] cachedArray = null;
	
	protected boolean byteOutputMode =  false ;
	
	
	/**得到临时模板变量
	 * @param i
	 * @return
	 */
	protected Object getVar(int i){
		if(i>=this.tempVarStartIndex) return vars[i];
		else{
			Object object = vars[i];
			if(object==NOT_EXIST_OBJECT){
				throw new TempException("变量不存在");
			}else{
				return object;
			}
		}
		
	}
	
	/**设置临时模板变量
	 * @param i
	 * @param object
	 */
	protected void setVar(int i,Object value){
		if(i>=this.tempVarStartIndex)		vars[i] = value;
		else{
			//可以赋值么？既然没有改变模型和controller
			throw new TempException("全局变量，不能赋值");
		}
	}
	
	/**
	 * 判断全局变量是否存在
	 * @param i
	 * @return
	 */
	protected boolean exist(int i){
		if(i>=this.tempVarStartIndex){
			return true;
		}else{
			Object object = vars[i];
			return object!=NOT_EXIST_OBJECT;
		}
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
	
	/**将模板全局变量转为数组
	 * @param map
	 */
	protected void putGlobaToArray(Map<String,Integer> map){
		tempVarStartIndex = map.size();
		for(Entry<String,Integer> entry:map.entrySet()){
			String key = entry.getKey();
			int index = entry.getValue();
			if(globalVar.containsKey(key)){
				
				this.vars[index] = globalVar.get(key);
				
			}else{
				//不存在
				this.vars[index] = NOT_EXIST_OBJECT;
			}
		}
	}
	
	
}
