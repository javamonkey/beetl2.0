package org.beetl.core.lab;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.beetl.core.BeetlScriptParserListener;
import org.beetl.core.parser.BeetlLexer;
import org.beetl.core.parser.BeetlParser;

/**
 * 测试模板语法
 * @author joelli
 *
 */
public class GrammerTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader reader = new InputStreamReader(GrammerTest.class.getResourceAsStream("/org/beetl/core/lab/grammer.txt"),"utf-8");
		
		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(reader);
		// create a lexer that feeds off of input CharStream
		BeetlLexer lexer = new BeetlLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		BeetlParser parser = new BeetlParser(tokens);
		ParseTree tree = parser.prog(); // begin parsing at init rule
		ParseTreeWalker walker = new ParseTreeWalker();
		BeetlScriptParserListener parserLitener = new BeetlScriptParserListener();
		walker.walk(parserLitener, tree);
		parserLitener.anzlysze();
		//System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
	}
}
