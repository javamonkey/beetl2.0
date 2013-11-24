package org.beetl.core.attr;

import java.util.List;
import java.util.Map;

public class ObjectAA extends AA {

	@Override
	public Object value(Object o, Object name) {
		if(o instanceof Map){
			return ((Map)o).get(name);
		}else if(o instanceof List){
			return ((List)o).get(((Number)name).intValue());
		}else if(o.getClass().isArray()){
			return ((Object[])o)[(((Number)name).intValue())];
		}else if(isGeneralGet(o.getClass())){
			//检测是否是General Get
			return null;
		}else{

			//反射调用
			return null;
		}
	}
	
	protected boolean isGeneralGet(Class c){
		return false;
	}

}
