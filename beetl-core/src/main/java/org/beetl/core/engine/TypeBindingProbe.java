package org.beetl.core.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.ProgramMetaData;
import org.beetl.core.statement.Statement;
import org.beetl.core.statement.Type;

/**
 * 内置fitler，对模板进行类型推测
 * 
 * @author joelli
 * 
 */
public class TypeBindingProbe extends Probe
{
	boolean isCompleted = false;
	Type[] types = null;
	ProgramMetaData copyProgramMetaData = null;
	Probe nextFilter = null;
	Map<Integer, String> globalIndex = new HashMap<Integer, String>();

	public TypeBindingProbe(Program p, Probe nextFilter)
	{
		super();
		this.setProgram(p);
		// 一个新的copy，用于分析
		ProgramMetaData metaData = p.metaData;

		this.nextFilter = nextFilter;
		for (Entry<String, Integer> entry : this.program.metaData.globalIndexMap.entrySet())
		{
			globalIndex.put(entry.getValue(), entry.getKey());
		}

		types = new Type[program.metaData.varIndexSize];
		//对type类型做设定
		if (metaData.allDynamic)
		{
			for (int i = 0; i < types.length; i++)
			{
				types[i] = Type.ObjectType;
			}
		}

		if (metaData.dynamicObjectSet.size() != 0)
		{
			for (String varName : metaData.dynamicObjectSet)
			{
				Integer index = metaData.globalIndexMap.get(varName);
				if (index != null)
				{
					types[index] = Type.ObjectType;
				}

			}
		}

		if (metaData.globalType.size() != 0)
		{
			for (Entry<String, Type> entry : metaData.globalType.entrySet())
			{
				String varName = entry.getKey();
				Type type = entry.getValue();
				Integer index = metaData.globalIndexMap.get(varName);
				if (index != null)
				{
					types[index] = type;
				}
				//不抛错，允许这种情况出现
			}
		}

	}

	public TypeBindingProbe copy()
	{

		return this;
	}

	public Program getCopyProgram()
	{
		return this.program;
	}

	@Override
	public void check(Context ctx)
	{
		if (isCompleted)
			return;

		int y = 0;
		for (int i = 0; i < program.metaData.tempVarStartIndex; i++)
		{
			if (types[i] == null)
			{
				if (ctx.vars[i] != ctx.NOT_EXIST_OBJECT && ctx.vars[i] != null)
				{
					Object o = ctx.vars[i];
					if (isDynamicObject(ctx, i))
					{
						types[i] = Type.ObjectType;
						y++;
						continue;
					}

					Type c = getType(o);
					if (c == null)
						continue;
					else
					{
						types[i] = c;
						y++;
					}
				}
				else
				{
					continue;
				}

			}
			else
			{
				y++;
			}
		}
		// 推测完毕
		if (y == program.metaData.tempVarStartIndex)
		{
			try
			{
				infer();
				isCompleted = true;
				// 调用下一个filter
				nextFilter.setProgram(this.program);
				nextFilter.check(ctx);
			}
			catch (BeetlException bex)
			{
				//	bex.printStackTrace();
				ProgramReplaceErrorEvent event = new ProgramReplaceErrorEvent(program.res.getId(), bex.getMessage(),
						bex);
				program.gt.fireEvent(event);
				isCompleted = true;
			}

		}
	}

	/**
	 * 确定表达式的类型
	 */
	protected void infer()
	{

		InferContext ctx = new InferContext();
		ctx.types = types;
		ctx.gt = this.program.gt;
		for (Statement st : this.program.metaData.statements)
		{
			st.infer(ctx);
		}

	}

	private boolean isDynamicObject(Context ctx, int index)
	{
		String varName = this.globalIndex.get(index);

		return ctx.objectKeys != null && ctx.objectKeys.contains(varName);
	}

	private Type getType(Object c)
	{
		Type type = null;
		;
		if (c instanceof Map)
		{
			Map<Object, Object> map = (Map<Object, Object>) c;
			for (Entry<Object, Object> entry : map.entrySet())
			{

				Object key = entry.getKey();
				Object value = entry.getValue();
				if(key==null||value==null) return null;
				if (value != null)
				{
					type = new Type(Map.class, key.getClass(), value.getClass());
					return type;
				}

			}
			// 没有足够信息，还需要推测
			return null;
		}
		else if (c instanceof List)
		{
			List<Object> list = (List<Object>) c;
			for (Object o : list)
			{
				if (o != null)
				{

					type = new Type(List.class, o.getClass());
					return type;
				}
			}
			// 没有足够信息
			return null;
		}
		else if (c.getClass().isArray())
		{
			// Class probableType = c.getClass()
			type = new Type(c.getClass(), c.getClass().getComponentType());
			return type;
		}
		else
		{
			return new Type(c.getClass());
		}
	}
}
