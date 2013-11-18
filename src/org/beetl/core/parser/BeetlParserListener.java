// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\BeetlParser.g4 by ANTLR 4.1
package org.beetl.core.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BeetlParser}.
 */
public interface BeetlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BeetlParser#assignTemplateVar}.
	 * @param ctx the parse tree
	 */
	void enterAssignTemplateVar(@NotNull BeetlParser.AssignTemplateVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#assignTemplateVar}.
	 * @param ctx the parse tree
	 */
	void exitAssignTemplateVar(@NotNull BeetlParser.AssignTemplateVarContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#parExp}.
	 * @param ctx the parse tree
	 */
	void enterParExp(@NotNull BeetlParser.ParExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#parExp}.
	 * @param ctx the parse tree
	 */
	void exitParExp(@NotNull BeetlParser.ParExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#commentTagSt}.
	 * @param ctx the parse tree
	 */
	void enterCommentTagSt(@NotNull BeetlParser.CommentTagStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#commentTagSt}.
	 * @param ctx the parse tree
	 */
	void exitCommentTagSt(@NotNull BeetlParser.CommentTagStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull BeetlParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull BeetlParser.ExpressionListContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#notExp}.
	 * @param ctx the parse tree
	 */
	void enterNotExp(@NotNull BeetlParser.NotExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#notExp}.
	 * @param ctx the parse tree
	 */
	void exitNotExp(@NotNull BeetlParser.NotExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#addminExp}.
	 * @param ctx the parse tree
	 */
	void enterAddminExp(@NotNull BeetlParser.AddminExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#addminExp}.
	 * @param ctx the parse tree
	 */
	void exitAddminExp(@NotNull BeetlParser.AddminExpContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#continueSt}.
	 * @param ctx the parse tree
	 */
	void enterContinueSt(@NotNull BeetlParser.ContinueStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#continueSt}.
	 * @param ctx the parse tree
	 */
	void exitContinueSt(@NotNull BeetlParser.ContinueStContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#commentTypeItemTag}.
	 * @param ctx the parse tree
	 */
	void enterCommentTypeItemTag(@NotNull BeetlParser.CommentTypeItemTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#commentTypeItemTag}.
	 * @param ctx the parse tree
	 */
	void exitCommentTypeItemTag(@NotNull BeetlParser.CommentTypeItemTagContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#jsonExp}.
	 * @param ctx the parse tree
	 */
	void enterJsonExp(@NotNull BeetlParser.JsonExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#jsonExp}.
	 * @param ctx the parse tree
	 */
	void exitJsonExp(@NotNull BeetlParser.JsonExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#nativeVarRefChain}.
	 * @param ctx the parse tree
	 */
	void enterNativeVarRefChain(@NotNull BeetlParser.NativeVarRefChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#nativeVarRefChain}.
	 * @param ctx the parse tree
	 */
	void exitNativeVarRefChain(@NotNull BeetlParser.NativeVarRefChainContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#siwchSt}.
	 * @param ctx the parse tree
	 */
	void enterSiwchSt(@NotNull BeetlParser.SiwchStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#siwchSt}.
	 * @param ctx the parse tree
	 */
	void exitSiwchSt(@NotNull BeetlParser.SiwchStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#selectSt}.
	 * @param ctx the parse tree
	 */
	void enterSelectSt(@NotNull BeetlParser.SelectStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#selectSt}.
	 * @param ctx the parse tree
	 */
	void exitSelectSt(@NotNull BeetlParser.SelectStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#negExp}.
	 * @param ctx the parse tree
	 */
	void enterNegExp(@NotNull BeetlParser.NegExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#negExp}.
	 * @param ctx the parse tree
	 */
	void exitNegExp(@NotNull BeetlParser.NegExpContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#forSt}.
	 * @param ctx the parse tree
	 */
	void enterForSt(@NotNull BeetlParser.ForStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#forSt}.
	 * @param ctx the parse tree
	 */
	void exitForSt(@NotNull BeetlParser.ForStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#orExp}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(@NotNull BeetlParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#orExp}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(@NotNull BeetlParser.OrExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#directiveSt}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveSt(@NotNull BeetlParser.DirectiveStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#directiveSt}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveSt(@NotNull BeetlParser.DirectiveStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(@NotNull BeetlParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(@NotNull BeetlParser.TypeArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#textOutputSt}.
	 * @param ctx the parse tree
	 */
	void enterTextOutputSt(@NotNull BeetlParser.TextOutputStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#textOutputSt}.
	 * @param ctx the parse tree
	 */
	void exitTextOutputSt(@NotNull BeetlParser.TextOutputStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varAttributeArrayOrMap}.
	 * @param ctx the parse tree
	 */
	void enterVarAttributeArrayOrMap(@NotNull BeetlParser.VarAttributeArrayOrMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varAttributeArrayOrMap}.
	 * @param ctx the parse tree
	 */
	void exitVarAttributeArrayOrMap(@NotNull BeetlParser.VarAttributeArrayOrMapContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(@NotNull BeetlParser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(@NotNull BeetlParser.SwitchBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#ifSt}.
	 * @param ctx the parse tree
	 */
	void enterIfSt(@NotNull BeetlParser.IfStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#ifSt}.
	 * @param ctx the parse tree
	 */
	void exitIfSt(@NotNull BeetlParser.IfStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#nativeCall}.
	 * @param ctx the parse tree
	 */
	void enterNativeCall(@NotNull BeetlParser.NativeCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#nativeCall}.
	 * @param ctx the parse tree
	 */
	void exitNativeCall(@NotNull BeetlParser.NativeCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(@NotNull BeetlParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(@NotNull BeetlParser.ConstantExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#muldivmodExp}.
	 * @param ctx the parse tree
	 */
	void enterMuldivmodExp(@NotNull BeetlParser.MuldivmodExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#muldivmodExp}.
	 * @param ctx the parse tree
	 */
	void exitMuldivmodExp(@NotNull BeetlParser.MuldivmodExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#assignId}.
	 * @param ctx the parse tree
	 */
	void enterAssignId(@NotNull BeetlParser.AssignIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#assignId}.
	 * @param ctx the parse tree
	 */
	void exitAssignId(@NotNull BeetlParser.AssignIdContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(@NotNull BeetlParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(@NotNull BeetlParser.ForControlContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#nativeArray}.
	 * @param ctx the parse tree
	 */
	void enterNativeArray(@NotNull BeetlParser.NativeArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#nativeArray}.
	 * @param ctx the parse tree
	 */
	void exitNativeArray(@NotNull BeetlParser.NativeArrayContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#literalExp}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExp(@NotNull BeetlParser.LiteralExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#literalExp}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExp(@NotNull BeetlParser.LiteralExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varAttributeGeneral}.
	 * @param ctx the parse tree
	 */
	void enterVarAttributeGeneral(@NotNull BeetlParser.VarAttributeGeneralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varAttributeGeneral}.
	 * @param ctx the parse tree
	 */
	void exitVarAttributeGeneral(@NotNull BeetlParser.VarAttributeGeneralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(@NotNull BeetlParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(@NotNull BeetlParser.ClassOrInterfaceTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#statmentExpSt}.
	 * @param ctx the parse tree
	 */
	void enterStatmentExpSt(@NotNull BeetlParser.StatmentExpStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#statmentExpSt}.
	 * @param ctx the parse tree
	 */
	void exitStatmentExpSt(@NotNull BeetlParser.StatmentExpStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varDeclareList}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclareList(@NotNull BeetlParser.VarDeclareListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varDeclareList}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclareList(@NotNull BeetlParser.VarDeclareListContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(@NotNull BeetlParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(@NotNull BeetlParser.StatementExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull BeetlParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull BeetlParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#directiveExp}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveExp(@NotNull BeetlParser.DirectiveExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#directiveExp}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveExp(@NotNull BeetlParser.DirectiveExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varSt}.
	 * @param ctx the parse tree
	 */
	void enterVarSt(@NotNull BeetlParser.VarStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varSt}.
	 * @param ctx the parse tree
	 */
	void exitVarSt(@NotNull BeetlParser.VarStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#staticOutputSt}.
	 * @param ctx the parse tree
	 */
	void enterStaticOutputSt(@NotNull BeetlParser.StaticOutputStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#staticOutputSt}.
	 * @param ctx the parse tree
	 */
	void exitStaticOutputSt(@NotNull BeetlParser.StaticOutputStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#varRefExp}.
	 * @param ctx the parse tree
	 */
	void enterVarRefExp(@NotNull BeetlParser.VarRefExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varRefExp}.
	 * @param ctx the parse tree
	 */
	void exitVarRefExp(@NotNull BeetlParser.VarRefExpContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#ternaryExp}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExp(@NotNull BeetlParser.TernaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#ternaryExp}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExp(@NotNull BeetlParser.TernaryExpContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#nativeCallExp}.
	 * @param ctx the parse tree
	 */
	void enterNativeCallExp(@NotNull BeetlParser.NativeCallExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#nativeCallExp}.
	 * @param ctx the parse tree
	 */
	void exitNativeCallExp(@NotNull BeetlParser.NativeCallExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#trySt}.
	 * @param ctx the parse tree
	 */
	void enterTrySt(@NotNull BeetlParser.TryStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#trySt}.
	 * @param ctx the parse tree
	 */
	void exitTrySt(@NotNull BeetlParser.TryStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#whileSt}.
	 * @param ctx the parse tree
	 */
	void enterWhileSt(@NotNull BeetlParser.WhileStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#whileSt}.
	 * @param ctx the parse tree
	 */
	void exitWhileSt(@NotNull BeetlParser.WhileStContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#varAttributeVirtual}.
	 * @param ctx the parse tree
	 */
	void enterVarAttributeVirtual(@NotNull BeetlParser.VarAttributeVirtualContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#varAttributeVirtual}.
	 * @param ctx the parse tree
	 */
	void exitVarAttributeVirtual(@NotNull BeetlParser.VarAttributeVirtualContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#compareExp}.
	 * @param ctx the parse tree
	 */
	void enterCompareExp(@NotNull BeetlParser.CompareExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#compareExp}.
	 * @param ctx the parse tree
	 */
	void exitCompareExp(@NotNull BeetlParser.CompareExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#equalExp}.
	 * @param ctx the parse tree
	 */
	void enterEqualExp(@NotNull BeetlParser.EqualExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#equalExp}.
	 * @param ctx the parse tree
	 */
	void exitEqualExp(@NotNull BeetlParser.EqualExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(@NotNull BeetlParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(@NotNull BeetlParser.ParExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(@NotNull BeetlParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(@NotNull BeetlParser.SwitchLabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#functionTagCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTagCall(@NotNull BeetlParser.FunctionTagCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#functionTagCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTagCall(@NotNull BeetlParser.FunctionTagCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#blockSt}.
	 * @param ctx the parse tree
	 */
	void enterBlockSt(@NotNull BeetlParser.BlockStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#blockSt}.
	 * @param ctx the parse tree
	 */
	void exitBlockSt(@NotNull BeetlParser.BlockStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#commentTypeTag}.
	 * @param ctx the parse tree
	 */
	void enterCommentTypeTag(@NotNull BeetlParser.CommentTypeTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#commentTypeTag}.
	 * @param ctx the parse tree
	 */
	void exitCommentTypeTag(@NotNull BeetlParser.CommentTypeTagContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#breakSt}.
	 * @param ctx the parse tree
	 */
	void enterBreakSt(@NotNull BeetlParser.BreakStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#breakSt}.
	 * @param ctx the parse tree
	 */
	void exitBreakSt(@NotNull BeetlParser.BreakStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#returnSt}.
	 * @param ctx the parse tree
	 */
	void enterReturnSt(@NotNull BeetlParser.ReturnStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#returnSt}.
	 * @param ctx the parse tree
	 */
	void exitReturnSt(@NotNull BeetlParser.ReturnStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull BeetlParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull BeetlParser.BooleanLiteralContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#andExp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(@NotNull BeetlParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#andExp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(@NotNull BeetlParser.AndExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#functionCallExp}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExp(@NotNull BeetlParser.FunctionCallExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#functionCallExp}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExp(@NotNull BeetlParser.FunctionCallExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull BeetlParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull BeetlParser.ArgumentsContext ctx);

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
	 * Enter a parse tree produced by {@link BeetlParser#assignGeneral}.
	 * @param ctx the parse tree
	 */
	void enterAssignGeneral(@NotNull BeetlParser.AssignGeneralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#assignGeneral}.
	 * @param ctx the parse tree
	 */
	void exitAssignGeneral(@NotNull BeetlParser.AssignGeneralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(@NotNull BeetlParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(@NotNull BeetlParser.TypeArgumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#functionNs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionNs(@NotNull BeetlParser.FunctionNsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#functionNs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionNs(@NotNull BeetlParser.FunctionNsContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#functionSt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSt(@NotNull BeetlParser.FunctionStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#functionSt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSt(@NotNull BeetlParser.FunctionStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#assignSt}.
	 * @param ctx the parse tree
	 */
	void enterAssignSt(@NotNull BeetlParser.AssignStContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#assignSt}.
	 * @param ctx the parse tree
	 */
	void exitAssignSt(@NotNull BeetlParser.AssignStContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull BeetlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull BeetlParser.LiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link BeetlParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(@NotNull BeetlParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link BeetlParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(@NotNull BeetlParser.SwitchBlockStatementGroupContext ctx);
}