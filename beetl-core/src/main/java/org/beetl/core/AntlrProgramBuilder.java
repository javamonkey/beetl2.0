/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.beetl.core.engine.GrammarCreator;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.MVCStrictException;
import org.beetl.core.exception.NativeNotAllowedException;
import org.beetl.core.parser.BeetlParser;
import org.beetl.core.parser.BeetlParser.AddminExpContext;
import org.beetl.core.parser.BeetlParser.AjaxStContext;
import org.beetl.core.parser.BeetlParser.AndExpContext;
import org.beetl.core.parser.BeetlParser.AssignGeneralInExpContext;
import org.beetl.core.parser.BeetlParser.AssignGeneralInStContext;
import org.beetl.core.parser.BeetlParser.AssignIdContext;
import org.beetl.core.parser.BeetlParser.AssignMentContext;
import org.beetl.core.parser.BeetlParser.AssignStContext;
import org.beetl.core.parser.BeetlParser.AssignTemplateVarContext;
import org.beetl.core.parser.BeetlParser.BlockContext;
import org.beetl.core.parser.BeetlParser.BlockStContext;
import org.beetl.core.parser.BeetlParser.BooleanLiteralContext;
import org.beetl.core.parser.BeetlParser.BreakStContext;
import org.beetl.core.parser.BeetlParser.CommentTagStContext;
import org.beetl.core.parser.BeetlParser.CompareExpContext;
import org.beetl.core.parser.BeetlParser.ConstantsTextStatmentContext;
import org.beetl.core.parser.BeetlParser.ContinueStContext;
import org.beetl.core.parser.BeetlParser.DirectiveExpContext;
import org.beetl.core.parser.BeetlParser.DirectiveExpIDListContext;
import org.beetl.core.parser.BeetlParser.DirectiveStContext;
import org.beetl.core.parser.BeetlParser.EndContext;
import org.beetl.core.parser.BeetlParser.ExpressionContext;
import org.beetl.core.parser.BeetlParser.ExpressionListContext;
import org.beetl.core.parser.BeetlParser.ForControlContext;
import org.beetl.core.parser.BeetlParser.ForInControlContext;
import org.beetl.core.parser.BeetlParser.ForInitContext;
import org.beetl.core.parser.BeetlParser.ForStContext;
import org.beetl.core.parser.BeetlParser.ForUpdateContext;
import org.beetl.core.parser.BeetlParser.FunctionCallContext;
import org.beetl.core.parser.BeetlParser.FunctionCallExpContext;
import org.beetl.core.parser.BeetlParser.FunctionNsContext;
import org.beetl.core.parser.BeetlParser.FunctionTagCallContext;
import org.beetl.core.parser.BeetlParser.FunctionTagStContext;
import org.beetl.core.parser.BeetlParser.G_caseStatmentContext;
import org.beetl.core.parser.BeetlParser.G_defaultStatmentContext;
import org.beetl.core.parser.BeetlParser.G_switchStatmentContext;
import org.beetl.core.parser.BeetlParser.GeneralForControlContext;
import org.beetl.core.parser.BeetlParser.IfStContext;
import org.beetl.core.parser.BeetlParser.IncDecOneContext;
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
import org.beetl.core.parser.BeetlParser.OneIncDecContext;
import org.beetl.core.parser.BeetlParser.OrExpContext;
import org.beetl.core.parser.BeetlParser.ParExpContext;
import org.beetl.core.parser.BeetlParser.ParExpressionContext;
import org.beetl.core.parser.BeetlParser.ReturnStContext;
import org.beetl.core.parser.BeetlParser.Safe_allow_expContext;
import org.beetl.core.parser.BeetlParser.Safe_outputContext;
import org.beetl.core.parser.BeetlParser.SelectStContext;
import org.beetl.core.parser.BeetlParser.SiwchStContext;
import org.beetl.core.parser.BeetlParser.StatementContext;
import org.beetl.core.parser.BeetlParser.StatementExpressionContext;
import org.beetl.core.parser.BeetlParser.StaticOutputStContext;
import org.beetl.core.parser.BeetlParser.StatmentExpStContext;
import org.beetl.core.parser.BeetlParser.SwitchBlockStatementGroupContext;
import org.beetl.core.parser.BeetlParser.SwitchLabelContext;
import org.beetl.core.parser.BeetlParser.TernaryExpContext;
import org.beetl.core.parser.BeetlParser.TextOutputStContext;
import org.beetl.core.parser.BeetlParser.TextStatmentContext;
import org.beetl.core.parser.BeetlParser.TextVarContext;
import org.beetl.core.parser.BeetlParser.TextformatContext;
import org.beetl.core.parser.BeetlParser.TryStContext;
import org.beetl.core.parser.BeetlParser.VarAttributeArrayOrMapContext;
import org.beetl.core.parser.BeetlParser.VarAttributeContext;
import org.beetl.core.parser.BeetlParser.VarAttributeGeneralContext;
import org.beetl.core.parser.BeetlParser.VarAttributeVirtualContext;
import org.beetl.core.parser.BeetlParser.VarDeclareListContext;
import org.beetl.core.parser.BeetlParser.VarRefContext;
import org.beetl.core.parser.BeetlParser.VarRefExpContext;
import org.beetl.core.parser.BeetlParser.VarStContext;
import org.beetl.core.parser.BeetlParser.WhileStContext;
import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.AjaxStatement;
import org.beetl.core.statement.AndExpression;
import org.beetl.core.statement.ArthExpression;
import org.beetl.core.statement.BlockStatement;
import org.beetl.core.statement.BreakStatement;
import org.beetl.core.statement.CompareExpression;
import org.beetl.core.statement.ContentBodyExpression;
import org.beetl.core.statement.ContinueStatement;
import org.beetl.core.statement.DirectiveStatement;
import org.beetl.core.statement.EndStatement;
import org.beetl.core.statement.Expression;
import org.beetl.core.statement.ExpressionRuntime;
import org.beetl.core.statement.ForStatement;
import org.beetl.core.statement.FormatExpression;
import org.beetl.core.statement.FunctionExpression;
import org.beetl.core.statement.GeneralForStatement;
import org.beetl.core.statement.GrammarToken;
import org.beetl.core.statement.IGoto;
import org.beetl.core.statement.IfStatement;
import org.beetl.core.statement.IncDecExpression;
import org.beetl.core.statement.JsonArrayExpression;
import org.beetl.core.statement.JsonMapExpression;
import org.beetl.core.statement.Literal;
import org.beetl.core.statement.NativeCallExpression;
import org.beetl.core.statement.NegExpression;
import org.beetl.core.statement.NotBooleanExpression;
import org.beetl.core.statement.OrExpression;
import org.beetl.core.statement.PlaceholderST;
import org.beetl.core.statement.ProgramMetaData;
import org.beetl.core.statement.ReturnStatement;
import org.beetl.core.statement.SelectStatement;
import org.beetl.core.statement.Statement;
import org.beetl.core.statement.StatementExpression;
import org.beetl.core.statement.StaticTextASTNode;
import org.beetl.core.statement.StaticTextByteASTNode;
import org.beetl.core.statement.SwitchStatement;
import org.beetl.core.statement.TagStatement;
import org.beetl.core.statement.TryCatchStatement;
import org.beetl.core.statement.VarAssignStatement;
import org.beetl.core.statement.VarAssignStatementSeq;
import org.beetl.core.statement.VarAttribute;
import org.beetl.core.statement.VarDefineNode;
import org.beetl.core.statement.VarRef;
import org.beetl.core.statement.VarRefAssignExpress;
import org.beetl.core.statement.VarRefAssignStatement;
import org.beetl.core.statement.VarSquareAttribute;
import org.beetl.core.statement.VarVirtualAttribute;
import org.beetl.core.statement.WhileStatement;
import org.beetl.core.statement.nat.ClassNode;
import org.beetl.core.statement.nat.InstanceNode;
import org.beetl.core.statement.nat.NativeArrayNode;
import org.beetl.core.statement.nat.NativeAtrributeNode;
import org.beetl.core.statement.nat.NativeMethodNode;
import org.beetl.core.statement.nat.NativeNode;
import org.beetl.core.tag.TagFactory;

/**通过antlr来生成Program
 * @author joelli
 *
 */
public class AntlrProgramBuilder {

