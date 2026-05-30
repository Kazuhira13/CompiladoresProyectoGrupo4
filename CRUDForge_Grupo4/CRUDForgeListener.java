// Generated from CRUDForge.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CRUDForgeParser}.
 */
public interface CRUDForgeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CRUDForgeParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CRUDForgeParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityDecl(CRUDForgeParser.EntityDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityDecl(CRUDForgeParser.EntityDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#fieldsBlock}.
	 * @param ctx the parse tree
	 */
	void enterFieldsBlock(CRUDForgeParser.FieldsBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#fieldsBlock}.
	 * @param ctx the parse tree
	 */
	void exitFieldsBlock(CRUDForgeParser.FieldsBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(CRUDForgeParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(CRUDForgeParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CRUDForgeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CRUDForgeParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(CRUDForgeParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(CRUDForgeParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#indexesBlock}.
	 * @param ctx the parse tree
	 */
	void enterIndexesBlock(CRUDForgeParser.IndexesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#indexesBlock}.
	 * @param ctx the parse tree
	 */
	void exitIndexesBlock(CRUDForgeParser.IndexesBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#apiBlock}.
	 * @param ctx the parse tree
	 */
	void enterApiBlock(CRUDForgeParser.ApiBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#apiBlock}.
	 * @param ctx the parse tree
	 */
	void exitApiBlock(CRUDForgeParser.ApiBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#uiBlock}.
	 * @param ctx the parse tree
	 */
	void enterUiBlock(CRUDForgeParser.UiBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#uiBlock}.
	 * @param ctx the parse tree
	 */
	void exitUiBlock(CRUDForgeParser.UiBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#apiMode}.
	 * @param ctx the parse tree
	 */
	void enterApiMode(CRUDForgeParser.ApiModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#apiMode}.
	 * @param ctx the parse tree
	 */
	void exitApiMode(CRUDForgeParser.ApiModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#apiOption}.
	 * @param ctx the parse tree
	 */
	void enterApiOption(CRUDForgeParser.ApiOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#apiOption}.
	 * @param ctx the parse tree
	 */
	void exitApiOption(CRUDForgeParser.ApiOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#uiOption}.
	 * @param ctx the parse tree
	 */
	void enterUiOption(CRUDForgeParser.UiOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#uiOption}.
	 * @param ctx the parse tree
	 */
	void exitUiOption(CRUDForgeParser.UiOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(CRUDForgeParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(CRUDForgeParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDForgeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CRUDForgeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDForgeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CRUDForgeParser.LiteralContext ctx);
}