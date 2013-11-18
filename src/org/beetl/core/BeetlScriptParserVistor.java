package org.beetl.core;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.beetl.core.exception.TempException;
import org.beetl.core.parser.BeetlParser.AddminExpContext;
import org.beetl.core.parser.BeetlParser.AndExpContext;
import org.beetl.core.parser.BeetlParser.ArgumentsContext;
import org.beetl.core.parser.BeetlParser.AssignGeneralContext;
import org.beetl.core.parser.BeetlParser.AssignIdContext;
import org.beetl.core.parser.BeetlParser.AssignMentContext;
import org.beetl.core.parser.BeetlParser.AssignStContext;
import org.beetl.core.parser.BeetlParser.AssignTemplateVarContext;
import org.beetl.core.parser.BeetlParser.BlockContext;
import org.beetl.core.parser.BeetlParser.BlockStContext;
import org.beetl.core.parser.BeetlParser.BooleanLiteralContext;
import org.beetl.core.parser.BeetlParser.BreakStContext;
import org.beetl.core.parser.BeetlParser.ClassOrInterfaceTypeContext;
import org.beetl.core.parser.BeetlParser.CommentTagStContext;
import org.beetl.core.parser.BeetlParser.CommentTypeItemTagContext;
import org.beetl.core.parser.BeetlParser.CommentTypeTagContext;
import org.beetl.core.parser.BeetlParser.CompareExpContext;
import org.beetl.core.parser.BeetlParser.ConstantExpressionContext;
import org.beetl.core.parser.BeetlParser.ConstantsTextStatmentContext;
import org.beetl.core.parser.BeetlParser.ContinueStContext;
import org.beetl.core.parser.BeetlParser.DirectiveExpContext;
import org.beetl.core.parser.BeetlParser.DirectiveStContext;
import org.beetl.core.parser.BeetlParser.EqualExpContext;
import org.beetl.core.parser.BeetlParser.ExpressionContext;
import org.beetl.core.parser.BeetlParser.ExpressionListContext;
import org.beetl.core.parser.BeetlParser.ForControlContext;
import org.beetl.core.parser.BeetlParser.ForStContext;
import org.beetl.core.parser.BeetlParser.FunctionCallContext;
import org.beetl.core.parser.BeetlParser.FunctionCallExpContext;
import org.beetl.core.parser.BeetlParser.FunctionNsContext;
import org.beetl.core.parser.BeetlParser.FunctionStContext;
import org.beetl.core.parser.BeetlParser.FunctionTagCallContext;
import org.beetl.core.parser.BeetlParser.G_caseStatmentContext;
import org.beetl.core.parser.BeetlParser.G_defaultStatmentContext;
import org.beetl.core.parser.BeetlParser.G_switchStatmentContext;
import org.beetl.core.parser.BeetlParser.IfStContext;
import org.beetl.core.parser.BeetlParser.JsonContext;
import org.beetl.core.parser.BeetlParser.JsonExpContext;
import org.beetl.core.parser.BeetlParser.JsonKeyValueContext;
import org.beetl.core.parser.BeetlParser.LiteralContext;
import org.beetl.core.parser.BeetlParser.LiteralExpContext;
import org.beetl.core.parser.BeetlParser.MuldivmodExpContext;
import org.beetl.core.parser.BeetlParser.NativeArrayContext;
import org.beetl.core.parser.BeetlParser.NativeCallContext;
import org.beetl.core.parser.BeetlParser.NativeCallExpContext;
import org.beetl.core.parser.BeetlParser.NativeMethodContext;
import org.beetl.core.parser.BeetlParser.NativeVarRefChainContext;
import org.beetl.core.parser.BeetlParser.NegExpContext;
import org.beetl.core.parser.BeetlParser.NotExpContext;
import org.beetl.core.parser.BeetlParser.OrExpContext;
import org.beetl.core.parser.BeetlParser.ParExpContext;
import org.beetl.core.parser.BeetlParser.ParExpressionContext;
import org.beetl.core.parser.BeetlParser.ProgContext;
import org.beetl.core.parser.BeetlParser.ReturnStContext;
import org.beetl.core.parser.BeetlParser.SelectStContext;
import org.beetl.core.parser.BeetlParser.SiwchStContext;
import org.beetl.core.parser.BeetlParser.StatementContext;
import org.beetl.core.parser.BeetlParser.StatementExpressionContext;
import org.beetl.core.parser.BeetlParser.StaticOutputStContext;
import org.beetl.core.parser.BeetlParser.StatmentExpStContext;
import org.beetl.core.parser.BeetlParser.SwitchBlockContext;
import org.beetl.core.parser.BeetlParser.SwitchBlockStatementGroupContext;
import org.beetl.core.parser.BeetlParser.SwitchLabelContext;
import org.beetl.core.parser.BeetlParser.TernaryExpContext;
import org.beetl.core.parser.BeetlParser.TextOutputStContext;
import org.beetl.core.parser.BeetlParser.TextStatmentContext;
import org.beetl.core.parser.BeetlParser.TextVarContext;
import org.beetl.core.parser.BeetlParser.TextformatContext;
import org.beetl.core.parser.BeetlParser.TryStContext;
import org.beetl.core.parser.BeetlParser.TypeArgumentContext;
import org.beetl.core.parser.BeetlParser.TypeArgumentsContext;
import org.beetl.core.parser.BeetlParser.VarAttributeArrayOrMapContext;
import org.beetl.core.parser.BeetlParser.VarAttributeContext;
import org.beetl.core.parser.BeetlParser.VarAttributeGeneralContext;
import org.beetl.core.parser.BeetlParser.VarAttributeVirtualContext;
import org.beetl.core.parser.BeetlParser.VarDeclareListContext;
import org.beetl.core.parser.BeetlParser.VarRefContext;
import org.beetl.core.parser.BeetlParser.VarRefExpContext;
import org.beetl.core.parser.BeetlParser.VarStContext;
import org.beetl.core.parser.BeetlParser.WhileStContext;
import org.beetl.core.parser.BeetlParserVisitor;