	protected ProgramMetaData data = new ProgramMetaData();
	protected ProgramBuilderContext pbCtx = new ProgramBuilderContext();

	protected Expression[] EMPTY_EXPRESSION = new Expression[0];
	protected GroupTemplate gt;
	// 多余分号
	static EndStatement endStatment = new EndStatement();
	public static Set<String> safeParameters = new HashSet<String>();
	static {
		// 可以对参数增强安全输出，比如isEmpty(a)，实际调用是改写成isEmpty(a!)
		safeParameters.add("isEmpty");
		safeParameters.add("isNotEmpty");
	}

	GrammarCreator gc;


	public AntlrProgramBuilder(GroupTemplate gt, GrammarCreator gc) {
		this.gt = gt;
		this.gc = gc;

	}

	/** 通过Antlr的ParseTree生成Beetl的ProgramMetaData
	 * @param tree
	 * @return
	 */
	public ProgramMetaData build(ParseTree tree) {

		int size = tree.getChildCount() - 1;
		List<Statement> ls = new ArrayList<Statement>(size);
		for (int i = 0; i < size; i++) {
			Statement st = parseStatment((ParserRuleContext) tree.getChild(i));
			if (st != null) {
				ls.add(st);
			}

		}

		if (pbCtx.current.gotoValue == IGoto.RETURN || pbCtx.current.gotoValue == IGoto.BREAK) {
			// 如果顶级scope也有return 和break，则检测
			data.hasGoto = true;
		}

		pbCtx.anzlyszeGlobal();
		pbCtx.anzlyszeLocal();
		data.varIndexSize = pbCtx.varIndexSize;
		data.tempVarStartIndex = pbCtx.globalIndexMap.size();
		data.statements = ls.toArray(new Statement[0]);
		data.globalIndexMap = pbCtx.globalIndexMap;
		data.setTemplateRootScopeIndexMap(pbCtx.rootIndexMap);

		return data;

	}


	private ProgramMetaData buildAjaxBlock(ProgramBuilderContext pbCtx,BlockStatement templateBlock ){
		ProgramMetaData local = new ProgramMetaData();
		pbCtx.anzlyszeGlobal();
		pbCtx.anzlyszeLocal();
		local.varIndexSize = pbCtx.varIndexSize;
		local.tempVarStartIndex = pbCtx.globalIndexMap.size();
		local.statements = new Statement[]{templateBlock};
		local.globalIndexMap = pbCtx.globalIndexMap;
		local.setTemplateRootScopeIndexMap(pbCtx.rootIndexMap);
		return local;
	}

	private Statement parseStatment(ParserRuleContext node) {

		if (node == null) {
			return null;
		}

		if (node instanceof VarStContext) {
			VarAssignStatementSeq varSeq = parseVarSt((VarStContext) node);

			return varSeq;

		} else if (node instanceof BlockStContext) {
			BlockStContext bc = (BlockStContext) node;
			Statement block = parseBlock(bc.block().statement(), node);
			return block;
		} else if (node instanceof TextOutputStContext) {
			return this.parseTextOutputSt((TextOutputStContext) node);
		} else if (node instanceof ReturnStContext) {
			ReturnStContext rtnCtx = (ReturnStContext) node;
			ExpressionContext expCtx = rtnCtx.expression();
			Expression exp = null;
			if (expCtx != null) {
				exp = this.parseExpress(expCtx);
			}
			ReturnStatement st = gc.createReturn(exp);
			pbCtx.current.gotoValue = IGoto.RETURN;
			return st;
		} else if (node instanceof BreakStContext) {
			BreakStatement st = gc.createBreak(null);
			if (pbCtx.current.gotoValue != IGoto.RETURN) {
				pbCtx.current.gotoValue = IGoto.BREAK;

			}

			return st;
		} else if (node instanceof ContinueStContext) {
			ContinueStatement st = gc.createContinue(null);
			if (pbCtx.current.gotoValue != IGoto.RETURN) {
				pbCtx.current.gotoValue = IGoto.CONTINUE;

			}
			return st;
		} else if (node instanceof ForStContext) {
			return parseForSt((ForStContext) node);

		} else if (node instanceof StaticOutputStContext) {
			StaticOutputStContext st = (StaticOutputStContext) node;
			ConstantsTextStatmentContext cst = st.constantsTextStatment();
			String str = cst.DecimalLiteral().getSymbol().getText();
			int position = Integer.parseInt(str);
			if (!this.gt.getConf().directByteOutput) {
				StaticTextASTNode textNode = gc.createStaticText(position, null);
				return textNode;
			} else {
				StaticTextByteASTNode textNode = gc.createStaticByteText(position, null);
				return textNode;
			}

		} else if (node instanceof IfStContext) {
			return parseIf((IfStContext) node);
		}

		else if (node instanceof StatmentExpStContext) {

			StatementExpressionContext sec = ((StatmentExpStContext) node).statementExpression();
			Expression expression = this.parseExpress(sec.expression());
			StatementExpression se = new StatementExpression(expression, null);
			return se;
		} else if (node instanceof DirectiveStContext) {
			return parseDirectiveStatement((DirectiveStContext) node);

		} else if (node instanceof CommentTagStContext) {
			//兼容2.x版本
			return null;

		} else if (node instanceof TryStContext) {

			return parseTryCatch((TryStContext) node);
		} else if (node instanceof FunctionTagStContext) {
			FunctionTagStContext fc = (FunctionTagStContext) node;
			return this.parseTag(fc.functionTagCall());
		} else if (node instanceof WhileStContext) {
			return this.parseWhile((WhileStContext) node);
		} else if (node instanceof AssignStContext) {
			VarAssignStatement vas = this.parseAssign(((AssignStContext) node).assignMent());
			if (!(vas instanceof VarRefAssignStatement)) {
				// 如果是临时变量定义
				pbCtx.setVarPosition(vas.token.text, vas);
			}

			return vas;
		} else if (node instanceof SiwchStContext) {
			return this.parseSwitch((SiwchStContext) node);
		} else if (node instanceof SelectStContext) {
			SelectStContext selectCtx = (SelectStContext) node;
			return this.parseSelect(selectCtx);
		} else if (node instanceof AjaxStContext) {
			return this.parseAjax((AjaxStContext) node);
		}

		else if (node instanceof EndContext) {
			return endStatment;
		}

		else {
			throw new UnsupportedOperationException("未识别，确认模板书写是否正确");
		}

	}

	protected SelectStatement parseSelect(SelectStContext selectCtx) {
		// this.pbCtx.enterBlock();
		// this.pbCtx.current.canStopContinueBreakFlag = true;
		G_switchStatmentContext ctx = selectCtx.g_switchStatment();
		ExpressionContext exp = ctx.expression();
		Expression base = exp != null ? this.parseExpress(exp) : null;
		List<G_caseStatmentContext> caseCtxList = ctx.g_caseStatment();
		List<Expression> condtionList = new LinkedList<Expression>();
		List<BlockStatement> blockList = new LinkedList<BlockStatement>();
		for (G_caseStatmentContext caseCtx : caseCtxList) {
			List<ExpressionContext> expCtxList = caseCtx.expression();
			List<StatementContext> statCtxList = caseCtx.statement();
			BlockStatement block = this.parseBlock(statCtxList, caseCtx);
			for (ExpressionContext expCtx : expCtxList) {
				Expression condition = this.parseExpress(expCtx);
				// select case 的条件是||的关系，只要任何一个条件满足，都可以执行block
				condtionList.add(condition);
				blockList.add(block);
			}

		}

		BlockStatement defaultStatement = null;
		G_defaultStatmentContext defaultCtx = ctx.g_defaultStatment();
		if (defaultCtx != null) {
			List<StatementContext> defaultCtxList = ctx.g_defaultStatment().statement();
			defaultStatement = this.parseBlock(defaultCtxList, ctx);
		}


		SelectStatement select = gc.createSelect(base, condtionList.toArray(new Expression[0]),
				blockList.toArray(new BlockStatement[0]), defaultStatement,
				this.getBTToken(selectCtx.Select().getSymbol()));


		return select;
	}

