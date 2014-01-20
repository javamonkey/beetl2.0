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
import org.beetl.core.statement.IGoto;
import org.beetl.core.statement.IVarIndex;

public class ProgramBuilderContext {
	// 程序根
	BlockEnvContext root = new BlockEnvContext();
	// 当前block
	BlockEnvContext current = root;
	// 节点运算辅助对象
	List<Object> listNodeEval = new LinkedList<Object>();
	// 全局变量名以及描述
	Map<String, VarDescrption> globalVar = new HashMap<String, VarDescrption>();
	Map<String, String[]> globaVarAttr = new HashMap<String, String[]>();

	// 为所有变量分配的空间长度
	int varIndexSize = 0;
	// 全局变量在空间中的位置
	public Map<String, Integer> globalIndexMap = new HashMap<String, Integer>();

	public void enterBlock() {
		BlockEnvContext blockVar = new BlockEnvContext();
		blockVar.setParent(current);
		current = blockVar;
	}

	public void exitBlock() {
		current = current.parent;
	}

	public void addVarAndPostion(ASTNode first) {
		this.addVar(first.token.text);
		this.setVarPosition(first.token.text, first);
	}

	public void addVar(String varName) {
		VarDescrption varDesc = new VarDescrption();
		varDesc.setVarName(varName);
		this.current.getVars().put(varName, varDesc);
	}

	public void setVarAttr(String varName, String attrName) {
		VarDescrption varDesc = findVar(varName);
		varDesc.attrList.add(attrName);
	}

	public void setVarPosition(String varName, ASTNode where) {
		VarDescrption varDesc = findVar(varName);
		varDesc.where.add(where);
	}

	protected VarDescrption findVar(String varName) {
		BlockEnvContext scope = current;
		while (scope != null) {
			VarDescrption varDesc = scope.getVarDescrption(varName);
			if (varDesc != null) {
				return varDesc;
			} else {
				scope = scope.parent;
			}
		}

		// 未发现，是模板全局变量
		VarDescrption desc = globalVar.get(varName);
		if (desc == null) {
			desc = new VarDescrption();
			globalVar.put(varName, desc);
		}

		return desc;

	}

	public int setNodeEvalObject(Object o) {
		listNodeEval.add(o);
		return listNodeEval.size() - 1;
	}

	public void anzlyszeGlobal() {
		int index = 0;
		for (Entry<String, VarDescrption> entry : globalVar.entrySet()) {
			globalIndexMap.put(entry.getKey(), index);

			VarDescrption vd = entry.getValue();
			String[] attrs = vd.attrList.toArray(new String[0]);
			globaVarAttr.put(entry.getKey(), attrs);
			for (ASTNode node : vd.where) {
				((IVarIndex) node).setVarIndex(index);
			}
			index++;
		}
	}

	public void anzlyszeLocal() {
		anzlysze(this.root, this.globalVar.size());
	}

	private void anzlysze(BlockEnvContext block, int nextIndex) {

		for (Entry<String, VarDescrption> entry : block.vars.entrySet()) {
			VarDescrption vd = entry.getValue();
			// 暂时不考虑变量有可能没有被引用，（for 循环中的状态变量），因此不需要分配空间
			// if (!vd.where.isEmpty()) {
			for (ASTNode node : vd.where) {
				((IVarIndex) node).setVarIndex(nextIndex);
			}
			nextIndex++;
			// }

		}
		varIndexSize = Math.max(varIndexSize, nextIndex);

		for (BlockEnvContext subBlock : block.blockList) {
			anzlysze(subBlock, nextIndex);
			int inc = subBlock.vars.size();
			varIndexSize = Math.max(varIndexSize, nextIndex + inc);
		}

	}

}

class BlockEnvContext {
	Map<String, VarDescrption> vars = new TreeMap<String, VarDescrption>();
	// chidren
	List<BlockEnvContext> blockList = new ArrayList<BlockEnvContext>();
	BlockEnvContext parent = null;
	int gotoValue = IGoto.NORMAL;

	public Map<String, VarDescrption> getVars() {
		return vars;
	}

	public void setVars(Map<String, VarDescrption> vars) {
		this.vars = vars;
	}

	public List<BlockEnvContext> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<BlockEnvContext> blockList) {
		this.blockList = blockList;
	}

	public BlockEnvContext getParent() {
		return parent;
	}

	public void setParent(BlockEnvContext parent) {
		this.parent = parent;
		parent.blockList.add(this);
	}

	public VarDescrption getVarDescrption(String varName) {
		return vars.get(varName);
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(vars.toString());

		for (BlockEnvContext block : blockList) {
			sb.append(block).append("\n");
		}

		return sb.append("\n").toString();
	}

}

class VarDescrption {

	String varName;
	Set<String> attrList = new HashSet<String>();
	List<ASTNode> where = new ArrayList<ASTNode>();

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public Set<String> getAttrList() {
		return attrList;
	}

	public void setAttrList(Set<String> attrList) {
		this.attrList = attrList;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("").append(attrList).append("\n");
		sb.append("where:");
		;
		for (ASTNode w : where) {
			sb.append(((IVarIndex) w).getVarIndex()).append(",")
					.append(w.token.line);
			sb.append(";");
		}
		sb.append("\n");
		return sb.toString();
	}

}
