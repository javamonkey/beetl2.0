package org.beetl.core.engine;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Listener;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.BlockStatement;
import org.beetl.core.statement.Statement;

/**
 * @author joelli 遍历语句，如果找到匹配的，执行相应的listeners方法
 * 
 */
public class StatementParser
{

	Map<Class, Listener> listeners = new HashMap<Class, Listener>();
	BlockStatement block = null;
	Map firstNode = new HashMap(2);

	public StatementParser(Statement[] sts, GroupTemplate gt, String resourceId)
	{
		block = new BlockStatement(sts, null);
		firstNode.put("groupTemplate", gt);
		firstNode.put("resourceId", resourceId);
	}

	public void addListener(Class c, Listener ls)
	{
		listeners.put(c, ls);
	}

	public void parse()
	{
		Stack<Object> stack = new Stack<Object>();
		stack.push(firstNode);
		Class[] matchClasses = listeners.keySet().toArray(new Class[0]);

		this.exec(block, matchClasses, stack);
		//		System.out.println("stack=" + stack.size());

	}

	protected boolean match(Class astNodeType, Class[] matchClasses)
	{

		for (Class expected : matchClasses)
		{
			if (expected == astNodeType)
			{
				return true;
			}
		}
		return false;
	}

	protected void exec(Object astNode, Class[] matchClasses, Stack stack)
	{

		stack.push(astNode);
		Class astNodeClass = astNode.getClass();
		Field[] fields = astNodeClass.getFields();
		for (Field f : fields)
		{
			if (f.getModifiers() != Modifier.PUBLIC)
				continue;

			Class target = null;
			Class c = f.getType();
			if (c.isArray())
			{
				target = c.getComponentType();
			}
			else
			{
				target = c;
			}
			// 只解析含有ASTNode的字段
			if (!ASTNode.class.isAssignableFrom(target))
				continue;

			Object values;
			try
			{
				//需要判断的节点
				values = f.get(astNode);

				if (values == null)
					continue;
				//具体类型
				Class target2 = values.getClass();
				if (target2.isArray())
				{
					Object[] array = (Object[]) values;
					if (array.length == 0)
						continue;
					for (int i = 0; i < array.length; i++)
					{
						Object item = array[i];
						if (item == null)
							continue;
						Class target3 = item.getClass();
						if (match(target3, matchClasses))
						{
							stack.push(item);
							Listener ls = this.listeners.get(target3);
							NodeEvent e = new NodeEvent(stack);
							Object newASTNode = ls.onEvent(e);
							if (newASTNode != null)
							{
								stack.pop();
								stack.push(newASTNode);
								//替换原有节点
								array[i] = newASTNode;
								item = newASTNode;
							}
							// 继续遍历子节点
							this.exec(item, matchClasses, stack);
							stack.pop();
						}
						else
						{
							ASTNode node = (ASTNode) item;
							this.exec(node, matchClasses, stack);
						}

					}

				}
				else
				{
					if (match(target2, matchClasses))
					{
						stack.push(values);
						Listener ls = this.listeners.get(target2);
						NodeEvent e = new NodeEvent(stack);
						Object newASTNode = ls.onEvent(e);
						if (newASTNode != null)
						{
							stack.pop();
							stack.push(newASTNode);
							//替换原有节点
							try
							{
								f.set(astNode, newASTNode);
							}
							catch (Exception ex)
							{
								BeetlException be = new BeetlException(BeetlException.ERROR, "替换ASTNode错", ex);
								be.pushToken(((ASTNode) newASTNode).token);
								throw be;
							}

							values = newASTNode;
						}
						this.exec(values, matchClasses, stack);
						stack.pop();
						continue;
					}
					else
					{
						ASTNode node = (ASTNode) values;
						this.exec(node, matchClasses, stack);
					}

				}
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}

		}

		stack.pop();

	}
}