	protected AjaxStatement parseAjax(AjaxStContext ajaxCtx) {
		GrammarToken token = null;
		String flag = "render";
		List<TerminalNode> nodes = ajaxCtx.Identifier();
		if (nodes.size() == 1) {
			token = this.getBTToken(nodes.get(0).getSymbol());
		} else {
			token = this.getBTToken(nodes.get(1).getSymbol());
			flag = nodes.get(0).getSymbol().getText();
			if (!(flag.equals("render") || flag.equals("norender"))) {
				BeetlException be = new BeetlException(BeetlException.AJAX_PROPERTY_ERROR,
						"expect render or norender ,but " + flag);
				be.pushToken(token);
				throw be;
			}


		}

		BlockContext blockCtx = ajaxCtx.block();
		BlockStatement block = this.parseBlock(blockCtx.statement(), blockCtx);
		AjaxStatement ajaxStat = gc.createAjax(block, token, flag.equals("render"));
		if (this.data.ajaxs == null) {
			this.data.ajaxs = new HashMap<String, AjaxStatement>();

		}

		String anchor = ajaxStat.token.text;
		if (this.data.ajaxs.containsKey(anchor)) {
			GrammarToken lastToken = this.data.ajaxs.get(anchor).token;
			BeetlException ex = new BeetlException(BeetlException.AJAX_ALREADY_DEFINED,
					"已经在第" + lastToken.line + "行定义");
			ex.pushToken(token);
			throw ex;
		}
		this.data.ajaxs.put(anchor, ajaxStat);
		reParseAjax(ajaxStat,blockCtx);
		return ajaxStat;
	}



	protected void reParseAjax(AjaxStatement ajaxStat,BlockContext blockCtx ) {
		ProgramBuilderContext templateCtx = this.pbCtx;
		//在来一次，将Ajax作为一个单独模板解析
		this.pbCtx = new ProgramBuilderContext();
		BlockStatement templateBlock  =  this.parseBlock(blockCtx.statement(), blockCtx);
		//部分内容解析完所有模板再填充
		ProgramMetaData localMetaData = this.buildAjaxBlock(pbCtx,templateBlock);
		this.pbCtx = templateCtx;
		ajaxStat.setLocalProgramMetaData(localMetaData);



	}

	protected SwitchStatement parseSwitch(SiwchStContext sctx) {
		// this.pbCtx.enterBlock();
		// this.pbCtx.current.canStopContinueBreakFlag = true;

		ExpressionContext ect = sctx.parExpression().expression();
		Expression exp = this.parseExpress(ect);
		List<SwitchBlockStatementGroupContext> list = sctx.switchBlock().switchBlockStatementGroup();
		LinkedHashMap<Expression, BlockStatement> condtionsStatementsMap = new LinkedHashMap<Expression, BlockStatement>();
		List<Expression> conditionList = new ArrayList<Expression>();
		BlockStatement defaultBlock = null;
		for (SwitchBlockStatementGroupContext group : list) {
			List<SwitchLabelContext> labels = group.switchLabel();
			List<StatementContext> stats = group.statement();
			BlockStatement block = stats != null ? this.parseBlock(stats, group) : null;
			for (SwitchLabelContext label : labels) {
				Expression caseExp = this.parseExpress(label.expression());
				if (caseExp == null) {
					// default
					defaultBlock = block;
					break;

				} else {
					conditionList.add(caseExp);
					condtionsStatementsMap.put(caseExp, block);
				}

			}

		}


		SwitchStatement switchStat = gc.createSwitch(exp, condtionsStatementsMap, defaultBlock,
				this.getBTToken(sctx.getStart()));

		return switchStat;
	}

	/**
	 *  赋值变量
	 * @param agc
	 * @return
	 */
	protected VarRefAssignExpress parseAssingInExp(AssignGeneralInExpContext agc) {

		VarRefAssignExpress vas = null;
		ExpressionContext expCtx = agc.generalAssignExp().expression();
		Expression exp = parseExpress(expCtx);
		VarRefContext varRefCtx = agc.generalAssignExp().varRef();
		VarRef ref = this.parseVarRefInLeftExpression(varRefCtx);
		vas = gc.createVarRefAssignExp(exp, ref);

		if (ref.attributes.length == 0) {
			// 变量定义:
			Token token = varRefCtx.Identifier().getSymbol();
			if (pbCtx.hasDefined(token.getText()) != null) {
				registerVar(vas);
				return vas;
			} else {
				BeetlException ex = new BeetlException(BeetlException.VAR_NOT_DEFINED);
				ex.pushToken(this.getBTToken(token));
				throw ex;
			}

		}
		return vas;


	}

	/**
	 * x+=5
	 * @param selfExpContext
	 * @return
	 */
	protected VarRefAssignExpress parseSelfAssingInExp(BeetlParser.AssingSelfExpContext selfExpContext) {

		BeetlParser.GeneralAssingSelfExpContext selfExp = selfExpContext.generalAssingSelfExp();
		VarRefContext varRefCtx = selfExp.varRef();
		VarRef ref = this.parseVarRefInLeftExpression(varRefCtx);
		Expression exp = parseExpress(selfExp.expression());
		TerminalNode tn = (TerminalNode) selfExp.children.get(1);
		short mode = 0;
		if (selfExp.MUlTIP() != null) {
			mode = ArthExpression.MUL;
		} else if (selfExp.DIV() != null) {
			mode = ArthExpression.DIV;
		} else if (selfExp.ADD() != null) {
			mode = ArthExpression.PLUS;
		}else if(selfExp.MIN()!=null){
			mode = ArthExpression.MIN;
		}

		ArthExpression arthExpression=  gc.createArth(ref, exp, mode, this.getBTToken(tn.getSymbol()));
		VarRefAssignExpress vas = gc.createVarRefAssignExp(arthExpression, ref);
		if (ref.attributes.length == 0) {
			// 变量定义:
			Token token = varRefCtx.Identifier().getSymbol();
			if (pbCtx.hasDefined(token.getText()) != null) {
				registerVar(vas);
				return vas;
			} else {
				BeetlException ex = new BeetlException(BeetlException.VAR_NOT_DEFINED);
				ex.pushToken(this.getBTToken(token));
				throw ex;
			}

		}
		return vas;

	}

	// 纪录一个新变量
	protected void registerNewVar(ASTNode vas) {
		if (pbCtx.hasDefined(vas.token.text) != null) {
			GrammarToken token = pbCtx.hasDefined(vas.token.text);
			BeetlException ex = new BeetlException(BeetlException.VAR_ALREADY_DEFINED, "已经在第" + token.line + "行定义");
			ex.pushToken(vas.token);
			throw ex;
		}
		pbCtx.addVar(vas.token.text);
		pbCtx.setVarPosition(vas.token.text, vas);
	}

	// 纪录一个变量
	protected void registerVar(ASTNode vas) {
		pbCtx.setVarPosition(vas.token.text, vas);
	}

	/**
	 * 定义变量
	 * @param amc
	 * @return
	 */
	protected VarAssignStatement parseAssign(AssignMentContext amc) {

		VarAssignStatement vas = null;
		if (amc instanceof AssignGeneralInStContext) {
			AssignGeneralInStContext agc = (AssignGeneralInStContext) amc;
			ExpressionContext expCtx = agc.generalAssignExp().expression();
			Expression exp = parseExpress(expCtx);
			VarRefContext varRefCtx = agc.generalAssignExp().varRef();
			if (varRefCtx.children.size() == 1) {
				// var a=1;
				Token token = varRefCtx.Identifier().getSymbol();
				vas = gc.createVarAssign(exp, getBTToken(token));
			} else {
				// var a.b=1 since 2.7.0

				VarRef ref = this.parseVarRefInLeftExpression(varRefCtx);
				vas = gc.createVarRefAssign(exp, ref);
			}


			return vas;
		} else if (amc instanceof AssignIdContext) {
			AssignIdContext idCtx = (AssignIdContext) amc;
			vas = new VarAssignStatement(Literal.NULLLiteral, getBTToken(idCtx.Identifier().getSymbol()));

			return vas;

		} else if (amc instanceof AssignTemplateVarContext) {
			AssignTemplateVarContext templateVarCtx = (AssignTemplateVarContext) amc;
			BlockContext blockCtx = templateVarCtx.block();

			BlockStatement block = this.parseBlock(blockCtx.statement(), blockCtx);
			ContentBodyExpression bodyExp = gc.createTemplateContent(block,
					getBTToken(templateVarCtx.Identifier().getSymbol()));
			vas = gc.createVarAssign(bodyExp, getBTToken(templateVarCtx.Identifier().getSymbol()));

		} else {
			throw new RuntimeException("不支持 在 " + amc.start.getLine());
		}

		return vas;
	}

