// Generated from CFTransmission.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CFTransmissionParser}.
 */
public interface CFTransmissionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(@NotNull CFTransmissionParser.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(@NotNull CFTransmissionParser.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull CFTransmissionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull CFTransmissionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#quotedVariableName}.
	 * @param ctx the parse tree
	 */
	void enterQuotedVariableName(@NotNull CFTransmissionParser.QuotedVariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#quotedVariableName}.
	 * @param ctx the parse tree
	 */
	void exitQuotedVariableName(@NotNull CFTransmissionParser.QuotedVariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(@NotNull CFTransmissionParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(@NotNull CFTransmissionParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#variableNameFirst}.
	 * @param ctx the parse tree
	 */
	void enterVariableNameFirst(@NotNull CFTransmissionParser.VariableNameFirstContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#variableNameFirst}.
	 * @param ctx the parse tree
	 */
	void exitVariableNameFirst(@NotNull CFTransmissionParser.VariableNameFirstContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(@NotNull CFTransmissionParser.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(@NotNull CFTransmissionParser.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(@NotNull CFTransmissionParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(@NotNull CFTransmissionParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#validSecond}.
	 * @param ctx the parse tree
	 */
	void enterValidSecond(@NotNull CFTransmissionParser.ValidSecondContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#validSecond}.
	 * @param ctx the parse tree
	 */
	void exitValidSecond(@NotNull CFTransmissionParser.ValidSecondContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(@NotNull CFTransmissionParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(@NotNull CFTransmissionParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(@NotNull CFTransmissionParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(@NotNull CFTransmissionParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPropertyDeclaration(@NotNull CFTransmissionParser.PropertyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPropertyDeclaration(@NotNull CFTransmissionParser.PropertyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(@NotNull CFTransmissionParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(@NotNull CFTransmissionParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#nonVarVariableStatement}.
	 * @param ctx the parse tree
	 */
	void enterNonVarVariableStatement(@NotNull CFTransmissionParser.NonVarVariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#nonVarVariableStatement}.
	 * @param ctx the parse tree
	 */
	void exitNonVarVariableStatement(@NotNull CFTransmissionParser.NonVarVariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponent(@NotNull CFTransmissionParser.ComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponent(@NotNull CFTransmissionParser.ComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#expressionFirst}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFirst(@NotNull CFTransmissionParser.ExpressionFirstContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#expressionFirst}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFirst(@NotNull CFTransmissionParser.ExpressionFirstContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#argumentValue}.
	 * @param ctx the parse tree
	 */
	void enterArgumentValue(@NotNull CFTransmissionParser.ArgumentValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#argumentValue}.
	 * @param ctx the parse tree
	 */
	void exitArgumentValue(@NotNull CFTransmissionParser.ArgumentValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#argumentName}.
	 * @param ctx the parse tree
	 */
	void enterArgumentName(@NotNull CFTransmissionParser.ArgumentNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#argumentName}.
	 * @param ctx the parse tree
	 */
	void exitArgumentName(@NotNull CFTransmissionParser.ArgumentNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#expressionMethod}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMethod(@NotNull CFTransmissionParser.ExpressionMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#expressionMethod}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMethod(@NotNull CFTransmissionParser.ExpressionMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#saveContentStatement}.
	 * @param ctx the parse tree
	 */
	void enterSaveContentStatement(@NotNull CFTransmissionParser.SaveContentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#saveContentStatement}.
	 * @param ctx the parse tree
	 */
	void exitSaveContentStatement(@NotNull CFTransmissionParser.SaveContentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(@NotNull CFTransmissionParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(@NotNull CFTransmissionParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsDefinition(@NotNull CFTransmissionParser.ArgumentsDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#argumentsDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsDefinition(@NotNull CFTransmissionParser.ArgumentsDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull CFTransmissionParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull CFTransmissionParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#componentElement}.
	 * @param ctx the parse tree
	 */
	void enterComponentElement(@NotNull CFTransmissionParser.ComponentElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#componentElement}.
	 * @param ctx the parse tree
	 */
	void exitComponentElement(@NotNull CFTransmissionParser.ComponentElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(@NotNull CFTransmissionParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(@NotNull CFTransmissionParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull CFTransmissionParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull CFTransmissionParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull CFTransmissionParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull CFTransmissionParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#argumentDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArgumentDefinition(@NotNull CFTransmissionParser.ArgumentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#argumentDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArgumentDefinition(@NotNull CFTransmissionParser.ArgumentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull CFTransmissionParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull CFTransmissionParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(@NotNull CFTransmissionParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(@NotNull CFTransmissionParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(@NotNull CFTransmissionParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(@NotNull CFTransmissionParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#componentBody}.
	 * @param ctx the parse tree
	 */
	void enterComponentBody(@NotNull CFTransmissionParser.ComponentBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#componentBody}.
	 * @param ctx the parse tree
	 */
	void exitComponentBody(@NotNull CFTransmissionParser.ComponentBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#keyValue}.
	 * @param ctx the parse tree
	 */
	void enterKeyValue(@NotNull CFTransmissionParser.KeyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#keyValue}.
	 * @param ctx the parse tree
	 */
	void exitKeyValue(@NotNull CFTransmissionParser.KeyValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFTransmissionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull CFTransmissionParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFTransmissionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull CFTransmissionParser.LiteralContext ctx);
}