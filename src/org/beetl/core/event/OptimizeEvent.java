package org.beetl.core.event;

import org.beetl.core.statement.NodeType;
import org.beetl.core.statement.Program;

public class OptimizeEvent extends Event{
	NodeType[] types;
	Program program;
	public OptimizeEvent(NodeType[] types,Program program){
		this.types = types;
		this.program = program;
	}
}