	protected void checkGoto(IGoto gotoHandleStat) {

		switch (pbCtx.current.gotoValue) {
			case IGoto.NORMAL:
				return;
			case IGoto.CONTINUE:
			case IGoto.BREAK:
				if (!pbCtx.current.canStopContinueBreakFlag) {
					// 传递给上一级，除非碰到for while这样能停止传递的
					pbCtx.current.parent.gotoValue = pbCtx.current.gotoValue;
				}
				gotoHandleStat.setGoto(true);
				return;
			case IGoto.RETURN:
				if (pbCtx.current.parent != pbCtx.root) {
					// 上一级必须检测return
					pbCtx.current.parent.gotoValue = IGoto.RETURN;
				} else {
					// 整个程序都需要检测return
					this.data.hasGoto = true;
				}
				gotoHandleStat.setGoto(true);

		}
	}

	protected WhileStatement parseWhile(WhileStContext wc) {
		pbCtx.enterBlock();
		// break，continue语句到此为止
		pbCtx.current.canStopContinueBreakFlag = true;
		ExpressionContext condtionCtx = wc.parExpression().expression();
		StatementContext bodyCtx = wc.statement();
		Expression condtion = this.parseExpress(condtionCtx);
		Statement body = this.parseStatment(bodyCtx);
		WhileStatement whileStat = gc.createWhile(condtion, body, this.getBTToken(wc.getStart()));
		pbCtx.exitBlock();
		return whileStat;
	}

	protected TagStatement parseTag(FunctionTagCallContext fc) {
		String id = this.getID(fc.functionNs().Identifier());
		ExpressionListContext expListCtx = fc.expressionList();
		List<ExpressionContext> list = null;
		if (expListCtx != null) {
			list = fc.expressionList().expression();
		} else {
			list = Collections.EMPTY_LIST;

		}

		Expression[] expList = this.parseExpressionCtxList(list);
		if (id.equals("htmltagvar")||id.equals("htmltagexport")) {
			int line = fc.functionNs().getStart().getLine();
			// 标签具有绑定变量功能
			Literal l = (Literal) expList[2];
			String varList = (String) l.obj;
			String[] vars = varList.split(",");
			// 定义的变量仅仅在标签体内可见
			if(id.equals("htmltagvar")) {
				this.pbCtx.enterBlock();
			}
			VarDefineNode[] varDefine = new VarDefineNode[vars.length];
			for (int i = 0; i < vars.length; i++) {
				VarDefineNode varNode = new VarDefineNode(this.getBTToken(vars[i].trim(), line));
				this.pbCtx.addVarAndPostion(varNode);
				varDefine[i] = varNode;
			}
			BlockContext blockCtx = fc.block();
			Statement block = parseBlock(blockCtx.statement(), blockCtx);
			if(id.equals("htmltagvar")) {
				this.pbCtx.exitBlock();
			}
			
			TagFactory tf = this.gt.getTagFactory(id);
			if (tf == null) {
				BeetlException ex = new BeetlException(BeetlException.TAG_NOT_FOUND);
				ex.pushToken(this.getBTToken(id, fc.functionNs().getStart().getLine()));
				throw ex;
			}
			TagStatement tag = gc.createVarTag(id, expList, block, varDefine, this.getBTToken(id, line));

			return tag;
		} else {
			BlockContext blockCtx = fc.block();
			Statement block = parseBlock(blockCtx.statement(), blockCtx);
			TagFactory tf = this.gt.getTagFactory(id);
			if (tf == null) {
				BeetlException ex = new BeetlException(BeetlException.TAG_NOT_FOUND);
				ex.pushToken(this.getBTToken(id, fc.functionNs().getStart().getLine()));
				throw ex;
			}


			TagStatement tag = gc.createTag(id, expList, block,
					this.getBTToken(id, fc.functionNs().getStart().getLine()));
			return tag;
		}

	}

	protected TryCatchStatement parseTryCatch(TryStContext tryStCtx) {

		BlockContext tryBlockCtx = tryStCtx.block(0);

		BlockStatement tryPart = this.parseBlock(tryBlockCtx.statement(), tryBlockCtx);
		BlockStatement catchPart = null;
		VarDefineNode errorNode = null;
		if (tryStCtx.Catch() != null) {
			this.pbCtx.enterBlock();
			if (tryStCtx.Identifier() != null) {
				Token errorToken = tryStCtx.Identifier().getSymbol();
				errorNode = new VarDefineNode(this.getBTToken(errorToken));
				this.pbCtx.addVarAndPostion(errorNode);
			}

			BlockContext catchBlockCtx = tryStCtx.block(1);
			catchPart = this.parseBlock(catchBlockCtx.statement(), catchBlockCtx);
			this.pbCtx.exitBlock();

		}

		TryCatchStatement statement = gc.createTry(tryPart, catchPart, errorNode,
				this.getBTToken(tryStCtx.Try().getSymbol()));
		return statement;
	}

	

	

	/** directive dynamic xxx,yy
	 * @param node
	 * @return
	 */
	protected DirectiveStatement parseDirectiveStatement(DirectiveStContext node) {
		DirectiveStContext stContext = node;
		DirectiveExpContext direExp = stContext.directiveExp();
		Token token = direExp.Identifier().getSymbol();
		String directive = token.getText().toLowerCase().intern();
		TerminalNode value = direExp.StringLiteral();
		List<TerminalNode> idNodeList = null;
		DirectiveExpIDListContext directExpidLisCtx = direExp.directiveExpIDList();
		if (directExpidLisCtx != null) {
			idNodeList = directExpidLisCtx.Identifier();
		}

		Set<String> idList = null;
		DirectiveStatement ds = null;

		if (value != null) {
			String idListValue = this.getStringValue(value.getText());
			idList = new HashSet(Arrays.asList(idListValue.split(",")));
			ds = new DirectiveStatement(directive, idList, this.getBTToken(token));

		} else if (idNodeList != null) {
			idList = new HashSet<String>();
			for (TerminalNode t : idNodeList) {
				idList.add(t.getText());
			}
			ds = new DirectiveStatement(directive, idList, this.getBTToken(token));

		} else {
			ds = new DirectiveStatement(directive, Collections.EMPTY_SET, this.getBTToken(token));
		}

		if (directive.equalsIgnoreCase("safe_output_open".intern())) {
			this.pbCtx.isSafeOutput = true;
			return ds;
		} else if (directive.equalsIgnoreCase("safe_output_close".intern())) {
			this.pbCtx.isSafeOutput = false;
			return ds;
		} else {
			return ds;
		}
	}

