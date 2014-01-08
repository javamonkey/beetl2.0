package org.beetl.core.filter;

import java.util.Stack;

import org.beetl.core.Context;
import org.beetl.core.attr.AA;
import org.beetl.core.attr.AAFactory;
import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.Type;
import org.beetl.core.statement.VarAttribute;
import org.beetl.core.statement.VarRef;

public class AAFilter extends Filter implements Executor {

	public AAFilter(Program program) {
		super(program);
	}

	@Override
	public void check(Context ctx) {
		StatementSeacher seacher = new StatementSeacher();
		Class[] matchClasses = new Class[] { VarRef.class };
		seacher.match(program.metaData.statements, matchClasses, this);

	}

	@Override
	public boolean on(Stack<ASTNode> stack) {
		Object o = stack.peek();
		VarRef ref = (VarRef) o;
		VarAttribute[] attrs = ref.attributes;
		for (VarAttribute attr : attrs) {
			Type type = attr.type;
			String name = attr.token != null ? attr.token.text : null;
			// 换成速度较快的属性访问类
			AA aa = AAFactory.buildFiledAccessor(type.cls, name);
			attr.aa = aa;

		}
		return false;
	}

}
