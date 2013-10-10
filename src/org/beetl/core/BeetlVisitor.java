// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\Beetl.g4 by ANTLR 4.1

package org.beetl.core;




import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BeetlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BeetlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BeetlParser#classArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassArray(@NotNull BeetlParser.ClassArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull BeetlParser.AtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#g_caseStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG_caseStatment(@NotNull BeetlParser.G_caseStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textProcessFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextProcessFunction(@NotNull BeetlParser.TextProcessFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#caseStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatment(@NotNull BeetlParser.CaseStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#aexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr(@NotNull BeetlParser.AexprContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(@NotNull BeetlParser.VarRefContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#g_switchStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG_switchStatment(@NotNull BeetlParser.G_switchStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#safeOutput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSafeOutput(@NotNull BeetlParser.SafeOutputContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#breakStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatment(@NotNull BeetlParser.BreakStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextStatment(@NotNull BeetlParser.TextStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull BeetlParser.ProgContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull BeetlParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#switchStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatment(@NotNull BeetlParser.SwitchStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textformat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextformat(@NotNull BeetlParser.TextformatContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varAssignMent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignMent(@NotNull BeetlParser.VarAssignMentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(@NotNull BeetlParser.JsonContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#classNextExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassNextExp(@NotNull BeetlParser.ClassNextExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(@NotNull BeetlParser.StatementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#constantsTextStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantsTextStatment(@NotNull BeetlParser.ConstantsTextStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(@NotNull BeetlParser.ConditionalOrExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(@NotNull BeetlParser.DirectiveContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#condExpItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpItem(@NotNull BeetlParser.CondExpItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefine(@NotNull BeetlParser.VarDefineContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#classMutileExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMutileExp(@NotNull BeetlParser.ClassMutileExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#mexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMexpr(@NotNull BeetlParser.MexprContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#jsonKeyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValue(@NotNull BeetlParser.JsonKeyValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#returnStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatment(@NotNull BeetlParser.ReturnStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#messFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessFunction(@NotNull BeetlParser.MessFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextVar(@NotNull BeetlParser.TextVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(@NotNull BeetlParser.ConditionalAndExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAttribute(@NotNull BeetlParser.VarAttributeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#defaultStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStatment(@NotNull BeetlParser.DefaultStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#functionFullName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionFullName(@NotNull BeetlParser.FunctionFullNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#condExpNotItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpNotItem(@NotNull BeetlParser.CondExpNotItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#nativeMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeMethod(@NotNull BeetlParser.NativeMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#assignMent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignMent(@NotNull BeetlParser.AssignMentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BeetlParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull BeetlParser.ExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#g_defaultStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG_defaultStatment(@NotNull BeetlParser.G_defaultStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#condExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExp(@NotNull BeetlParser.CondExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#continueStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatment(@NotNull BeetlParser.ContinueStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#ifStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatment(@NotNull BeetlParser.IfStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#forStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatment(@NotNull BeetlParser.ForStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#classMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethod(@NotNull BeetlParser.ClassMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#unaryAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAtom(@NotNull BeetlParser.UnaryAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#statmentBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatmentBlock(@NotNull BeetlParser.StatmentBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#whileStament}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStament(@NotNull BeetlParser.WhileStamentContext ctx);
}