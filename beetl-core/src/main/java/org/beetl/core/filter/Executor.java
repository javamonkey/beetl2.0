package org.beetl.core.filter;

import java.util.Stack;

import org.beetl.core.statement.ASTNode;

public interface Executor
{
	/** 处理节点，开发者应该首先peek出当前节点，然后对节点进行修改，如果要替换节点，可以返回一个新的ASTNode节点
	 * StatementSearcher会用此新节点替换就的节点
	 * @param stack
	 * @return
	 */
	public ASTNode on(Stack<ASTNode> stack);
}
