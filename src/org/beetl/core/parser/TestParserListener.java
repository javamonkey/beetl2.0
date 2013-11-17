package org.beetl.core.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.beetl.core.BeetlTerminalNode;
import org.beetl.core.parser.BeetlParser.VarAttributeContext;
import org.beetl.core.parser.BeetlParser.VarAttributeGeneralContext;

public class TestParserListener extends BeetlParserBaseListener {

	BlockVar blockVar = new BlockVar();
	BlockVar currentBlockVar = blockVar;
	Map<String,VarDescrption> globalVar = new HashMap<String,VarDescrption> ();
	int varIndexSize = 0;
	
	public TestParserListener() {

	}
	

	public BlockVar getBlockVar() {
		return blockVar;
	}
	
	public void anzlysze(){
		anzlysze(blockVar,0);
		System.out.println(blockVar);
		System.out.println("=============");
		System.out.println(globalVar);
	}
	
	
	protected void anzlysze(BlockVar block,int nextIndex){
		
		
		for(Entry<String,VarDescrption> entry:block.vars.entrySet()){
			VarDescrption vd = entry.getValue();
			//变量有可能没有被引用，（for 循环中的状态变量），因此不需要分配空间
			if(!vd.where.isEmpty()){
				for(BeetlTerminalNode node:vd.where){
					node.setIndex(nextIndex);
				}
				nextIndex++;
			}
			
		}
		varIndexSize = Math.max(varIndexSize, nextIndex);
		
		for(BlockVar subBlock:block.blockList){
			anzlysze(subBlock,nextIndex);
			int inc = subBlock.vars.size();
			varIndexSize = Math.max(varIndexSize, nextIndex+inc);
		}
		
		
	}
	


	public void setBlockVar(BlockVar blockVar) {
		this.blockVar = blockVar;
	}



	public Map<String, VarDescrption> getGlobalVar() {
		return globalVar;
	}



	public void setGlobalVar(Map<String, VarDescrption> globalVar) {
		this.globalVar = globalVar;
	}



	@Override
	public void enterBlock(@NotNull BeetlParser.BlockContext ctx) {

		this.enterBlock();

	}

	@Override
	public void exitBlock(@NotNull BeetlParser.BlockContext ctx) {
		this.exitBlock();
	}

	@Override
	public void enterAssignId(@NotNull BeetlParser.AssignIdContext ctx) {

		BeetlTerminalNode node = new BeetlTerminalNode(ctx.Identifier());
		ctx.children.set(0, node);	
		analyzeAssign(node);

	}

	@Override
	public void enterAssignGeneral(@NotNull BeetlParser.AssignGeneralContext ctx) {
		Token token = ctx.Identifier().getSymbol();		
		BeetlTerminalNode node = new BeetlTerminalNode(ctx.Identifier());
		ctx.children.set(0, node);		
		analyzeAssign(node);
	}

	@Override
	public void enterAssignTemplateVar(
			@NotNull BeetlParser.AssignTemplateVarContext ctx) {
		BeetlTerminalNode node = new BeetlTerminalNode(ctx.Identifier());
		ctx.children.set(0, node);	
		analyzeAssign(node);
	}

	
	@Override
	public void enterVarRef(@NotNull BeetlParser.VarRefContext ctx) { 
		BeetlTerminalNode node = new BeetlTerminalNode(ctx.Identifier());
		ctx.children.set(0, node);
	
		Token token =node.getSymbol();	
		String varName = token.getText();		
		VarDescrption vd = currentBlockVar.getVarDescrption(varName);
		
		if(vd!=null){
			//临时变量，记录属性,为将来编译优化做准备
			vd.where.add(node);
			anzlyszeAttribute(vd,ctx);
		}else{
			//全局变量
			
			VarDescrption global  = globalVar.get(varName);
			if(global==null){
				global = new VarDescrption();
				global.varName = varName;				
				globalVar.put(varName, global);
			}
			global.where.add(node);	
			anzlyszeAttribute(global,ctx);			
		}
		
	}
	@Override
	public void enterForControl(@NotNull BeetlParser.ForControlContext ctx){
		Token token = ctx.Identifier().getSymbol();	
		BeetlTerminalNode node = new BeetlTerminalNode(ctx.Identifier());
		if(ctx.Var()==null){
			ctx.children.set(0, node);
		}else{
			ctx.children.set(1, node);
		}
		analyzeAssign(node);
		//增加for循环中额外三个变量
		String name = token.getText();
		String name_index = name+"_index";
		String name_size = name+"_size";
		String name_status = name+"LP";
		
		VarDescrption forIndex = new VarDescrption();		
		forIndex.setVarName(name_index);		
		currentBlockVar.getVars().put(name_index, forIndex);
		
		VarDescrption forSize = new VarDescrption();		
		forSize.setVarName(name_size);
		currentBlockVar.getVars().put(name_size, forSize);
		
		VarDescrption forStatus = new VarDescrption();		
		forStatus.setVarName(name_status);
		currentBlockVar.getVars().put(name_status, forStatus);
		
	}
	
	@Override 	
	public void enterSwitchBlockStatementGroup(@NotNull BeetlParser.SwitchBlockStatementGroupContext ctx) { 
		//相当于一个block
		enterBlock();
	}
	
	@Override 
	public void enterG_switchStatment(@NotNull BeetlParser.G_switchStatmentContext ctx) { 
		//相当于一个block
		enterBlock();
	}
	
	
	@Override 
	public void exitSwitchBlockStatementGroup(@NotNull BeetlParser.SwitchBlockStatementGroupContext ctx) {
		exitBlock();
	}
	
	@Override 
	
	public void exitG_switchStatment(@NotNull BeetlParser.G_switchStatmentContext ctx) { 
		exitBlock();
	}

	protected void enterBlock(){
		BlockVar newBlockVar = new BlockVar();
		newBlockVar.setParent(currentBlockVar);
		currentBlockVar.getBlockList().add(newBlockVar);
		currentBlockVar = newBlockVar;
	}
	protected void exitBlock(){
		currentBlockVar = currentBlockVar.parent;
	}


	
	protected void anzlyszeAttribute(VarDescrption vd, BeetlParser.VarRefContext ctx){
		List<VarAttributeContext>  list = ctx.varAttribute();
		if(list!=null&&list.size()!=0){
			VarAttributeContext zf = list.get(0);
			if(zf instanceof VarAttributeGeneralContext ){
				String attrName = ((VarAttributeGeneralContext)zf).Identifier().getText();
				if(!vd.attrList.contains(attrName)){
					vd.attrList.add(attrName);
				}
			}
		}
	}
	
	
	protected void analyzeAssign(BeetlTerminalNode node) {
		Token token = node.getSymbol();
		String varName = token.getText();
		VarDescrption vd = currentBlockVar.getVarDescrption(varName);
		if (vd != null) {
			throw new RuntimeException("变量重复定义:"+varName);
		}
		vd = new VarDescrption();		
		vd.setVarName(varName);
		vd.where.add(node);
		currentBlockVar.getVars().put(varName, vd);
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
		List<BeetlTerminalNode> where = new ArrayList<BeetlTerminalNode>();
		
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
			sb.append("where:").append(where).append("\n");
			return sb.toString();
		}

	}

}
