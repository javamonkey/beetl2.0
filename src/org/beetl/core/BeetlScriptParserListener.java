package org.beetl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.beetl.core.parser.BeetlLexer;
import org.beetl.core.parser.BeetlParser;
import org.beetl.core.parser.BeetlParser.VarAttributeContext;
import org.beetl.core.parser.BeetlParser.VarAttributeGeneralContext;
import org.beetl.core.parser.BeetlParserBaseListener;

public class BeetlScriptParserListener extends BeetlParserBaseListener {

	BlockVar blockVar = new BlockVar();
	BlockVar currentBlockVar = blockVar;
	Map<String,VarDescrption> globalVar = new HashMap<String,VarDescrption> ();
	List<Object> cachedNodeArray = new ArrayList<Object>();
	
	int varIndexSize = 0;
	Map<String,Integer> globalIndexMap =  new HashMap<String,Integer>();
	
	public BeetlScriptParserListener() {

	}
	

	public BlockVar getBlockVar() {
		return blockVar;
	}
	
	public void anzlysze(){
		anzlyszeGlobal();
		anzlysze(blockVar,globalVar.size());
		
		System.out.println(blockVar);
		System.out.println("=============");
		System.out.println(globalVar);
		
	}
	
	public void anzlyszeGlobal(){
		int index = 0;
		for(Entry<String,VarDescrption> entry:globalVar.entrySet()){
			globalIndexMap.put(entry.getKey(), index);
			VarDescrption vd = entry.getValue();
			for(TerminalNode node:vd.where){
				node.setCachedIndex(index);
			}
			index++;
		}
	}
	
	
	protected void anzlysze(BlockVar block,int nextIndex){
		
		
		for(Entry<String,VarDescrption> entry:block.vars.entrySet()){
			VarDescrption vd = entry.getValue();
			//变量有可能没有被引用，（for 循环中的状态变量），因此不需要分配空间
			if(!vd.where.isEmpty()){
				for(TerminalNode node:vd.where){
					node.setCachedIndex(nextIndex);
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

		
		analyzeAssign(ctx.Identifier());

	}

	@Override
	public void enterAssignGeneral(@NotNull BeetlParser.AssignGeneralContext ctx) {
		analyzeAssign(ctx.Identifier());
	}

	@Override
	public void enterAssignTemplateVar(
			@NotNull BeetlParser.AssignTemplateVarContext ctx) {
		analyzeAssign(ctx.Identifier());
	}

	
	@Override
	public void enterVarRef(@NotNull BeetlParser.VarRefContext ctx) { 
		TerminalNode node = ctx.Identifier();
		
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
		TerminalNode node = ctx.Identifier();
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
	
	
	/*=================常量=====================*/	

	@Override public void enterLiteralExp(@NotNull BeetlParser.LiteralExpContext ctx) { 
		ParseTree tree = ctx.getChild(0).getChild(0);
		
		Object value = null;
		Token token = (Token)tree.getPayload();
		String str = token.getText();
		switch(token.getType()){
		case BeetlLexer.StringLiteral:
			//去掉双引号
			value = str.substring(1,str.length()-1);
			break;
		case BeetlLexer.DecimalLiteral:
			value = Integer.parseInt(str);
			break;
		case BeetlParser.RULE_booleanLiteral:
			ParseTree booleanTree = tree.getChild(0);
			value  = Boolean.parseBoolean(booleanTree.getText());
			break;
			
		}
		int cachedIndex = cachedNodeArray.size();
		ctx.setCachedIndex(cachedIndex);
		cachedNodeArray.add(value);
		
//		TerminalNode node = new TerminalNode((TerminalNode)ctx.getChild(0));
//		node.cache = value;
		
	}
	
	//===============输出=======================
	@Override 
	public void enterStaticOutputSt(@NotNull BeetlParser.StaticOutputStContext ctx) { 
		Token t = (Token)ctx.getChild(0).getChild(1).getPayload();
		ctx.setCachedIndex(Integer.parseInt(t.getText()));
	}

	@Override 
	public void enterTextOutputSt(@NotNull BeetlParser.TextOutputStContext ctx) { 
		
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
				int cachedIndex = cachedNodeArray.size();
				zf.setCachedIndex(cachedIndex);
				cachedNodeArray.add(null);
//				cachedNodeArray.add(null);
				String attrName = ((VarAttributeGeneralContext)zf).Identifier().getText();
				if(!vd.attrList.contains(attrName)){
					vd.attrList.add(attrName);
				}
			}
		}
	}
	
	
	protected void analyzeAssign(TerminalNode node) {
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
		List<TerminalNode> where = new ArrayList<TerminalNode>();
		
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
			for(TerminalNode w:where){
				sb.append(w.getCachedIndex()).append(",").append(w.getSymbol().getLine());
				sb.append(";");
			}
			sb.append("\n");
			return sb.toString();
		}

	}

}
