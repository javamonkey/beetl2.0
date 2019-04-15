package org.beetl.core.engine;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.CharStreams;
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
import org.beetl.core.statement.AjaxStatement;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.ProgramMetaData;

public class DefaultTemplateEngine implements TemplateEngine {

	protected BeetlAntlrErrorStrategy antlrErrorStrategy = new BeetlAntlrErrorStrategy();
	protected SyntaxErrorListener syntaxError = new SyntaxErrorListener();

	@Override
	public Program createProgram(Resource resource, Reader reader, Map<Integer, String> textMap, String cr,
			GroupTemplate gt) {
		
		BeetlLexer lexer = null;;
		try {
			lexer = new BeetlLexer(CharStreams.fromReader(reader));
		} catch (IOException e1) {
			// 不可能发生，
			throw new IllegalStateException(e1);
		}
		lexer.removeErrorListeners();
		lexer.addErrorListener(syntaxError);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		BeetlParser parser = new BeetlParser(tokens);
		// 测试代码
		parser.setErrorHandler(antlrErrorStrategy);

		//

		ProgContext tree = parser.prog();

		// begin parsing at init rule
		AntlrProgramBuilder pb = getAntlrBuilder(gt);
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
		for (Entry<Integer, String> entry : textMap.entrySet()) {
			if (byteOut) {
				try {
					program.metaData.staticTextArray[i++] = entry.getValue().getBytes(charset);
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			} else {

				program.metaData.staticTextArray[i++] = entry.getValue().toCharArray();

			}

		}

		if(program.metaData.ajaxs!=null) {
			//如果ajax内容
			for(AjaxStatement ajax:program.metaData.ajaxs.values()){
				ProgramMetaData locaMetaData = ajax.getLocalProgramMetaData();
				locaMetaData.staticTextArray = program.metaData.staticTextArray;
				locaMetaData.lineSeparator = cr;
			}
		}
		

		return program;
	}
	
	/**
	 *  子类可以加工Program，修改或者添加包括静态文本或者Statement语句
	 * @param program
	 */
	protected void checkProgram(Program program){
		
	}

	/**
	 *  获取一个beetl模板的解析器，子类可以扩展
	 * @param gt
	 * @return
	 */
	protected AntlrProgramBuilder getAntlrBuilder(GroupTemplate gt) {
		GrammarCreator gc = this.getGrammerCreator(gt);
		AntlrProgramBuilder pb = new AntlrProgramBuilder(gt, gc);
		return pb;
	}
	
	
	/**
	 * 语法节点生成器，子类可以扩展射生成自己个性化节点解析，比如带有xss的输出的${}，限制循环个数的for语法
	 * @param gt
	 * @return
	 */
	protected GrammarCreator getGrammerCreator(GroupTemplate gt) {
		GrammarCreator grammar = new GrammarCreator();
		if (gt.getConf().isStrict()) {
			// 严格MVC 不允许很多语法，跟逻辑相关的
			grammar.disable("VarAssign");
			grammar.disable("Function");
			grammar.disable("IncDec");
			grammar.disable("VarRefAssignExp");
			grammar.disable("VarRefAssign");
			grammar.disable("ClassNativeCall");
			grammar.disable("InstanceNativeCall");
			grammar.disable("Arth");
			grammar.disable("Compare");
			grammar.disable("InstanceNativeCall");

		}
		return grammar;
	}
}
