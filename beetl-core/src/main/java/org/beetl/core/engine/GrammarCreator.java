package org.beetl.core.engine;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.statement.AjaxStatement;
import org.beetl.core.statement.AndExpression;
import org.beetl.core.statement.ArthExpression;
import org.beetl.core.statement.BlockStatement;
import org.beetl.core.statement.BreakStatement;
import org.beetl.core.statement.CompareExpression;
import org.beetl.core.statement.ContentBodyExpression;
import org.beetl.core.statement.ContinueStatement;
import org.beetl.core.statement.Expression;
import org.beetl.core.statement.ForStatement;
import org.beetl.core.statement.FormatExpression;
import org.beetl.core.statement.FunctionExpression;
import org.beetl.core.statement.GeneralForStatement;
import org.beetl.core.statement.GrammarToken;
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
import org.beetl.core.statement.ReturnStatement;
import org.beetl.core.statement.SelectStatement;
import org.beetl.core.statement.Statement;
import org.beetl.core.statement.StatementExpression;
import org.beetl.core.statement.StaticTextASTNode;
import org.beetl.core.statement.StaticTextByteASTNode;
import org.beetl.core.statement.SwitchStatement;
import org.beetl.core.statement.TagStatement;
import org.beetl.core.statement.TagVarBindingStatement;
import org.beetl.core.statement.TernaryExpression;
import org.beetl.core.statement.TryCatchStatement;
import org.beetl.core.statement.VarAssignStatement;
import org.beetl.core.statement.VarAssignStatementSeq;
import org.beetl.core.statement.VarAttribute;
import org.beetl.core.statement.VarDefineNode;
import org.beetl.core.statement.VarRef;
import org.beetl.core.statement.VarRefAssignExpress;
import org.beetl.core.statement.VarRefAssignStatement;
import org.beetl.core.statement.WhileStatement;
import org.beetl.core.statement.nat.ClassNode;
import org.beetl.core.statement.nat.InstanceNode;
import org.beetl.core.statement.nat.NativeNode;

/**
 * 语法自定义控制，可以集成这个类实现特定扩展
 * 
 * 1） 负责提供语法黑名单，则模板不允许出现特定语法，如java直接调用，或者while循环
 * 2） 负责提供功一系列create方法构造语法树，可以重载这些create方法构造自己的语法树,比如，一个允许最多循环10次的while
 * 
 * @author xiandafu
 *
 */
public class GrammarCreator {
	protected HashSet<String> disable = new HashSet<String>();

	/**
	 * 参考BeetlLexer.g4
	 * @param grammar
	 */
	public void disable(String grammar) {
		disable.add(grammar);
	}


	public VarAssignStatementSeq createVarAssignSeq(VarAssignStatement[] assings) {
		return new VarAssignStatementSeq(assings, null);
	}

	public VarAssignStatement createVarAssign(Expression exp, GrammarToken token) {
		VarAssignStatement assign = new VarAssignStatement(exp, token);
		return assign;
	}

	public VarRefAssignStatement createVarRefAssign(Expression exp, VarRef varRef) {
		VarRefAssignStatement assign = new VarRefAssignStatement(exp, varRef);
		return assign;
	}

	public BlockStatement createBlock(Statement[] nodes, GrammarToken token) {
		BlockStatement block = new BlockStatement(nodes, token);
		return block;

	}

	public PlaceholderST createTextOutputSt(Expression exp, FormatExpression format) {
		return new PlaceholderST(exp, format, null);
	}

	public PlaceholderST createTextOutputSt2(Expression exp, FormatExpression format) {
		return new PlaceholderST(exp, format, null);
	}

	public ReturnStatement createReturn(Expression exp) {
		return new ReturnStatement(exp, null);
	}

	public BreakStatement createBreak(GrammarToken token) {
		return new BreakStatement(token);
	}

	public ContinueStatement createContinue(GrammarToken token) {
		return new ContinueStatement(token);
	}

	public ForStatement createForIn(VarDefineNode forVar, Expression exp, boolean hasSafe, Statement forPart,
			Statement elseForPart, GrammarToken token) {
		return new ForStatement(forVar, exp, hasSafe, forPart, elseForPart, forVar.token);
	}

	public GeneralForStatement createFor(VarAssignStatementSeq varAssignSeq, Expression[] expInit, Expression condtion,
			Expression[] expUpdate, Statement forPart, Statement elseforPart, GrammarToken token) {
		GeneralForStatement forStat = new GeneralForStatement(varAssignSeq, expInit, condtion, expUpdate, forPart,
				elseforPart, token);
		return forStat;
	}

	public WhileStatement createWhile(Expression exp, Statement whileBody, GrammarToken token) {
		WhileStatement whileStat = new WhileStatement(exp, whileBody, token);
		return whileStat;
	}

	public StaticTextASTNode createStaticText(int textIndex, GrammarToken token) {
		return new StaticTextASTNode(textIndex, token);
	}

	public StaticTextByteASTNode createStaticByteText(int textIndex, GrammarToken token) {
		return new StaticTextByteASTNode(textIndex, token);
	}

	public IfStatement createIf(Expression condtion, Statement ifStatement, Statement elseStatement,
			GrammarToken token) {
		return new IfStatement(condtion, ifStatement, elseStatement, token);
	}

