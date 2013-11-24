package org.beetl.core.statement;

public class Token {
	public int line;
	public String text;
	public Token(String text,int line){
		this.text = text;
		this.line = line;
	}
}
