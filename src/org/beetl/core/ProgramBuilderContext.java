package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.IVarIndex;

public class ProgramBuilderContext {
	// 程序根
	BlockVar root = new BlockVar();
	// 当前block
	BlockVar current = root;
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
		BlockVar blockVar = new BlockVar();
		blockVar.setParent(current);
		current = blockVar;
	}

	public void exitBlock() {
		current = current.parent;
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
		BlockVar scope = current;
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

	private void anzlysze(BlockVar block, int nextIndex) {

		for (Entry<String, VarDescrption> entry : block.vars.entrySet()) {
			VarDescrption vd = entry.getValue();
			// 变量有可能没有被引用，（for 循环中的状态变量），因此不需要分配空间
			if (!vd.where.isEmpty()) {
				for (ASTNode node : vd.where) {
					((IVarIndex) node).setVarIndex(nextIndex);
				}
				nextIndex++;
			}

		}
		varIndexSize = Math.max(varIndexSize, nextIndex);

		for (BlockVar subBlock : block.blockList) {
			anzlysze(subBlock, nextIndex);
			int inc = subBlock.vars.size();
			varIndexSize = Math.max(varIndexSize, nextIndex + inc);
		}

	}

}

class BlockVar {
	Map<String, VarDescrption> vars = new HashMap<String, VarDescrption>();
	// chidren
	List<BlockVar> blockList = new ArrayList<BlockVar>();
	BlockVar parent = null;

	public Map<String, VarDescrption> getVars() {
		return vars;
	}

	public void setVars(Map<String, VarDescrption> vars) {
		this.vars = vars;
	}

	public List<BlockVar> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<BlockVar> blockList) {
		this.blockList = blockList;
	}

	public BlockVar getParent() {
		return parent;
	}

	public void setParent(BlockVar parent) {
		this.parent = parent;
	}

	public VarDescrption getVarDescrption(String varName) {
		return vars.get(varName);
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(vars.toString());

		for (BlockVar block : blockList) {
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