	public StatementExpression createStatementExpression(Expression expression) {
		return new StatementExpression(expression, null);
	}

	public TryCatchStatement createTry(BlockStatement tryPart, BlockStatement catchPart, VarDefineNode error,
			GrammarToken token) {
		TryCatchStatement statement = new TryCatchStatement(tryPart, catchPart, error, token);
		return statement;
	}

	public TagStatement createTag(String tagName, Expression[] expList, Statement block, GrammarToken token) {
		TagStatement tag = new TagStatement(tagName, expList, block, token);
		return tag;
	}

	public TagVarBindingStatement createVarTag(String tagName, Expression[] expList, Statement block,
			VarDefineNode[] varDefine, GrammarToken token) {
		TagVarBindingStatement tag = new TagVarBindingStatement(tagName, expList, block, varDefine, token);
		return tag;
	}


	public SwitchStatement createSwitch(Expression value, LinkedHashMap<Expression, BlockStatement> map,
			BlockStatement defaultBlock, GrammarToken token) {
		SwitchStatement switchStat = new SwitchStatement(value, map, defaultBlock, token);
		return switchStat;
	}

	public SelectStatement createSelect(Expression value, Expression[] conditions, BlockStatement[] blocks,
			BlockStatement defaultBlock, GrammarToken token) {
		SelectStatement select = new SelectStatement(value, conditions, blocks, defaultBlock, token);
		return select;
	}

	public AjaxStatement createAjax(BlockStatement block, GrammarToken token, boolean defaultRender) {
		AjaxStatement ajaxStat = new AjaxStatement(block, token, defaultRender);
		return ajaxStat;
	}


	/* Express */

	public FunctionExpression createFunction(String name, Expression[] exps, VarAttribute[] vas, boolean hasSafe,
			Expression safeExp, GrammarToken token) {
		FunctionExpression fe = new FunctionExpression(name, exps, vas, hasSafe, safeExp, token);
		return fe;
	}

	public Literal createLiteral(Object value, GrammarToken token) {
		Literal literal = new Literal(value, token);
		return literal;
	}

	public CompareExpression createCompare(Expression a, Expression b, short mode, GrammarToken token) {
		return new CompareExpression(a, b, mode, token);
	}

	public TernaryExpression createTernary(Expression condtion, Expression a, Expression b, GrammarToken token) {
		return new TernaryExpression(condtion, a, b, token);
	}

	public ArthExpression createArth(Expression a, Expression b, short mode, GrammarToken token) {
		return new ArthExpression(a, b, mode, token);
	}

	public JsonArrayExpression createJasonArray(List<Expression> list, GrammarToken token) {
		return new JsonArrayExpression(list, token);
	}

	public JsonMapExpression createJsonMap(Map<String, Expression> map, GrammarToken token) {
		return new JsonMapExpression(map, token);
	}

	public FunctionExpression createFunctionExp(String name, Expression[] exps, VarAttribute[] vas, boolean hasSafe,
			Expression safeExp, GrammarToken token) {
		FunctionExpression fe = new FunctionExpression(name, exps, vas, hasSafe, safeExp, token);
		return fe;
	}

	public NativeCallExpression createClassNativeCall(ClassNode clsNode, NativeNode[] chain, GrammarToken token) {
		NativeCallExpression fe = new NativeCallExpression(clsNode, chain, token);
		return fe;
	}

	public NativeCallExpression createInstanceNativeCall(InstanceNode insNode, NativeNode[] chain, GrammarToken token) {
		NativeCallExpression fe = new NativeCallExpression(insNode, chain, token);
		return fe;
	}

	public AndExpression createAnd(Expression exp1, Expression exp2, GrammarToken token) {
		AndExpression andExp = new AndExpression(exp1, exp2, token);
		return andExp;
	}

	public OrExpression createOr(Expression exp1, Expression exp2, GrammarToken token) {
		OrExpression andExp = new OrExpression(exp1, exp2, token);
		return andExp;
	}

	public NotBooleanExpression createNot(Expression exp, GrammarToken token) {
		NotBooleanExpression notExp = new NotBooleanExpression(exp, token);
		return notExp;
	}

	public NegExpression createNeg(Expression exp, GrammarToken token) {
		NegExpression negExp = new NegExpression(exp, token);
		return negExp;
	}

	public IncDecExpression createIncDec(boolean isInc, boolean returnOrginal, GrammarToken token) {
		IncDecExpression exp = new IncDecExpression(isInc, false, token);
		return exp;
	}

	public VarRef createVarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, GrammarToken token,
			GrammarToken firstToken) {
		VarRef express = new VarRef(attributes, hasSafe, safe, firstToken);
		return express;
	}

	public VarRefAssignExpress createVarRefAssignExp(Expression exp, VarRef varRef) {
		VarRefAssignExpress express = new VarRefAssignExpress(exp, varRef);
		return express;
	}

	public ContentBodyExpression createTemplateContent(BlockStatement block, GrammarToken token) {
		ContentBodyExpression express = new ContentBodyExpression(block, token);
		return express;
	}

	public FormatExpression createFormat(String name, String pattern, GrammarToken token) {
		FormatExpression f = new FormatExpression(name, pattern, token);
		return f;
	}


}
