package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.IVarIndex;


public class ProgramBuilderContext {

}

class BlockVar {
	Map<String, VarDescrption> vars = new HashMap<String, VarDescrption>();
	//chidren
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
		if (vars.containsKey(varName)) {
			return vars.get(varName);
		} else if (parent != null) {
			return parent.getVarDescrption(varName);
		} else {
			return null;
		}
	}
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(vars.toString());
		
		for(BlockVar block:blockList){
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

	public Set<String>  getAttrList() {
		return attrList;
	}

	public void setAttrList(Set<String>  attrList) {
		this.attrList = attrList;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();			
		sb.append("").append(attrList).append("\n");
		sb.append("where:");;
		for(ASTNode w:where){
			sb.append(((IVarIndex)w).getVarIndex()).append(",").append(w.token.line);
			sb.append(";");
		}
		sb.append("\n");
		return sb.toString();
	}

}
