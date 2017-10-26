package org.beetl.core.lab;

import org.beetl.core.AntlrProgramBuilder;
import org.beetl.core.GroupTemplate;
import org.beetl.core.engine.DefaultTemplateEngine;

public class VarRefTemplateEngine extends DefaultTemplateEngine {
	protected AntlrProgramBuilder getAntlrBuilder(GroupTemplate gt){
		AntlrProgramBuilder pb = new AntlrProgramBuilder(gt);
		return pb;
	}
	
	class VarRefAntlrProgramBuilder extends AntlrProgramBuilder{

		public VarRefAntlrProgramBuilder(GroupTemplate gt) {
			super(gt);
			
		}
		
	}
}