	protected FunctionExpression parseFunExp(FunctionCallContext ctx) {
		ExpressionListContext expListCtx = ctx.expressionList();
		Expression[] exps = this.getExprssionList(expListCtx);
		List<VarAttributeContext> vaListCtx = ctx.varAttribute();
		Safe_outputContext soctx = ctx.safe_output();
		Expression safeExp = null;
		boolean hasSafe = false;
		if (soctx != null) {
			safeExp = this.parseSafeOutput(soctx);
			hasSafe = true;

		}
		if (this.pbCtx.isSafeOutput) {
			hasSafe = true;
		}

		VarAttribute[] vs = this.parseVarAttribute(vaListCtx);

		List<TerminalNode> idList = ctx.functionNs().Identifier();

		String nsId = this.getID(idList);
		GrammarToken btToken = new org.beetl.core.statement.GrammarToken(nsId, ctx.start.getLine(), 0);
		// 需要做些特殊处理的函数
		if (safeParameters.contains(nsId)) {

			if (exps.length != 0) {
				Expression one = exps[0];
				if (one instanceof VarRef) {
					// 强制为变量引用增加一个安全输出
					VarRef ref = (VarRef) one;
					if (!ref.hasSafe) {
						ref.hasSafe = true;
						ref.safe = null;
					}
				}
			}

		} else if (nsId.equals("has")) {
			if (exps.length != 0) {
				Expression one = exps[0];
				if (one instanceof VarRef) {

					// 强制为变量引用增加一个安全输出
					VarRef ref = (VarRef) one;
					if (ref.attributes.length != 0) {
						BeetlException ex = new BeetlException(BeetlException.HAS_CALL_ILLEGAL,
								"has函数用于判断全局变量是否存在，不能判断其属性是否有值，可以使用安全输出符号或者isEmpty函数");
						ex.pushToken(ref.token);
						throw ex;
					}
					String name = ref.token.text;
					Literal newExp = gc.createLiteral(name, ref.token);
					// 将变量引用转化为字符串
					exps[0] = newExp;
				}
			}
		} else if (nsId.equals("debug")) {
			// debug函数传递额外的行数
			Literal l = gc.createLiteral(btToken.line, btToken);
			Expression[] newExps = new Expression[exps.length + 2];
			System.arraycopy(exps, 0, newExps, 0, exps.length);
			String[] expStr = this.getExpressionString(expListCtx);
			newExps[newExps.length - 2] = gc.createLiteral(expStr, btToken);
			newExps[newExps.length - 1] = l;
			for (int i = 0; i < exps.length; i++) {
				if (!(exps[i] instanceof VarRef)) {
					expStr[i] = null;
				}
			}

			exps = newExps;
			// 可以通过配置查看是否支持debug，2.1再做

		} else if (nsId.equals("decode")) {
			Expression[] newExps = new Expression[exps.length];
			if (newExps.length >= 4) {
				newExps[0] = exps[0];
				newExps[1] = exps[1];
				for (int i = 2; i < exps.length; i++) {
					// 参数改成runtime 执行
					newExps[i] = new ExpressionRuntime(exps[i]);
				}
				exps = newExps;
			} else {
				// 错误的使用了decode函数，不管了，等后面报错吧
			}
		}
		FunctionExpression fe = gc.createFunctionExp(nsId, exps, vs, hasSafe, safeExp, btToken);
		return fe;

	}

	protected IfStatement parseIf(IfStContext ctx) {
		ParExpressionContext pe = ctx.parExpression();
		ExpressionContext expCtx = pe.expression();
		Expression exp = this.parseExpress(expCtx);
		StatementContext ifStatCtx = ctx.statement(0);
		Statement ifStat = this.parseStatment(ifStatCtx);
		StatementContext elseStatCtx = ctx.statement(1);
		Statement elseStat = null;
		if (elseStatCtx != null) {
			elseStat = this.parseStatment(elseStatCtx);
		}
		return gc.createIf(exp, ifStat, elseStat, this.getBTToken(ctx.If().getSymbol()));
	}