public class BeetlScriptParserVistor extends AbstractParseTreeVisitor<Object> implements BeetlParserVisitor<Object> {

	Context env = null;
	public BeetlScriptParserVistor(Context env){
		this.env = env;
	}
	@Override
	public Object visitAssignTemplateVar(AssignTemplateVarContext ctx) {
		
		return null;
	}


	@Override
	public Object visitG_caseStatment(G_caseStatmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCommentTagSt(CommentTagStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitExpressionList(ExpressionListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVarRef(VarRefContext ctx) {
		//上一级节点已经处理，不必访问此节点
		throw new UnsupportedOperationException();
	}

	@Override
	public Object visitG_switchStatment(G_switchStatmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitContinueSt(ContinueStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFunctionCall(FunctionCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTextformat(TextformatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCommentTypeItemTag(CommentTypeItemTagContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitNativeVarRefChain(NativeVarRefChainContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSiwchSt(SiwchStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSelectSt(SelectStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTextVar(TextVarContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitForSt(ForStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDirectiveSt(DirectiveStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTypeArguments(TypeArgumentsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTextOutputSt(TextOutputStContext ctx) {
		TextStatmentContext textStCtx = ctx.textStatment();
		try{
			TextVarContext textVarCtx = textStCtx.textVar();
			Object o = this.visit(textVarCtx.expression());
			env.byteWriter.writePlaceholderContent(o);
			
			}catch(Exception ex){
				if(textStCtx.NOT()==null){
					throw new RuntimeException(ex.getMessage());
				}
				
			}
			return null ;
		
	}

	@Override
	public Object visitVarAttributeArrayOrMap(VarAttributeArrayOrMapContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSwitchBlock(SwitchBlockContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitIfSt(IfStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitNativeCall(NativeCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitConstantExpression(ConstantExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAssignId(AssignIdContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitForControl(ForControlContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitNativeArray(NativeArrayContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitClassOrInterfaceType(ClassOrInterfaceTypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitStatmentExpSt(StatmentExpStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVarDeclareList(VarDeclareListContext ctx) {
		// TODO Auto-generated method stub
		for(AssignMentContext assignCtx :  ctx.assignMent()){
			visit(assignCtx);
		}
		return null;
	}

	@Override
	public Object visitStatementExpression(StatementExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVarAttributeGeneral(VarAttributeGeneralContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitBlock(BlockContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitDirectiveExp(DirectiveExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Object visitVarSt(VarStContext ctx) {
		// TODO Auto-generated method stub
		this.visit(ctx.varDeclareList());
		return null;
	}

	@Override
	public Object visitStaticOutputSt(StaticOutputStContext ctx) {
		Object text = env.staticTextArray[ctx.getCachedIndex()];
		env.byteWriter.writeStaticContent(text);
		return null;
	}

	@Override
	public Object visitTextStatment(TextStatmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitProg(ProgContext ctx) {
		for(StatementContext statCtx:ctx.statement()){
			visit(statCtx);
		}
		return null;
	}

	@Override
	public Object visitJson(JsonContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitConstantsTextStatment(ConstantsTextStatmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitTrySt(TryStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitWhileSt(WhileStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitJsonKeyValue(JsonKeyValueContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitVarAttributeVirtual(VarAttributeVirtualContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitParExpression(ParExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSwitchLabel(SwitchLabelContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFunctionTagCall(FunctionTagCallContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitBlockSt(BlockStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCommentTypeTag(CommentTypeTagContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitBreakSt(BreakStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitReturnSt(ReturnStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitBooleanLiteral(BooleanLiteralContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitNativeMethod(NativeMethodContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitArguments(ArgumentsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitG_defaultStatment(G_defaultStatmentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAssignGeneral(AssignGeneralContext ctx) {
		TerminalNode  idNode = ctx.Identifier();
		Object value = this.visit(ctx.expression());
		env.vars[idNode.getCachedIndex()] = value;	
		return null;
	}

	@Override
	public Object visitTypeArgument(TypeArgumentContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFunctionNs(FunctionNsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitFunctionSt(FunctionStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitAssignSt(AssignStContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitSwitchBlockStatementGroup(SwitchBlockStatementGroupContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitParExp(ParExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitNotExp(NotExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitAddminExp(AddminExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitJsonExp(JsonExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitNegExp(NegExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitOrExp(OrExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitMuldivmodExp(MuldivmodExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitLiteralExp(LiteralExpContext ctx) {
		// TODO Auto-generated method stub
		int index = ctx.getCachedIndex();
		return env.cachedArray[index];
	}
	@Override
	public Object visitVarRefExp(VarRefExpContext ctx) {
		ctx.getChild(0);
		VarRefContext  refCtx = ctx.varRef();
		TerminalNode node = refCtx.Identifier();
		int index = node.getCachedIndex();
		boolean hasSafe = ctx.NOT()!=null;
		Object value = null ;
		if(index==-1){
			String name = node.getText();
			if(env.globalVar.containsKey(name)){
				value = env.globalVar.get(name);
			}else{
				//全局变量未定义
				if(hasSafe){
					ExpressionContext safeExp = ctx.expression();
					return this.visit(safeExp);
				}else{
					throw new TempException("变量不存在");
				}
			}
		}else{
			value = env.vars[index];
		}
		
		//取变量属性
		for(VarAttributeContext attrCtx:refCtx.varAttribute()){
			if(attrCtx instanceof VarAttributeGeneralContext ){
				
			}
		}
		
		
		
		
		
		return null;
		
		
	}
	@Override
	public Object visitTernaryExp(TernaryExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitNativeCallExp(NativeCallExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitCompareExp(CompareExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitEqualExp(EqualExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object visitAndExp(AndExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object visitFunctionCallExp(FunctionCallExpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
