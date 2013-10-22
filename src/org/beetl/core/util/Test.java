package org.beetl.core.util;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.beetl.core.parser.BeetlLexer;
import org.beetl.core.parser.BeetlParser;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str = "var a = 1;";
		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(str);
		// create a lexer that feeds off of input CharStream
		BeetlLexer lexer = new BeetlLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		BeetlParser parser = new BeetlParser(tokens);
		ParseTree tree = parser.prog(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
	}

}
