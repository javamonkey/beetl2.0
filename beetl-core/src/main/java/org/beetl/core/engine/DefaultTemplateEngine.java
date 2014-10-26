package org.beetl.core.engine;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.beetl.core.AntlrProgramBuilder;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Resource;
import org.beetl.core.TemplateEngine;
import org.beetl.core.parser.BeetlAntlrErrorStrategy;
import org.beetl.core.parser.BeetlLexer;
import org.beetl.core.parser.BeetlParser;
import org.beetl.core.parser.BeetlParser.ProgContext;
import org.beetl.core.parser.SyntaxErrorListener;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.ProgramMetaData;

public class DefaultTemplateEngine implements TemplateEngine
{

	BeetlAntlrErrorStrategy antlrErrorStrategy = new BeetlAntlrErrorStrategy();
	SyntaxErrorListener syntaxError = new SyntaxErrorListener();

	@Override
	public Program createProgram(Resource resource, Reader reader, Map<Integer, String> textMap, String cr,
			GroupTemplate gt)
	{
		ANTLRInputStream input;
		try
		{
			input = new ANTLRInputStream(reader);
		}
		catch (IOException e)
		{
			// 不可能发生
			throw new RuntimeException(e);
		}
		BeetlLexer lexer = new BeetlLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(syntaxError);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		BeetlParser parser = new BeetlParser(tokens);
		//测试代码
		parser.setErrorHandler(antlrErrorStrategy);

		//

		ProgContext tree = parser.prog();

		// begin parsing at init rule
		AntlrProgramBuilder pb = new AntlrProgramBuilder(gt);
		ProgramMetaData data = pb.build(tree);
		Program program = new Program();
		program.metaData = data;
		program.res = resource;
		program.rs = resource;
		program.gt = gt;

		program.metaData.staticTextArray = new Object[textMap.size()];
		program.metaData.lineSeparator = cr;
		int i = 0;
		Configuration conf = gt.getConf();
		String charset = conf.getCharset();
		boolean byteOut = conf.isDirectByteOutput();
		for (Entry<Integer, String> entry : textMap.entrySet())
		{
			if (byteOut)
			{
				try
				{
					program.metaData.staticTextArray[i++] = entry.getValue().getBytes(charset);
				}
				catch (UnsupportedEncodingException e)
				{
					throw new RuntimeException(e);
				}
			}
			else
			{

				program.metaData.staticTextArray[i++] = entry.getValue().toCharArray();

			}

		}

		return program;
	}
}
