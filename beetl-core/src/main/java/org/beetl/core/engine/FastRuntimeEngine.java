package org.beetl.core.engine;

import java.io.Reader;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.statement.Program;

public class FastRuntimeEngine extends DefaultTemplateEngine {

	@Override
	public Program createProgram(Resource rs, Reader reader, Map<Integer, String> textMap, String cr,
			GroupTemplate gt) {

		return super.createProgram(rs, reader, textMap, cr, gt);
	}

}
