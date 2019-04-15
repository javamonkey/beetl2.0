package org.beetl.core.engine;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.exception.BeetlException;
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

	public HashSet<String> getDisable() {
		return disable;
	}


	public void setDisable(HashSet<String> disable) {
		this.disable = disable;
	}


	/**
	 * 参考BeetlLexer.g4
	 * @param grammar
	 */
	public void disable(String grammar) {
		disable.add(grammar);
	}


	public VarAssignStatementSeq createVarAssignSeq(VarAssignStatement[] assings) {
		check("VarAssignSeq");
		return new VarAssignStatementSeq(assings, null);
	}

	public VarAssignStatement createVarAssign(Expression exp, GrammarToken token) {
		check("VarAssign");
		VarAssignStatement assign = new VarAssignStatement(exp, token);
		return assign;
	}

	public VarRefAssignStatement createVarRefAssign(Expression exp, VarRef varRef) {
		check("VarRefAssign");
		VarRefAssignStatement assign = new VarRefAssignStatement(exp, varRef);
		return assign;
	}

	public BlockStatement createBlock(Statement[] nodes, GrammarToken token) {
		BlockStatement block = new BlockStatement(nodes, token);
		return block;

	}

	public PlaceholderST createTextOutputSt(Expression exp, FormatExpression format) {
		check("TextOutputSt");
			return new PlaceholderST(exp, format, null);
	}

	public PlaceholderST createTextOutputSt2(Expression exp, FormatExpression format) {
		check("TextOutputSt2");
		return new PlaceholderST(exp, format, null);
	}

	public ReturnStatement createReturn(Expression exp) {
		check("Return");
		return new ReturnStatement(exp, null);
	}

	public BreakStatement createBreak(GrammarToken token) {
		check("Break");
		return new BreakStatement(token);
	}

	public ContinueStatement createContinue(GrammarToken token) {
		check("Continue");
		return new ContinueStatement(token);
	}

	public ForStatement createForIn(VarDefineNode forVar, Expression exp, boolean hasSafe, Statement forPart,
			Statement elseForPart, GrammarToken token) {
		check("ForIn");
		return new ForStatement(forVar, exp, hasSafe, forPart, elseForPart, forVar.token);
	}

	public GeneralForStatement createFor(VarAssignStatementSeq varAssignSeq, Expression[] expInit, Expression condtion,
			Expression[] expUpdate, Statement forPart, Statement elseforPart, GrammarToken token) {
		check("For");
		GeneralForStatement forStat = new GeneralForStatement(varAssignSeq, expInit, condtion, expUpdate, forPart,
				elseforPart, token);
		return forStat;
	}

	public WhileStatement createWhile(Expression exp, Statement whileBody, GrammarToken token) {
		check("While");
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
		check("If");
		return new IfStatement(condtion, ifStatement, elseStatement, token);
	}

	public StatementExpression createStatementExpression(Expression expression) {
		return new StatementExpression(expression, null);
	}

	public TryCatchStatement createTry(BlockStatement tryPart, BlockStatement catchPart, VarDefineNode error,
			GrammarToken token) {
		check("Try");
		TryCatchStatement statement = new TryCatchStatement(tryPart, catchPart, error, token);
		return statement;
	}

	public TagStatement createTag(String tagName, Expression[] expList, Statement block, GrammarToken token) {
		check("Tag");
		TagStatement tag = new TagStatement(tagName, expList, block, token);
		return tag;
	}

	public TagVarBindingStatement createVarTag(String tagName, Expression[] expList, Statement block,
			VarDefineNode[] varDefine, GrammarToken token) {
		check("VarTag");
		TagVarBindingStatement tag = new TagVarBindingStatement(tagName, expList, block, varDefine, token);
		return tag;
	}


	public SwitchStatement createSwitch(Expression value, LinkedHashMap<Expression, BlockStatement> map,
			BlockStatement defaultBlock, GrammarToken token) {
		check("Switch");
		SwitchStatement switchStat = new SwitchStatement(value, map, defaultBlock, token);
		return switchStat;
	}

	public SelectStatement createSelect(Expression value, Expression[] conditions, BlockStatement[] blocks,
			BlockStatement defaultBlock, GrammarToken token) {
		check("Select");
		SelectStatement select = new SelectStatement(value, conditions, blocks, defaultBlock, token);
		return select;
	}

	public AjaxStatement createAjax(BlockStatement block, GrammarToken token, boolean defaultRender) {
		check("Ajax");
		AjaxStatement ajaxStat = new AjaxStatement(block, token, defaultRender);
		return ajaxStat;
	}


	/* Express */

	public FunctionExpression createFunction(String name, Expression[] exps, VarAttribute[] vas, boolean hasSafe,
			Expression safeExp, GrammarToken token) {
		check("Function");
		FunctionExpression fe = new FunctionExpression(name, exps, vas, hasSafe, safeExp, token);
		return fe;
	}

	public Literal createLiteral(Object value, GrammarToken token) {
		Literal literal = new Literal(value, token);
		return literal;
	}

	public CompareExpression createCompare(Expression a, Expression b, short mode, GrammarToken token) {
		check("Compare");
		return new CompareExpression(a, b, mode, token);
	}

	public TernaryExpression createTernary(Expression condtion, Expression a, Expression b, GrammarToken token) {
		check("Ternary");
		return new TernaryExpression(condtion, a, b, token);
	}

	public ArthExpression createArth(Expression a, Expression b, short mode, GrammarToken token) {
		check("Arth");
		return new ArthExpression(a, b, mode, token);
	}

	public JsonArrayExpression createJasonArray(List<Expression> list, GrammarToken token) {
		check("JasonArray");
		return new JsonArrayExpression(list, token);
	}

	public JsonMapExpression createJsonMap(Map<String, Expression> map, GrammarToken token) {
		check("JsonMap");
		return new JsonMapExpression(map, token);
	}

	public FunctionExpression createFunctionExp(String name, Expression[] exps, VarAttribute[] vas, boolean hasSafe,
			Expression safeExp, GrammarToken token) {
		check("FunctionExp");
		FunctionExpression fe = new FunctionExpression(name, exps, vas, hasSafe, safeExp, token);
		return fe;
	}

	public NativeCallExpression createClassNativeCall(ClassNode clsNode, NativeNode[] chain, GrammarToken token) {
		check("ClassNativeCall");
		NativeCallExpression fe = new NativeCallExpression(clsNode, chain, token);
		return fe;
	}

	public NativeCallExpression createInstanceNativeCall(InstanceNode insNode, NativeNode[] chain, GrammarToken token) {
		check("InstanceNativeCall");
		NativeCallExpression fe = new NativeCallExpression(insNode, chain, token);
		return fe;
	}

	public AndExpression createAnd(Expression exp1, Expression exp2, GrammarToken token) {
		check("And");
		AndExpression andExp = new AndExpression(exp1, exp2, token);
		return andExp;
	}

	public OrExpression createOr(Expression exp1, Expression exp2, GrammarToken token) {
		check("Or");
		OrExpression andExp = new OrExpression(exp1, exp2, token);
		return andExp;
	}

	public NotBooleanExpression createNot(Expression exp, GrammarToken token) {
		check("Not");
		NotBooleanExpression notExp = new NotBooleanExpression(exp, token);
		return notExp;
	}

	public NegExpression createNeg(Expression exp, GrammarToken token) {
		check("Neg");
		NegExpression negExp = new NegExpression(exp, token);
		return negExp;
	}

	public IncDecExpression createIncDec(boolean isInc, boolean returnOrginal, GrammarToken token) {
		check("IncDec");
		IncDecExpression exp = new IncDecExpression(isInc, returnOrginal, token);
		return exp;
	}

	public VarRef createVarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, GrammarToken token,
			GrammarToken firstToken) {
		check("VarRef");
		VarRef express = new VarRef(attributes, hasSafe, safe, firstToken);
		return express;
	}

	public VarRefAssignExpress createVarRefAssignExp(Expression exp, VarRef varRef) {
		check("VarRefAssignExp");
		VarRefAssignExpress express = new VarRefAssignExpress(exp, varRef);
		return express;
	}

	public ContentBodyExpression createTemplateContent(BlockStatement block, GrammarToken token) {
		check("TemplateContent");
		ContentBodyExpression express = new ContentBodyExpression(block, token);
		return express;
	}

	public FormatExpression createFormat(String name, String pattern, GrammarToken token) {
		check("Format");
		FormatExpression f = new FormatExpression(name, pattern, token);
		return f;
	}

	private void check(String ast) {
		if (this.disable.contains(ast)) {
			throw new BeetlException(BeetlException.GRAMMAR_NOT_ALLOWED, "语法 " + ast + "不允许");
		}
	}


}
