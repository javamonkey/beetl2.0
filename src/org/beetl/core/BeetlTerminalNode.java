package org.beetl.core;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

public class BeetlTerminalNode implements TerminalNode {

	TerminalNode original = null;
	//索引，变量的位置
	private int index;
	//缓存对象，比如方法节点对应的native实际的的Method
	private Object cache = null;
	public BeetlTerminalNode(TerminalNode original){
		this.original = original;
	}
	
	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public Object getCache() {
		return cache;
	}


	public void setCache(Object cache) {
		this.cache = cache;
	}


	@Override
	public ParseTree getParent() {
		return original.getParent();
	}

	@Override
	public ParseTree getChild(int i) {
		return original.getChild(i);
	}

	@Override
	public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
		return original.accept(visitor);
	}

	@Override
	public String getText() {
		return original.getText();
	}

	@Override
	public String toStringTree(Parser parser) {
		return original.toStringTree();
	}

	@Override
	public Interval getSourceInterval() {
		return original.getSourceInterval();
	}

	@Override
	public Object getPayload() {
		return original.getPayload();
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return original.getChildCount();
	}

	@Override
	public String toStringTree() {
		// TODO Auto-generated method stub
		return original.toStringTree();
	}

	@Override
	public Token getSymbol() {
		// TODO Auto-generated method stub
		return original.getSymbol();
	}
	
	public String toString(){
		return "行："+getSymbol().getLine()+" index:"+index;
	}

}
