package org.beetl.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.beetl.core.exception.TempException;
import org.beetl.core.statement.IGoto;

public class Context
{

	public static Object NOT_EXIST_OBJECT = new Object();

	public ByteWriter byteWriter;
	/* 全局变量 */
	public Map<String, Object> globalVar;
	/*
	 * 内容为Object的变量，beetl要求全局变量类型总是一致，如果一个key 对应的类型不一样，则需要设置objectKeys
	 */
	public Set<String> objectKeys;

	public boolean byteOutputMode;

	// 当前会话相关变量全局变量和临时变量都放在数组里，全局变量放在前面
	public Object[] vars;

	// 这些变量来自于ProgrameMeta
	public Object[] staticTextArray;

	public int tempVarStartIndex;

	// 0 正常语句，继续执行，1 continue，2 break，3 return；
	public short gotoFlag;

	public boolean isInit;

	/**
	 * 得到临时模板变量
	 * 
	 * @param i
	 * @return
	 */
	protected Object getVar(int i)
	{
		if (i >= this.tempVarStartIndex)
			return vars[i];
		else
		{
			Object object = vars[i];
			if (object == NOT_EXIST_OBJECT)
			{
				throw new TempException("变量不存在");
			}
			else
			{
				return object;
			}
		}

	}

	/**
	 * 设置临时模板变量
	 * 
	 * @param i
	 * @param object
	 */
	protected void setVar(int i, Object value)
	{
		if (i >= this.tempVarStartIndex)
			vars[i] = value;
		else
		{
			// 可以赋值么？既然没有改变模型和controller
			throw new TempException("全局变量，不能赋值");
		}
	}

	/**
	 * 判断全局变量是否存在
	 * 
	 * @param i
	 * @return
	 */
	protected boolean exist(int i)
	{
		if (i >= this.tempVarStartIndex)
		{
			return true;
		}
		else
		{
			Object object = vars[i];
			return object != NOT_EXIST_OBJECT;
		}
	}

	public void set(String key, Object value)
	{
		if (globalVar == null)
			globalVar = new HashMap<String, Object>();
		globalVar.put(key, value);
	}

	public void set(String key, Object value, boolean isDynamicObject)
	{
		if (globalVar == null)
			globalVar = new HashMap<String, Object>();
		globalVar.put(key, value);
		if (isDynamicObject)
		{
			if (objectKeys == null)
				objectKeys = new HashSet(1);
			objectKeys.add(key);
		}
	}

	public Object getGlobal(String key)
	{
		return globalVar.get(key);
	}

	public void resetGotoFlag()
	{
		this.gotoFlag = IGoto.NORMAL;
	}

}
