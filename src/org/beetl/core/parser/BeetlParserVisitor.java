// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\BeetlParser.g4 by ANTLR 4.1
package org.beetl.core.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BeetlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BeetlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BeetlParser#assignTemplateVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignTemplateVar(@NotNull BeetlParser.AssignTemplateVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull BeetlParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#g_caseStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG_caseStatment(@NotNull BeetlParser.G_caseStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#commentTagSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentTagSt(@NotNull BeetlParser.CommentTagStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(@NotNull BeetlParser.ExpressionListContext ctx);

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
	 * Visit a parse tree produced by {@link BeetlParser#continueSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueSt(@NotNull BeetlParser.ContinueStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull BeetlParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textformat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextformat(@NotNull BeetlParser.TextformatContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#commentTypeItemTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentTypeItemTag(@NotNull BeetlParser.CommentTypeItemTagContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#nativeVarRefChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeVarRefChain(@NotNull BeetlParser.NativeVarRefChainContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#siwchSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiwchSt(@NotNull BeetlParser.SiwchStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#selectSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSt(@NotNull BeetlParser.SelectStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextVar(@NotNull BeetlParser.TextVarContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#forSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForSt(@NotNull BeetlParser.ForStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#directiveSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectiveSt(@NotNull BeetlParser.DirectiveStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(@NotNull BeetlParser.TypeArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#textOutputSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextOutputSt(@NotNull BeetlParser.TextOutputStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varAttributeArrayOrMap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAttributeArrayOrMap(@NotNull BeetlParser.VarAttributeArrayOrMapContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(@NotNull BeetlParser.SwitchBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#ifSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSt(@NotNull BeetlParser.IfStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#nativeCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeCall(@NotNull BeetlParser.NativeCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(@NotNull BeetlParser.ConstantExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#assignId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignId(@NotNull BeetlParser.AssignIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(@NotNull BeetlParser.ForControlContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#nativeArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeArray(@NotNull BeetlParser.NativeArrayContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(@NotNull BeetlParser.ClassOrInterfaceTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#statmentExpSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatmentExpSt(@NotNull BeetlParser.StatmentExpStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varDeclareList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclareList(@NotNull BeetlParser.VarDeclareListContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(@NotNull BeetlParser.StatementExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varAttributeGeneral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAttributeGeneral(@NotNull BeetlParser.VarAttributeGeneralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull BeetlParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#directiveExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectiveExp(@NotNull BeetlParser.DirectiveExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(@NotNull BeetlParser.IntegerLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSt(@NotNull BeetlParser.VarStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#staticOutputSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticOutputSt(@NotNull BeetlParser.StaticOutputStContext ctx);

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
	 * Visit a parse tree produced by {@link BeetlParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(@NotNull BeetlParser.JsonContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#constantsTextStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantsTextStatment(@NotNull BeetlParser.ConstantsTextStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#trySt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrySt(@NotNull BeetlParser.TryStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#whileSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSt(@NotNull BeetlParser.WhileStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#jsonKeyValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonKeyValue(@NotNull BeetlParser.JsonKeyValueContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#varAttributeVirtual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAttributeVirtual(@NotNull BeetlParser.VarAttributeVirtualContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(@NotNull BeetlParser.ParExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(@NotNull BeetlParser.SwitchLabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#functionTagCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTagCall(@NotNull BeetlParser.FunctionTagCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#blockSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSt(@NotNull BeetlParser.BlockStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#commentTypeTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentTypeTag(@NotNull BeetlParser.CommentTypeTagContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#breakSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakSt(@NotNull BeetlParser.BreakStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#returnSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnSt(@NotNull BeetlParser.ReturnStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull BeetlParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#nativeMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNativeMethod(@NotNull BeetlParser.NativeMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull BeetlParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#g_defaultStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG_defaultStatment(@NotNull BeetlParser.G_defaultStatmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#assignGeneral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignGeneral(@NotNull BeetlParser.AssignGeneralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(@NotNull BeetlParser.TypeArgumentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#functionNs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionNs(@NotNull BeetlParser.FunctionNsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#functionSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSt(@NotNull BeetlParser.FunctionStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#assignSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSt(@NotNull BeetlParser.AssignStContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull BeetlParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link BeetlParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(@NotNull BeetlParser.SwitchBlockStatementGroupContext ctx);
}