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
package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.GrammarToken;
import org.beetl.core.statement.IGoto;
import org.beetl.core.statement.IVarIndex;

/** 结合AntlrProgramBuilder 将模板生成Program，该类负责记录变量定义的位置和出现的位置
 * @author joelli
 *
 */
public class ProgramBuilderContext
{
	// 程序根
	BlockEnvContext root = new BlockEnvContext();
	// 当前block
	BlockEnvContext current = root;

	boolean isSafeOutput = false;
	// 节点运算辅助对象
	List<Object> listNodeEval = new LinkedList<Object>();
	// 全局变量名以及描述
	Map<String, VarDescrption> globalVar = new HashMap<String, VarDescrption>();
	Map<String, String[]> globaVarAttr = new HashMap<String, String[]>();

	// 为所有变量分配的空间长度
	int varIndexSize = 0;
	// 全局变量在空间中的位置
	public Map<String, Integer> globalIndexMap = new HashMap<String, Integer>();

	/**
	 *  顶级变量在空间中的位置
	 */
	public Map<String, Integer> rootIndexMap = new HashMap<String, Integer>();

	/**
	 * 进入一个scope
	 */
	public void enterBlock()
	{
		BlockEnvContext blockVar = new BlockEnvContext();
		blockVar.setParent(current);
		current = blockVar;
	}

	public void exitBlock()
	{
		current = current.parent;
	}

	public void addVarAndPostion(ASTNode first)
	{
		this.addVar(first.token.text);
		this.setVarPosition(first.token.text, first);
	}

	/**在当前context定义变量
	 * @param varName
	 */
	public void addVar(String varName)
	{
		VarDescrption varDesc = new VarDescrption();
		varDesc.setVarName(varName);
		this.current.getVars().put(varName, varDesc);
	}

	/**
	 * 变量属性，展示没用上，本来想用在ide属性提示
	 * @param varName
	 * @param attrName
	 */
	public void setVarAttr(String varName, String attrName)
	{
		VarDescrption varDesc = findVar(varName);
		varDesc.attrList.add(attrName);
	}

	public void setVarPosition(String varName, ASTNode where)
	{
		VarDescrption varDesc = findVar(varName);
		varDesc.where.add(where);
	}

	protected GrammarToken hasDefined(String varName)
	{
		BlockEnvContext scope = current;
		while (scope != null)
		{
			VarDescrption varDesc = scope.getVarDescrption(varName);
			if (varDesc != null)
			{
				return varDesc.where.get(0).token;
			}
			else
			{
				scope = scope.parent;
			}
		}
		return null;
	}

	protected VarDescrption findVar(String varName)
	{
		BlockEnvContext scope = current;
		while (scope != null)
		{
			VarDescrption varDesc = scope.getVarDescrption(varName);
			if (varDesc != null)
			{
				return varDesc;
			}
			else
			{
				scope = scope.parent;
			}
		}

		// 未发现，是模板全局变量
		VarDescrption desc = globalVar.get(varName);
		if (desc == null)
		{
			desc = new VarDescrption();
			globalVar.put(varName, desc);
		}

		return desc;

	}

	public int setNodeEvalObject(Object o)
	{
		listNodeEval.add(o);
		return listNodeEval.size() - 1;
	}

	public void anzlyszeGlobal()
	{
		int index = 0;
		for (Entry<String, VarDescrption> entry : globalVar.entrySet())
		{
			globalIndexMap.put(entry.getKey(), index);

			VarDescrption vd = entry.getValue();
			String[] attrs = vd.attrList.toArray(new String[0]);
			globaVarAttr.put(entry.getKey(), attrs);
			for (ASTNode node : vd.where)
			{
				((IVarIndex) node).setVarIndex(index);
			}
			index++;
		}
	}

	public void anzlyszeLocal()
	{
		anzlysze(this.root, this.globalVar.size(), true);
	}

	private void anzlysze(BlockEnvContext block, int nextIndex, boolean isRoot)
	{

		for (Entry<String, VarDescrption> entry : block.vars.entrySet())
		{
			VarDescrption vd = entry.getValue();
			// 暂时不考虑变量有可能没有被引用，（for 循环中的状态变量），因此不需要分配空间
			// if (!vd.where.isEmpty()) {
			for (ASTNode node : vd.where)
			{
				((IVarIndex) node).setVarIndex(nextIndex);
				if (isRoot)
				{
					this.rootIndexMap.put(vd.getVarName(), nextIndex);
				}
			}
			nextIndex++;
			// }

		}
		varIndexSize = Math.max(varIndexSize, nextIndex);

		for (BlockEnvContext subBlock : block.blockList)
		{
			anzlysze(subBlock, nextIndex, false);
			int inc = subBlock.vars.size();
			varIndexSize = Math.max(varIndexSize, nextIndex + inc);
		}

	}

}

class BlockEnvContext
{
	Map<String, VarDescrption> vars = new TreeMap<String, VarDescrption>();
	// chidren
	List<BlockEnvContext> blockList = new ArrayList<BlockEnvContext>();
	BlockEnvContext parent = null;
	int gotoValue = IGoto.NORMAL;

	boolean canStopContinueBreakFlag = false;

	public Map<String, VarDescrption> getVars()
	{
		return vars;
	}

	public void setVars(Map<String, VarDescrption> vars)
	{
		this.vars = vars;
	}

	public List<BlockEnvContext> getBlockList()
	{
		return blockList;
	}

	public void setBlockList(List<BlockEnvContext> blockList)
	{
		this.blockList = blockList;
	}

	public BlockEnvContext getParent()
	{
		return parent;
	}

	public void setParent(BlockEnvContext parent)
	{
		this.parent = parent;
		parent.blockList.add(this);
	}

	public VarDescrption getVarDescrption(String varName)
	{
		return vars.get(varName);
	}

	public String toString()
	{

		StringBuilder sb = new StringBuilder();

		sb.append(vars.toString());

		for (BlockEnvContext block : blockList)
		{
			sb.append(block).append("\n");
		}

		return sb.append("\n").toString();
	}

}

class VarDescrption
{

	String varName;
	Set<String> attrList = new HashSet<String>();
	List<ASTNode> where = new ArrayList<ASTNode>();

	public String getVarName()
	{
		return varName;
	}

	public void setVarName(String varName)
	{
		this.varName = varName;
	}

	public Set<String> getAttrList()
	{
		return attrList;
	}

	public void setAttrList(Set<String> attrList)
	{
		this.attrList = attrList;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("").append(attrList).append("\n");
		sb.append("where:");
		;
		for (ASTNode w : where)
		{
			sb.append("索引：").append(((IVarIndex) w).getVarIndex()).append(",").append(w.token.line).append("行");
			sb.append(";");
		}
		sb.append("\n");
		return sb.toString();
	}

}
