// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\Beetl.g4 by ANTLR 4.1

package org.beetl.core;




import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BeetlParser}.
 */
public interface BeetlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BeetlParser#classArray}.
	 * @param ctx the parse tree
	 */
	void enterClassArray(@NotNull BeetlParser.ClassArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#classArray}.
	 * @param ctx the parse tree
	 */
	void exitClassArray(@NotNull BeetlParser.ClassArrayContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull BeetlParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull BeetlParser.AtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#g_caseStatment}.
	 * @param ctx the parse tree
	 */
	void enterG_caseStatment(@NotNull BeetlParser.G_caseStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#g_caseStatment}.
	 * @param ctx the parse tree
	 */
	void exitG_caseStatment(@NotNull BeetlParser.G_caseStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#textProcessFunction}.
	 * @param ctx the parse tree
	 */
	void enterTextProcessFunction(@NotNull BeetlParser.TextProcessFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#textProcessFunction}.
	 * @param ctx the parse tree
	 */
	void exitTextProcessFunction(@NotNull BeetlParser.TextProcessFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#caseStatment}.
	 * @param ctx the parse tree
	 */
	void enterCaseStatment(@NotNull BeetlParser.CaseStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#caseStatment}.
	 * @param ctx the parse tree
	 */
	void exitCaseStatment(@NotNull BeetlParser.CaseStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(@NotNull BeetlParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(@NotNull BeetlParser.AexprContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varRef}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(@NotNull BeetlParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varRef}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(@NotNull BeetlParser.VarRefContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#g_switchStatment}.
	 * @param ctx the parse tree
	 */
	void enterG_switchStatment(@NotNull BeetlParser.G_switchStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#g_switchStatment}.
	 * @param ctx the parse tree
	 */
	void exitG_switchStatment(@NotNull BeetlParser.G_switchStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#safeOutput}.
	 * @param ctx the parse tree
	 */
	void enterSafeOutput(@NotNull BeetlParser.SafeOutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#safeOutput}.
	 * @param ctx the parse tree
	 */
	void exitSafeOutput(@NotNull BeetlParser.SafeOutputContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#breakStatment}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatment(@NotNull BeetlParser.BreakStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#breakStatment}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatment(@NotNull BeetlParser.BreakStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#textStatment}.
	 * @param ctx the parse tree
	 */
	void enterTextStatment(@NotNull BeetlParser.TextStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#textStatment}.
	 * @param ctx the parse tree
	 */
	void exitTextStatment(@NotNull BeetlParser.TextStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull BeetlParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull BeetlParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull BeetlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull BeetlParser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#switchStatment}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatment(@NotNull BeetlParser.SwitchStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#switchStatment}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatment(@NotNull BeetlParser.SwitchStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#textformat}.
	 * @param ctx the parse tree
	 */
	void enterTextformat(@NotNull BeetlParser.TextformatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#textformat}.
	 * @param ctx the parse tree
	 */
	void exitTextformat(@NotNull BeetlParser.TextformatContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varAssignMent}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignMent(@NotNull BeetlParser.VarAssignMentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varAssignMent}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignMent(@NotNull BeetlParser.VarAssignMentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(@NotNull BeetlParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(@NotNull BeetlParser.JsonContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#classNextExp}.
	 * @param ctx the parse tree
	 */
	void enterClassNextExp(@NotNull BeetlParser.ClassNextExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#classNextExp}.
	 * @param ctx the parse tree
	 */
	void exitClassNextExp(@NotNull BeetlParser.ClassNextExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(@NotNull BeetlParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(@NotNull BeetlParser.StatementsContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#constantsTextStatment}.
	 * @param ctx the parse tree
	 */
	void enterConstantsTextStatment(@NotNull BeetlParser.ConstantsTextStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#constantsTextStatment}.
	 * @param ctx the parse tree
	 */
	void exitConstantsTextStatment(@NotNull BeetlParser.ConstantsTextStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(@NotNull BeetlParser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(@NotNull BeetlParser.ConditionalOrExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(@NotNull BeetlParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(@NotNull BeetlParser.DirectiveContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#condExpItem}.
	 * @param ctx the parse tree
	 */
	void enterCondExpItem(@NotNull BeetlParser.CondExpItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#condExpItem}.
	 * @param ctx the parse tree
	 */
	void exitCondExpItem(@NotNull BeetlParser.CondExpItemContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varDefine}.
	 * @param ctx the parse tree
	 */
	void enterVarDefine(@NotNull BeetlParser.VarDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varDefine}.
	 * @param ctx the parse tree
	 */
	void exitVarDefine(@NotNull BeetlParser.VarDefineContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#classMutileExp}.
	 * @param ctx the parse tree
	 */
	void enterClassMutileExp(@NotNull BeetlParser.ClassMutileExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#classMutileExp}.
	 * @param ctx the parse tree
	 */
	void exitClassMutileExp(@NotNull BeetlParser.ClassMutileExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#mexpr}.
	 * @param ctx the parse tree
	 */
	void enterMexpr(@NotNull BeetlParser.MexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#mexpr}.
	 * @param ctx the parse tree
	 */
	void exitMexpr(@NotNull BeetlParser.MexprContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#jsonKeyValue}.
	 * @param ctx the parse tree
	 */
	void enterJsonKeyValue(@NotNull BeetlParser.JsonKeyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#jsonKeyValue}.
	 * @param ctx the parse tree
	 */
	void exitJsonKeyValue(@NotNull BeetlParser.JsonKeyValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatment(@NotNull BeetlParser.ReturnStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#returnStatment}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatment(@NotNull BeetlParser.ReturnStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#messFunction}.
	 * @param ctx the parse tree
	 */
	void enterMessFunction(@NotNull BeetlParser.MessFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#messFunction}.
	 * @param ctx the parse tree
	 */
	void exitMessFunction(@NotNull BeetlParser.MessFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#textVar}.
	 * @param ctx the parse tree
	 */
	void enterTextVar(@NotNull BeetlParser.TextVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#textVar}.
	 * @param ctx the parse tree
	 */
	void exitTextVar(@NotNull BeetlParser.TextVarContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(@NotNull BeetlParser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(@NotNull BeetlParser.ConditionalAndExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varAttribute}.
	 * @param ctx the parse tree
	 */
	void enterVarAttribute(@NotNull BeetlParser.VarAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varAttribute}.
	 * @param ctx the parse tree
	 */
	void exitVarAttribute(@NotNull BeetlParser.VarAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#defaultStatment}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStatment(@NotNull BeetlParser.DefaultStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#defaultStatment}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStatment(@NotNull BeetlParser.DefaultStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#functionFullName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionFullName(@NotNull BeetlParser.FunctionFullNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#functionFullName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionFullName(@NotNull BeetlParser.FunctionFullNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#condExpNotItem}.
	 * @param ctx the parse tree
	 */
	void enterCondExpNotItem(@NotNull BeetlParser.CondExpNotItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#condExpNotItem}.
	 * @param ctx the parse tree
	 */
	void exitCondExpNotItem(@NotNull BeetlParser.CondExpNotItemContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#nativeMethod}.
	 * @param ctx the parse tree
	 */
	void enterNativeMethod(@NotNull BeetlParser.NativeMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#nativeMethod}.
	 * @param ctx the parse tree
	 */
	void exitNativeMethod(@NotNull BeetlParser.NativeMethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#assignMent}.
	 * @param ctx the parse tree
	 */
	void enterAssignMent(@NotNull BeetlParser.AssignMentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#assignMent}.
	 * @param ctx the parse tree
	 */
	void exitAssignMent(@NotNull BeetlParser.AssignMentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull BeetlParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull BeetlParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull BeetlParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull BeetlParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#g_defaultStatment}.
	 * @param ctx the parse tree
	 */
	void enterG_defaultStatment(@NotNull BeetlParser.G_defaultStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#g_defaultStatment}.
	 * @param ctx the parse tree
	 */
	void exitG_defaultStatment(@NotNull BeetlParser.G_defaultStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#condExp}.
	 * @param ctx the parse tree
	 */
	void enterCondExp(@NotNull BeetlParser.CondExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#condExp}.
	 * @param ctx the parse tree
	 */
	void exitCondExp(@NotNull BeetlParser.CondExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#continueStatment}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatment(@NotNull BeetlParser.ContinueStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#continueStatment}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatment(@NotNull BeetlParser.ContinueStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#ifStatment}.
	 * @param ctx the parse tree
	 */
	void enterIfStatment(@NotNull BeetlParser.IfStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#ifStatment}.
	 * @param ctx the parse tree
	 */
	void exitIfStatment(@NotNull BeetlParser.IfStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#forStatment}.
	 * @param ctx the parse tree
	 */
	void enterForStatment(@NotNull BeetlParser.ForStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#forStatment}.
	 * @param ctx the parse tree
	 */
	void exitForStatment(@NotNull BeetlParser.ForStatmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void enterClassMethod(@NotNull BeetlParser.ClassMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void exitClassMethod(@NotNull BeetlParser.ClassMethodContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#unaryAtom}.
	 * @param ctx the parse tree
	 */
	void enterUnaryAtom(@NotNull BeetlParser.UnaryAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#unaryAtom}.
	 * @param ctx the parse tree
	 */
	void exitUnaryAtom(@NotNull BeetlParser.UnaryAtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#statmentBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatmentBlock(@NotNull BeetlParser.StatmentBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#statmentBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatmentBlock(@NotNull BeetlParser.StatmentBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#whileStament}.
	 * @param ctx the parse tree
	 */
	void enterWhileStament(@NotNull BeetlParser.WhileStamentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#whileStament}.
	 * @param ctx the parse tree
	 */
	void exitWhileStament(@NotNull BeetlParser.WhileStamentContext ctx);
}