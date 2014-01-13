package org.beetl.core;

import java.io.IOException;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.beetl.core.parser.BeetlLexer;
import org.beetl.core.parser.BeetlParser;
import org.beetl.core.parser.BeetlParser.ProgContext;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.ProgramMetaData;

public class DefaultTemplateEngine implements TemplateEngine {

	@Override
	public Program createProgram(String id, Reader reader, GroupTemplate gt) {
		ANTLRInputStream input;
		try {
			input = new ANTLRInputStream(reader);
		} catch (IOException e) {
			// 不可能发生
			throw new RuntimeException(e);
		}
		BeetlLexer lexer = new BeetlLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		BeetlParser parser = new BeetlParser(tokens);
		ProgContext tree = parser.prog(); // begin parsing at init rule
		AntlrProgramBuilder pb = new AntlrProgramBuilder();
		ProgramMetaData data = pb.build(tree);
		Program program = new Program();
		program.metaData = data;
		program.id = id;
		program.groupTempalte = gt;
		return program;
	}

}
