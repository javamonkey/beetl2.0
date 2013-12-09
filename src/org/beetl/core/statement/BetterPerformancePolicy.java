package org.beetl.core.statement;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.event.Listener;
import org.beetl.core.event.OptimizeEvent;
import org.beetl.core.event.RuntimeOptimizeListener;

public class BetterPerformancePolicy {
	Program program = null;
	NodeType[] types = null;
	boolean isCompleted = false;
	Listener ls = new RuntimeOptimizeListener();
	public void before(Context ctx){	
		if(isCompleted) return ;
		
		int y = 0;
		for(int i=0;i<types.length;i++){
			if(types[i]==null){
				if(ctx.vars[i]!=ctx.NOT_EXIST_OBJECT){
					Object o = ctx.vars[i];
					NodeType c = getType(o);
					if(c==null)continue;
					else{
						types[i] = c;
						y++;
					}
				}else{
					continue;
				}
				
			}else{
				y++;
			}
		}
		//推测完毕
		if(y==types.length){
			optimalize();
		}
		
	}
	
	private synchronized void optimalize(){
		if(isCompleted){
			//已经在优化中
			return;
		}
		if(ls!=null){
			OptimizeEvent event = new OptimizeEvent(types,program);
			ls.onEvent(event);		
		}
		isCompleted = true;
		
	}
	
	
	
	
	public void setProgram(Program program){
		this.program = program;
		//复制nodetype
		NodeType[] orginalTypes = program.metaData.nodeTypes;
		types = new NodeType[orginalTypes.length];
		for(int i=0;i<types.length;i++){
			types[i] = orginalTypes[i];
		}
		
	}

	private NodeType getType(Object c ){
		NodeType type = new NodeType();
		if( c instanceof Map){
			Map<Object,Object> map = (Map<Object,Object>)c;
			for(Entry<Object,Object> entry: map.entrySet()){
				
				Object key = entry.getKey();
				Object value = entry.getValue();
				if(value!=null){
					type.classType = Map.class;
					type.ptypeMap.put("K", key.getClass());
					type.ptypeMap.put("V", value.getClass());
					return type;
				}
				
			}
			//没有足够信息，还需要推测
			return null;
		}else if(c instanceof List){
			List<Object> list = (List<Object>)c;
			for(Object o:list){
				if(o!=null){
					type.classType = Map.class;
					type.ptypeMap.put("K", o.getClass());
					return type;
				}
			}
			//没有足够信息
			return null;
		}else if(c.getClass().isArray()){
			//Class probableType = c.getClass()
			type.classType = c.getClass().getComponentType();
			return type;
		}else{
			type.classType = c.getClass();
			return type;
		}
	}
}
