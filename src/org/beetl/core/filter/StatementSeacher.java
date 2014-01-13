package org.beetl.core.filter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Stack;

import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.BlockStatement;
import org.beetl.core.statement.Statement;

/**
 * @author joelli 遍历语句，如果找到匹配的，执行executor方法
 * 
 */
public class StatementSeacher {
	public void match(Statement[] sts, Class[] matchClasses, Executor executor) {
		Stack<ASTNode> stack = new Stack<ASTNode>();
		BlockStatement block = new BlockStatement(sts, null);
		this.exec(block, matchClasses, executor, stack);
	}

	public boolean exec(Object astNode, Class[] matchClasses,
			Executor executor, Stack stack) {

		stack.push(astNode);
		Class astNodeClass = astNode.getClass();
		Field[] fields = astNodeClass.getFields();
		for (Field f : fields) {
			if (f.getModifiers() == Modifier.PUBLIC) {
				Class target = null;
				Class target2 = null;
				// Class c = f.getDeclaringClass();
				Class c = f.getType();
				if (c.isArray()) {
					target = c.getComponentType();
				} else {
					target = c;
				}
				boolean isArray = false;

				// 只解析含有ASTNode的字段
				if (ASTNode.class.isAssignableFrom(target)) {
					Object values;
					try {
						values = f.get(astNode);

						if (values == null)
							continue;
						else {
							target2 = values.getClass();
							if (target2.isArray()) {

								isArray = true;
							}
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}

					for (Class expected : matchClasses) {
						// 如果匹配上
						if (expected == target2) {
							if (isArray) {
								Object[] targetValue = (Object[]) values;
								for (Object o : targetValue) {
									if (o == null)
										continue;
									stack.push(o);
									if (executor.on(stack)) {
										return true;
									}
									stack.pop();
								}
							} else {
								stack.push(values);
								if (executor.on(stack)) {
									return true;
								}
								stack.pop();
							}

						} else {
							// 没有匹配上，继续遍历
							if (isArray) {
								ASTNode[] astNodes = (ASTNode[]) values;
								for (ASTNode node : astNodes) {
									if (this.exec(node, matchClasses, executor,
											stack)) {
										return true;
									}
								}
							} else {
								ASTNode node = (ASTNode) values;
								if (this.exec(node, matchClasses, executor,
										stack)) {
									return true;
								}
							}

						}
					}
				}

			}

		}
		stack.pop();
		return false;
	}

	public void match(Statement st, Class cls, Executor executor) {
		this.match(new Statement[] { st }, new Class[] { cls }, executor);
	}
}
