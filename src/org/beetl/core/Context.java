package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.exception.TempException;


public class Context {
	
	public static Object NOT_EXIST_OBJECT = new Object();

	public ByteWriter byteWriter;
	/*全局变量*/
	public  Map<String,Object> globalVar = new HashMap<String,Object>(8);
	/*内容为Object的变量，beetl要求全局变量类型总是一致，如果一个key
	 * 对应的类型不一样，则需要设置objectKeys*/
	public  List<String> objectKeys = new ArrayList<String>(2); 
	
	public boolean byteOutputMode =  false ;
	
	//当前会话相关变量全局变量和临时变量都放在数组里，全局变量放在前面
	public Object[] vars = null;
	
	
	
	//这些变量来自于ProgrameMeta
	public  String[] staticTextArray = null;
	
	public  int tempVarStartIndex = -1;
	
	public  Object[] cachedArray = null;
	
	

	
	
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
	
	
	
	
}
