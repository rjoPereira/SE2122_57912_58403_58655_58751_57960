// Generated from /home/ricardo/IdeaProjects/SE2122_57912_58403_58655_58751_57960/jabref/src/main/antlr4/org/jabref/search/Search.g4 by ANTLR 4.9.3
package org.jabref.search;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SearchParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SearchVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SearchParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(SearchParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(SearchParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(SearchParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(SearchParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link SearchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(SearchParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SearchParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(SearchParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link SearchParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(SearchParser.NameContext ctx);
}