	protected String getID(List<TerminalNode> ids) {
		StringBuilder sb = new StringBuilder();
		for (TerminalNode n : ids) {
			sb.append(n.getSymbol().getText()).append(".");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	protected Expression[] getExprssionList(ExpressionListContext expListCtx) {

		if (expListCtx == null) return EMPTY_EXPRESSION;
		List<ExpressionContext> ecList = expListCtx.expression();
		Expression[] exps = new Expression[ecList.size()];
		for (int i = 0; i < ecList.size(); i++) {
			exps[i] = this.parseExpress(ecList.get(i));
		}
		return exps;
	}

	protected String[] getExpressionString(ExpressionListContext expListCtx) {
		{

			if (expListCtx == null){
				return new String[0];
			}
			List<ExpressionContext> ecList = expListCtx.expression();
			String[] exps = new String[ecList.size()];
			for (int i = 0; i < ecList.size(); i++) {
				exps[i] = ecList.get(i).getText();
			}
			return exps;
		}
	}

	protected Statement parseForSt(ForStContext ctx) {

		pbCtx.enterBlock();
		// break，continue语句到此为止
		pbCtx.current.canStopContinueBreakFlag = true;

		StatementContext forContext = ctx.statement(0);
		StatementContext elseContext = null;

		ForControlContext forTypeCtx = ctx.forControl();
		if (forTypeCtx.forInControl() != null) {
			// for(a in list)...
			ForInControlContext forCtx = forTypeCtx.forInControl();

			Expression exp = this.parseExpress(forCtx.expression());

			VarDefineNode forVar = new VarDefineNode(this.getBTToken(forCtx.Identifier().getSymbol()));

			if (pbCtx.hasDefined(forVar.token.text) != null) {
				GrammarToken token = pbCtx.hasDefined(forVar.token.text);
				BeetlException ex = new BeetlException(BeetlException.VAR_ALREADY_DEFINED, "已经在第" + token.line + "行定义");
				ex.pushToken(forVar.token);
				throw ex;
			}

			VarDefineNode loopStatusVar = new VarDefineNode(new org.beetl.core.statement.GrammarToken(
					forCtx.Identifier().getSymbol().getText() + "LP", forCtx.Identifier().getSymbol().getLine(), 0));

			if (pbCtx.hasDefined(loopStatusVar.token.text) != null) {
				GrammarToken token = pbCtx.hasDefined(loopStatusVar.token.text);
				BeetlException ex = new BeetlException(BeetlException.VAR_ALREADY_DEFINED,
						"For循环隐含变量，已经在第" + token.line + "行定义");
				ex.pushToken(loopStatusVar.token);
				throw ex;
			}
			pbCtx.addVarAndPostion(forVar);

			pbCtx.addVarAndPostion(loopStatusVar);

			// //beetl.2 兼容
			// VarDefineNode indexVar = new VarDefineNode(new org.beetl.core.statement.GrammarToken(forCtx.Identifier()
			// .getSymbol().getText()
			// + "_index", forCtx.Identifier().getSymbol().getLine(), 0));
			//
			// VarDefineNode sizeVar = new VarDefineNode(new org.beetl.core.statement.GrammarToken(forCtx.Identifier()
			// .getSymbol().getText()
			// + "_size", forCtx.Identifier().getSymbol().getLine(), 0));
			//
			// pbCtx.addVarAndPostion(indexVar);
			//
			// pbCtx.addVarAndPostion(sizeVar);


			Statement forPart = this.parseStatment(forContext);
			// elsefor
			Statement elseForPart = null;
			if (ctx.Elsefor() != null) {
				elseContext = ctx.statement(1);
				elseForPart = this.parseStatment(elseContext);

			}
			boolean hasSafe = false;
			if (exp instanceof VarRef) {
				VarRef varRef = (VarRef) exp;
				hasSafe = varRef.hasSafe;
			}

			if (pbCtx.isSafeOutput) {
				hasSafe = true;
			}

			ForStatement forStatement = gc.createForIn(forVar, exp, hasSafe, forPart, elseForPart, forVar.token);

			this.checkGoto(forStatement);
			pbCtx.exitBlock();
			return forStatement;
		} else {
			GeneralForControlContext forCtx = forTypeCtx.generalForControl();

			Expression[] initExp = null;
			VarAssignStatementSeq varInitSeq = null;
			Expression condtion = null;
			Expression[] updateExp = null;
			if (forCtx.forInit() != null) {
				ForInitContext forInitCtx = forCtx.forInit();
				if (forInitCtx.Var() == null) {
					// for( a=1,b=3;
					List<ExpressionContext> list = forInitCtx.expressionList().expression();
					initExp = this.parseExpressionCtxList(list);

				} else {
					// for( var a=1,b=3;
					VarDeclareListContext varDeclare = forInitCtx.varDeclareList();
					varInitSeq = this.parseVarDeclareList(varDeclare);

				}
			}

			if (forCtx.expression() != null) {
				condtion = this.parseExpress(forCtx.expression());

			}

			if (forCtx.forUpdate() != null) {
				ForUpdateContext updateCtx = forCtx.forUpdate();
				List<ExpressionContext> list = updateCtx.expressionList().expression();
				updateExp = this.parseExpressionCtxList(list);
			}

			Statement forPart = this.parseStatment(forContext);
			// elsefor
			Statement elseForPart = null;
			if (ctx.Elsefor() != null) {
				elseContext = ctx.statement(1);
				elseForPart = this.parseStatment(elseContext);

			}
			String str = forTypeCtx.getText();

			GeneralForStatement forStat = gc.createFor(varInitSeq, initExp, condtion, updateExp, forPart, elseForPart,
					this.getBTToken(str, forTypeCtx.start.getLine()));


			pbCtx.exitBlock();
			return forStat;

		}

	}

	protected Statement parseTextOutputSt(TextOutputStContext ctx) {

		TextStatmentContext tsc = ctx.textStatment();
		FormatExpression format = null;

		TextVarContext tvc = tsc.textVar();
		if (tvc.COMMA() != null) {
			String formatName = null;
			String pattern = null;
			String tokenName = null;
			int line = 0;
			TextformatContext tfc = tvc.textformat();
			TerminalNode node = tfc.StringLiteral();
			if (node != null) {
				tokenName = pattern = getStringValue(node.getText());
				line = node.getSymbol().getLine();

			}

			FunctionNsContext fnsc = tfc.functionNs();
			if (fnsc != null) {
				List<TerminalNode> listId = fnsc.Identifier();
				formatName = this.getID(listId);
				tokenName = formatName;
				line = listId.get(0).getSymbol().getLine();

			}
			format = gc.createFormat(formatName, pattern,
					org.beetl.core.statement.GrammarToken.createToken(tokenName, line));

		}

		Expression exp = this.parseExpress(tvc.expression());
		if (tsc.LEFT_TOKEN2() == null) {
			PlaceholderST placeholder = this.gc.createTextOutputSt(exp, format);
			return placeholder;
		} else {
			// TODO
			PlaceholderST placeholder = this.gc.createTextOutputSt2(exp, format);
			return placeholder;

		}
	}

	private VarAssignStatementSeq parseVarSt(VarStContext node) {
		VarStContext varSt = node;
		VarDeclareListContext ctx = varSt.varDeclareList();
		return parseVarDeclareList(ctx);

	}

	private VarAssignStatementSeq parseVarDeclareList(VarDeclareListContext ctx) {
		List<AssignMentContext> list = ctx.assignMent();
		List<VarAssignStatement> listNode = new ArrayList<VarAssignStatement>();
		for (AssignMentContext amc : list) {
			VarAssignStatement vas = this.parseAssign(amc);
			listNode.add(vas);
			if (!(vas instanceof VarRefAssignStatement)) {
				// 如果是临时变量定义
				this.registerNewVar(vas);
			}


		}

		VarAssignStatementSeq seq = this.gc.createVarAssignSeq(listNode.toArray(new VarAssignStatement[0]));
		return seq;
	}

	protected Expression parseExpress(ExpressionContext ctx) {
		if (ctx == null) return null;

		if (ctx instanceof LiteralExpContext) {
			return parseLiteralExpress(((LiteralExpContext) ctx).literal());
		} else if (ctx instanceof VarRefExpContext) {
			return this.parseVarRefExpression(((VarRefExpContext) ctx).varRef());
		} else if (ctx instanceof CompareExpContext) {
			CompareExpression compare = parseCompareExpression((CompareExpContext) ctx);
			if (gt.conf.isStrict) {
				throw new MVCStrictException(compare.token);
			}
			return compare;
		} else if (ctx instanceof TernaryExpContext) {
			return this.parseTernaryExpression((TernaryExpContext) ctx);
		} else if (ctx instanceof MuldivmodExpContext) {
			ArthExpression arth = this.parseMuldivmodExpression((MuldivmodExpContext) ctx);
			if (gt.conf.isStrict) {
				throw new MVCStrictException(arth.token);
			}
			return arth;
		} else if (ctx instanceof AddminExpContext) {
			return this.parsePlusMins((AddminExpContext) ctx);
		} else if (ctx instanceof ParExpContext) {
			ParExpContext par = (ParExpContext) ctx;
			return this.parseExpress(par.expression());
		} else if (ctx instanceof FunctionCallExpContext) {
			FunctionCallExpContext fceCtx = (FunctionCallExpContext) ctx;
			FunctionExpression fun = parseFunExp(fceCtx.functionCall());
			if (gt.conf.isStrict) {
				throw new MVCStrictException(fun.token);
			}
			return fun;
		} else if (ctx instanceof JsonExpContext) {
			JsonContext jc = ((JsonExpContext) ctx).json();
			return this.parseJson(jc);
		} else if (ctx instanceof NativeCallExpContext) {
			NativeCallContext ncc = ((NativeCallExpContext) ctx).nativeCall();
			NativeCallExpression nativeCall = this.parseNativeCallExpression(ncc);
			if (!gt.conf.nativeCall || gt.conf.isStrict) {
				throw new NativeNotAllowedException(nativeCall.token);
			}
			return nativeCall;
		} else if (ctx instanceof AndExpContext) {
			AndExpContext andCtx = (AndExpContext) ctx;
			return this.parseAndExpression(andCtx);
		} else if (ctx instanceof OrExpContext) {
			OrExpContext orExp = (OrExpContext) ctx;
			return this.parseOrExpression(orExp);
		} else if (ctx instanceof NotExpContext) {
			NotExpContext notCtx = (NotExpContext) ctx;
			return this.parseNotExpression(notCtx);
		} else if (ctx instanceof NegExpContext) {
			NegExpContext negCtx = (NegExpContext) ctx;
			return this.parseNegExpression(negCtx);
		} else if (ctx instanceof IncDecOneContext) {
			IncDecOneContext oneCtx = (IncDecOneContext) ctx;
			IncDecExpression exp = this.parseIncDecOneContext(oneCtx);
			if (gt.conf.isStrict) {
				throw new NativeNotAllowedException(exp.token);
			}
			return exp;
		} else if (ctx instanceof OneIncDecContext) {
			OneIncDecContext oneCtx = (OneIncDecContext) ctx;
			IncDecExpression exp = this.parseOneIncDecContext(oneCtx);
			if (gt.conf.isStrict) {
				throw new NativeNotAllowedException(exp.token);
			}
			return exp;

		} else if (ctx instanceof AssignGeneralInExpContext) {


			AssignGeneralInExpContext agc = (AssignGeneralInExpContext) ctx;
			VarRefAssignExpress vas = this.parseAssingInExp(agc);
			return vas;

		} else if(ctx instanceof BeetlParser.AssingSelfExpContext){
			return parseSelfAssingInExp((BeetlParser.AssingSelfExpContext)ctx);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}



	protected IncDecExpression parseIncDecOneContext(IncDecOneContext ctx) {
		IncDecExpression exp = null;
		boolean isInc = ctx.INCREASE() != null;
		GrammarToken t = this.getBTToken(ctx.Identifier().getSymbol());
		exp = gc.createIncDec(isInc, false, t);
		this.pbCtx.setVarPosition(t.text, exp);
		return exp;

	}

	protected IncDecExpression parseOneIncDecContext(OneIncDecContext ctx) {
		IncDecExpression exp = null;
		boolean isInc = ctx.INCREASE() != null;
		GrammarToken t = this.getBTToken(ctx.Identifier().getSymbol());
		exp = gc.createIncDec(isInc, true, t);
		this.pbCtx.setVarPosition(t.text, exp);
		return exp;

	}

	protected Expression parseNegExpression(NegExpContext ctx) {
		Expression exp = this.parseExpress(ctx.expression());
		if (ctx.MIN() != null) {
			// 负数
			NegExpression negExp = gc.createNeg(exp, this.getBTToken(ctx.MIN().getSymbol()));
			return negExp;

		} else {
			return exp;
		}

	}

	protected NotBooleanExpression parseNotExpression(NotExpContext ctx) {
		Expression exp = this.parseExpress(ctx.expression());
		NotBooleanExpression notExp = gc.createNot(exp, this.getBTToken(ctx.NOT().getSymbol()));

		return notExp;

	}

	protected OrExpression parseOrExpression(OrExpContext ctx) {
		Expression exp1 = this.parseExpress(ctx.expression(0));
		Expression exp2 = this.parseExpress(ctx.expression(1));
		OrExpression orExp = gc.createOr(exp1, exp2, this.getBTToken(ctx.OR().getSymbol()));
		return orExp;

	}

	protected AndExpression parseAndExpression(AndExpContext ctx) {
		Expression exp1 = this.parseExpress(ctx.expression(0));
		Expression exp2 = this.parseExpress(ctx.expression(1));
		AndExpression andExp = gc.createAnd(exp1, exp2, this.getBTToken(ctx.AND().getSymbol()));
		return andExp;

	}

	protected NativeCallExpression parseNativeCallExpression(NativeCallContext ncc) {
		NativeCallExpression nativeExp = null;
		List<ParseTree> list = ncc.children;
		// nativeCall: nativeVarRefChain (nativeMethod|nativeArray| PERIOD nativeVarRefChain)*;

		NativeVarRefChainContext first = (NativeVarRefChainContext) list.get(0);
		List<TerminalNode> ids = first.Identifier();
		StringBuilder clsSb = new StringBuilder();
		// 是类静态调用还是实例调用
		boolean isCls = false;
		int i = 0;
		for (; i < ids.size(); i++) {
			String text = ids.get(i).getText();

			char c = text.charAt(0);
			if (c >= 'A' && c <= 'Z') {
				clsSb.append(text);
				isCls = true;
				break;

			} else {
				clsSb.append(text).append(".");
			}
		}

		ClassNode clsNode = null;
		InstanceNode insNode = null;

		if (isCls) {
			clsNode = new ClassNode(clsSb.toString());
			// 指向下一个属性或者静态方法
			i++;
		} else {
			// 变量的属性引用,回到第一个，构造一个变量
			String varName = ids.get(0).getText();
			VarRef ref = gc.createVarRef(new VarAttribute[0], false, null,
					this.getBTToken(varName, ncc.start.getLine()), null);
			this.pbCtx.setVarPosition(varName, ref);
			insNode = new InstanceNode(ref);
			i = 1;
		}
		List<NativeNode> nativeList = new ArrayList<NativeNode>();

		for (int j = i; j < ids.size(); j++) {
			// 剩下的是属性
			NativeAtrributeNode attribute = new NativeAtrributeNode(ids.get(j).getText());
			nativeList.add(attribute);
		}

		for (int z = 1; z < list.size(); z++) {
			ParseTree tree = list.get(z);
			if (tree instanceof NativeMethodContext) {
				NativeMethodContext methodCtx = (NativeMethodContext) tree;
				NativeMethodNode methodNode = null;
				String method = null;
				NativeNode lastNode = nativeList.get(nativeList.size() - 1);
				if (lastNode instanceof NativeAtrributeNode) {
					method = ((NativeAtrributeNode) lastNode).attribute;
					//
					nativeList.remove(nativeList.size() - 1);

				} else {

					String msg = null;
					if (lastNode instanceof NativeArrayNode) {
						msg = "[]()";
					} else {
						msg = "()()";
					}
					BeetlException ex = new BeetlException(BeetlException.PARSER_NATIVE_ERROR, msg);
					ex.pushToken(this.getBTToken(methodCtx.getStart()));
					throw ex;
				}
				// 解析参数
				List<ExpressionContext> expCtxList = methodCtx.expression();
				Expression[] exp = this.parseExpressionCtxList(expCtxList);
				methodNode = new NativeMethodNode(method, exp);
				nativeList.add(methodNode);
			} else if (tree instanceof NativeArrayContext) {
				ExpressionContext expCtx = ((NativeArrayContext) tree).expression();
				Expression exp = this.parseExpress(expCtx);
				NativeArrayNode arrayNode = new NativeArrayNode(exp);
				nativeList.add(arrayNode);
			} else if (tree instanceof NativeVarRefChainContext) {
				List<TerminalNode> nodes = ((NativeVarRefChainContext) tree).Identifier();
				for (TerminalNode node : nodes) {
					NativeAtrributeNode attributeNode = new NativeAtrributeNode(node.getText());
					nativeList.add(attributeNode);
				}
			} else {
				// 其他节点，这段语法写的不好，造成解析困难，但先这样了
				continue;
			}
		}

		NativeNode[] chain = nativeList.toArray(new NativeNode[0]);
		if (clsNode != null) {
			nativeExp = gc.createClassNativeCall(clsNode, chain, this.getBTToken(ncc.start));
		} else {
			nativeExp = gc.createInstanceNativeCall(insNode, chain, this.getBTToken(ncc.start));
		}
		return nativeExp;

	}

	protected Expression[] parseExpressionCtxList(List<ExpressionContext> list) {
		if (list == null || list.size() == 0) {
			return new Expression[0];
		}
		List<Expression> expList = new ArrayList<Expression>(list.size());
		for (ExpressionContext ec : list) {
			expList.add(this.parseExpress(ec));
		}
		return expList.toArray(new Expression[0]);

	}

	protected Expression parseJson(JsonContext ctx) {
		if (ctx.LEFT_SQBR() != null) {

			// array
			JsonArrayExpression json = null;
			List<ExpressionContext> listCtx = ctx.expression();
			if (listCtx.size() == 0) {
				json = gc.createJasonArray(Collections.EMPTY_LIST, this.getBTToken(ctx.LEFT_SQBR().getSymbol()));
			} else {
				List<Expression> list = new ArrayList<Expression>(listCtx.size());
				for (ExpressionContext expCtx : listCtx) {
					list.add(this.parseExpress(expCtx));
				}
				json = gc.createJasonArray(list, this.getBTToken(ctx.LEFT_SQBR().getSymbol()));
			}
			return json;
		} else {
			// map
			JsonMapExpression json = null;
			List<JsonKeyValueContext> listCtx = ctx.jsonKeyValue();
			if (listCtx.size() == 0) {
				json = gc.createJsonMap(Collections.EMPTY_MAP, this.getBTToken(ctx.LEFT_BRACE().getSymbol()));

			} else {
				Map<String, Expression> map = new LinkedHashMap<String, Expression>(listCtx.size());
				for (JsonKeyValueContext kvCtx : listCtx) {
					String key = null;
					if (kvCtx.StringLiteral() != null) {
						key = this.getStringValue(kvCtx.StringLiteral().getText());
					} else {
						key = kvCtx.Identifier().getSymbol().getText();
					}
					Expression exp = this.parseExpress(kvCtx.expression());
					map.put(key, exp);
				}
				json = gc.createJsonMap(map, this.getBTToken(ctx.LEFT_BRACE().getSymbol()));

			}
			return json;

		}
	}

	protected ArthExpression parseMuldivmodExpression(MuldivmodExpContext ctx) {
		Expression a = this.parseExpress(ctx.expression(0));
		Expression b = this.parseExpress(ctx.expression(1));
		TerminalNode tn = (TerminalNode) ctx.children.get(1);
		short mode = 0;
		if (ctx.MUlTIP() != null) {
			mode = ArthExpression.MUL;
		} else if (ctx.DIV() != null) {
			mode = ArthExpression.DIV;
		} else if (ctx.MOD() != null) {
			mode = ArthExpression.MOD;
		}
		return gc.createArth(a, b, mode, this.getBTToken(tn.getSymbol()));

	}

	protected Expression parsePlusMins(AddminExpContext ctx) {
		Expression a = this.parseExpress(ctx.expression(0));
		Expression b = this.parseExpress(ctx.expression(1));
		TerminalNode tn = (TerminalNode) ctx.children.get(1);
		short mode = 0;
		if (ctx.ADD() != null) {
			mode = ArthExpression.PLUS;
		} else if (ctx.MIN() != null) {
			mode = ArthExpression.MIN;
		}
		return gc.createArth(a, b, mode, this.getBTToken(tn.getSymbol()));

	}

	protected Expression parseTernaryExpression(TernaryExpContext ctx) {
		Expression cond = this.parseExpress(ctx.expression(0));
		Expression a = this.parseExpress(ctx.expression(1));
		Expression b = null;
		if (ctx.COLON() == null) {
			b = null;
		} else {
			b = this.parseExpress(ctx.expression(2));
		}

		TerminalNode tn = (TerminalNode) ctx.getChild(1);
		return gc.createTernary(cond, a, b, this.getBTToken(tn.getSymbol()));

	}

	protected CompareExpression parseCompareExpression(CompareExpContext ctx) {
		Expression a = this.parseExpress(ctx.expression(0));
		Expression b = this.parseExpress(ctx.expression(1));
		TerminalNode tn = (TerminalNode) ctx.children.get(1);
		short mode = 0;

		if (ctx.EQUAL() != null) {
			mode = 0;
		} else if (ctx.NOT_EQUAL() != null) {
			mode = 1;
		} else if (ctx.LARGE() != null) {
			mode = 2;
		} else if (ctx.LARGE_EQUAL() != null) {
			mode = 3;
		} else if (ctx.LESS() != null) {
			mode = 4;
		} else if (ctx.LESS_EQUAL() != null) {
			mode = 5;
		}
		return gc.createCompare(a, b, mode, this.getBTToken(tn.getSymbol()));

	}

	protected Expression parseVarRefExpression(VarRefContext varRef) {

		Expression safeExp = null;
		Safe_outputContext soctx = varRef.safe_output();
		boolean hasSafe = false;
		if (soctx != null) {
			safeExp = this.parseSafeOutput(soctx);
			hasSafe = true;

		}

		if (this.pbCtx.isSafeOutput) {
			hasSafe = true;
		}

		List<VarAttributeContext> list = varRef.varAttribute();
		VarAttribute[] vas = this.parseVarAttribute(list);
		if (vas.length > 0) {
			VarAttribute first = vas[0];
			if (!(first instanceof VarSquareAttribute || first instanceof VarVirtualAttribute)) {
				pbCtx.setVarAttr(varRef.Identifier().getText(), first.token.text);
			}

		}

		VarRef var = gc.createVarRef(vas, hasSafe, safeExp,
				this.getBTToken(varRef.getText(), varRef.Identifier().getSymbol().getLine()),
				this.getBTToken(varRef.Identifier().getSymbol()));


		pbCtx.setVarPosition(varRef.Identifier().getText(), var);
		return var;
	}

	protected Expression parseSafeOutput(Safe_outputContext soctx) {
		Expression safeExp = null;
		List list = soctx.children;
		if (list.size() == 1) {
			safeExp = null;
		} else {
			// just xxx!exp
			Safe_allow_expContext allowExp = (Safe_allow_expContext) list.get(1);
			if (allowExp.literal() != null) {
				safeExp = this.parseLiteralExpress(allowExp.literal());
			} else if (allowExp.nativeCall() != null) {
				safeExp = this.parseNativeCallExpression(allowExp.nativeCall());
			} else if (allowExp.functionCall() != null) {
				safeExp = this.parseFunExp(allowExp.functionCall());
			} else if (allowExp.expression() != null) {
				safeExp = this.parseExpress(allowExp.expression());
			} else if (allowExp.varRef() != null) {
				safeExp = this.parseVarRefExpression(allowExp.varRef());
			}

		}
		return safeExp;
	}

	protected VarRef parseVarRefInLeftExpression(VarRefContext varRef) {

		Expression safeExp = null;
		Safe_outputContext soctx = varRef.safe_output();
		if (soctx != null) {
			throw new BeetlException(BeetlException.ERROR, "语法错,赋值表达式不能使用安全输出");

		}


		List<VarAttributeContext> list = varRef.varAttribute();
		VarAttribute[] vas = this.parseVarAttribute(list);
		// 变量属性，用来收集，暂时未用上
		if (vas.length > 0) {
			VarAttribute first = vas[0];
			if (!(first instanceof VarSquareAttribute || first instanceof VarVirtualAttribute)) {
				pbCtx.setVarAttr(varRef.Identifier().getText(), first.token.text);
			}

		}

		VarRef var = new VarRef(vas, false, null,
				this.getBTToken(varRef.getText(), varRef.Identifier().getSymbol().getLine()),
				this.getBTToken(varRef.Identifier().getSymbol()));
		pbCtx.setVarPosition(varRef.Identifier().getText(), var);
		return var;
	}

	protected VarAttribute[] parseVarAttribute(List<VarAttributeContext> list) {
		List<VarAttribute> listVarAttr = new ArrayList<VarAttribute>();

		for (VarAttributeContext vac : list) {
			if (vac instanceof VarAttributeGeneralContext) {
				VarAttributeGeneralContext zf = (VarAttributeGeneralContext) vac;
				VarAttribute attr = new VarAttribute(this.getBTToken(zf.Identifier().getSymbol()));
				listVarAttr.add(attr);

			} else if (vac instanceof VarAttributeArrayOrMapContext) {
				VarAttributeArrayOrMapContext zf = (VarAttributeArrayOrMapContext) vac;

				Expression exp = this.parseExpress(zf.expression());
				VarSquareAttribute attr = new VarSquareAttribute(exp, this.getBTToken("[]", exp.token.line));

				listVarAttr.add(attr);
			} else if (vac instanceof VarAttributeVirtualContext) {
				VarAttributeVirtualContext zf = (VarAttributeVirtualContext) vac;
				VarVirtualAttribute attr = new VarVirtualAttribute(this.getBTToken(zf.Identifier().getSymbol()));
				listVarAttr.add(attr);
			}
		}

		return listVarAttr.toArray(new VarAttribute[0]);

	}

	protected Expression parseLiteralExpress(LiteralContext ctx) {

		ParseTree tree = ctx.getChild(0);
		Object value = null;
		if (tree instanceof TerminalNode) {
			Token node = ((TerminalNode) tree).getSymbol();
			String strValue = node.getText();

			int type = node.getType();
			switch (type) {
				case BeetlParser.StringLiteral:
					value = getStringValue(strValue);
					break;
				case BeetlParser.FloatingPointLiteral:
					char c = strValue.charAt(strValue.length() - 1);
					if (isHighScaleNumber(strValue)) {
						String newValue = strValue.substring(0, strValue.length() - 1);
						value = new BigDecimal(newValue);
					} else {
						value = Double.parseDouble(strValue);
					}

					break;
				case BeetlParser.DecimalLiteral:
					if (isHighScaleNumber(strValue)) {
						String newValue = strValue.substring(0, strValue.length() - 1);
						value = new BigDecimal(newValue);
					} else {
						if (strValue.length() < 10) {
							value = Integer.parseInt(strValue);
						} else if (strValue.length() > 10) {
							value = Long.parseLong(strValue);
						} else if (strValue.compareTo("2147483647") > 0) {

							value = Long.parseLong(strValue);
						} else {
							value = Integer.parseInt(strValue);
						}

					}

					break;
				case BeetlParser.NULL:
					value = null;
					break;

			}

		} else {
			BooleanLiteralContext blc = (BooleanLiteralContext) tree;
			String strValue = blc.getChild(0).getText();
			value = Boolean.parseBoolean(strValue);
		}
		if (value == null) {
			return Literal.NULLLiteral;
		} else {
			Literal literal = gc.createLiteral(value, this.getBTToken(ctx.getStart()));
			return literal;
		}

	}

	private String getStringValue(String strValue) {
		char[] ch = strValue.toCharArray();
		StringBuilder sb = new StringBuilder(strValue.length());
		for (int i = 1; i < ch.length - 1; i++) {
			char c = ch[i];
			if (c == '\\') {
				char spec = ch[++i];
				char real = 0;
				switch (spec) {
					case '\"':
						real = '\"';
						break;
					case '\'':
						real = '\'';
						break;
					case 't':
						real = '\t';
						break;
					case 'r':
						real = '\r';
						break;
					case 'n':
						real = '\n';
						break;
					case 'b':
						real = '\b';
						break;
					case 'f':
						real = '\f';
						break;
					case '\\':
						real = '\\';
						break;

					default:
						// 16进制，8进制不支持，目前语法上可以通过，但未来取消
						throw new RuntimeException("不支持的转义符号" + strValue);

				}
				sb.append(real);

			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private boolean isHighScaleNumber(String strValue) {

		char c = strValue.charAt(strValue.length() - 1);
		if (c == 'h' || c == 'H') {
			return true;
		} else {
			return false;
		}
	}

	protected BlockStatement parseBlock(List list, ParserRuleContext ctx) {
		pbCtx.enterBlock();
		ASTNode[] statements = new ASTNode[list.size()];
		List<Statement> nodes = new ArrayList<Statement>();
		boolean hasGoto = false;
		for (int i = 0; i < statements.length; i++) {
			nodes.add(parseStatment((ParserRuleContext) list.get(i)));

		}

		BlockStatement block = this.gc.createBlock(nodes.toArray(new Statement[0]), this.getBTToken(ctx.getStart()));

		this.checkGoto(block);
		pbCtx.exitBlock();
		return block;
	}

	public GrammarToken getBTToken(Token t) {
		org.beetl.core.statement.GrammarToken token = new org.beetl.core.statement.GrammarToken(t.getText(),
				t.getLine(), t.getCharPositionInLine());
		return token;
	}

	public GrammarToken getBTToken(String text, int line) {
		org.beetl.core.statement.GrammarToken token = org.beetl.core.statement.GrammarToken.createToken(text, line);
		return token;
	}

	// protected boolean isMVCStrictNode(ASTNode node)
	// {
	//
	// }

}
