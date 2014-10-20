package org.beetl.core.engine;

import java.io.Reader;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.ProgramMetaData;

public class FastRuntimeEngine extends DefaultTemplateEngine
{

	@Override
	public Program createProgram(Resource rs, Reader reader, Map<Integer, String> textMap, String cr, GroupTemplate gt)
	{

		Program orginalProgram = super.createProgram(rs, reader, textMap, cr, gt);

		//copy 一个出来分析
		ProgramMetaData metaData = orginalProgram.metaData.copy();
		Program copyProgram = new Program();
		copyProgram.metaData = metaData;
		copyProgram.res = orginalProgram.res;
		copyProgram.gt = orginalProgram.gt;
		copyProgram.rs = orginalProgram.rs;
		Probe nextFilter = new BasicProgramOptProbe();
		nextFilter.setProgram(copyProgram);

		TypeBindingProbe firstFilter = new TypeBindingProbe(copyProgram, nextFilter);
		//在能优化前，按照原有的program执行，但每次都会执行fitler以看看是否能优化
		FilterProgram filterProgram = new FilterProgram(orginalProgram, copyProgram, firstFilter);
		return filterProgram;
	}

}
