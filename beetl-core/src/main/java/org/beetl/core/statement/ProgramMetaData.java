/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.statement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.beetl.core.Context;
import org.beetl.core.om.ObjectUtil;

/**
 * 脚本的描述
 * @author joelli
 *
 */
public class ProgramMetaData implements java.io.Serializable
{

	public String lineSeparator = null;

	public Statement[] statements = null;

	// 模板静态数据
	public Object[] staticTextArray = null;

	// 所有变量存放在数组中，数组长度为varIndexSize
	public int varIndexSize = 0;
	public int tempVarStartIndex = 0;

	public boolean hasGoto = false;
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

	//模板里的顶级变量映射关系
	protected Map<String, Integer> templateRootScopeIndexMap = new HashMap<String, Integer>();

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

	public Map<String, Integer> getTemplateRootScopeIndexMap()
	{
		return templateRootScopeIndexMap;
	}

	public void setTemplateRootScopeIndexMap(Map<String, Integer> templateRootScopeIndexMap)
	{
		this.templateRootScopeIndexMap = templateRootScopeIndexMap;
	}

}
