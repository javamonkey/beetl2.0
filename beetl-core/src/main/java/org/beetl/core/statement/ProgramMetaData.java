package org.beetl.core.statement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.beetl.core.Context;
import org.beetl.core.util.ObjectUtil;

public class ProgramMetaData implements java.io.Serializable
{

	public String lineSeparator = null;

	public Statement[] statements = null;

	// 模板静态数据
	public Object[] staticTextArray = null;

	// 所有变量存放在数组中，数组长度为varIndexSize
	public int varIndexSize = 0;
	public int tempVarStartIndex = 0;
	// 为全局变量在数组里分配的位置
	public Map<String, Integer> globalIndexMap = new HashMap<String, Integer>();
	// 全局变量属性
	public Map<String, String[]> globalVarAttr = new HashMap<String, String[]>();
	//directive dynamic ;
	public boolean allDynamic = false;
	//directive dynamic xx,bb,cc
	public Set<String> dynamicObjectSet = new HashSet<String>(0);
	//@type(User cc,List<User> list)
	public Map<String, Type> globalType = new HashMap<String, Type>(0);

	public void initContext(Context ctx)
	{
		// 模板静态文本部分
		ctx.staticTextArray = staticTextArray;
		// 模板各种缓存存放地

		// 临时标量所在空间
		ctx.tempVarStartIndex = tempVarStartIndex;
		// 分配变量空间
		ctx.vars = new Object[varIndexSize];

		// 将全局变量放到数组
		putGlobaToArray(ctx);

	}

	public void replaceGlobal(Context ctx)
	{
		putGlobaToArray(ctx);

	}

	/**
	 * 重用此类，仅仅全局变量需要赋值
	 * 
	 * @param ctx
	 */
	public void initContextAgain(Context ctx)
	{
		this.putGlobaToArray(ctx);
	}

	/**
	 * 将模板全局变量转为数组
	 * 
	 * @param map
	 */
	protected void putGlobaToArray(Context ctx)
	{
		Map<String, Object> globalVar = ctx.globalVar;
		if (globalVar == null)
		{
			for (int i = 0; i < this.tempVarStartIndex; i++)
			{
				ctx.vars[i] = ctx.NOT_EXIST_OBJECT;
			}
			return;
		}

		for (Entry<String, Integer> entry : globalIndexMap.entrySet())
		{
			String key = entry.getKey();
			int index = entry.getValue();
			if (globalVar.containsKey(key))
			{
				ctx.vars[index] = globalVar.get(key);
			}
			else
			{
				// 不存在
				ctx.vars[index] = ctx.NOT_EXIST_OBJECT;
			}
		}
	}

	public ProgramMetaData copy()
	{
		ProgramMetaData newCopy = (ProgramMetaData) ObjectUtil.copy(this);
		return newCopy;
	}

}
