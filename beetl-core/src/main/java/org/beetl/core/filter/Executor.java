package org.beetl.core.filter;

import java.util.Stack;

import org.beetl.core.statement.ASTNode;

public interface Executor
{
	public void on(Stack<ASTNode> stack);
}
