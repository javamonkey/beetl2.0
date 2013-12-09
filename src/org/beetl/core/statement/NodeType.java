package org.beetl.core.statement;

import java.util.HashMap;
import java.util.Map;

public class NodeType {
	static NodeType UNKNOW_TYPE  = null;
	static{
		UNKNOW_TYPE = new NodeType();
		UNKNOW_TYPE.classType = Object.class;
	}
	public Class classType;
	Map<String, Class> ptypeMap = new HashMap<String, Class>(1);
}
