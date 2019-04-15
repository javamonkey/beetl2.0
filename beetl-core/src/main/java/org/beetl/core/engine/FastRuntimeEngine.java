package org.beetl.core.engine;

import java.io.Reader;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.om.AABuilder;
import org.beetl.core.om.AsmAAFactory;
import org.beetl.core.statement.Program;

/**
 * POJO 的属性采用ASM来访问
 */
public class FastRuntimeEngine extends DefaultTemplateEngine {

	public FastRuntimeEngine(){
		super();
		AABuilder.defalutAAFactory = new AsmAAFactory();
	}
	@Override
	public Program createProgram(Resource rs, Reader reader, Map<Integer, String> textMap, String cr,
			GroupTemplate gt) {

		Program program =  super.createProgram(rs, reader, textMap, cr, gt);
		return program;
	}

}
