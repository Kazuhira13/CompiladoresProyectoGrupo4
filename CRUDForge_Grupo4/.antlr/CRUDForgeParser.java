// Generated from c:/Users/tgpp1/OneDrive/Desktop/Compiladores/CRUDForge_Grupo4/CRUDForge.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CRUDForgeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENTITY=1, FIELDS=2, INDEXES=3, API=4, UI=5, WITH=6, GENERATE=7, FULL=8, 
		BASIC=9, PAGINATION=10, SEARCH=11, FILTERS=12, SORTABLE=13, UUID=14, STRING=15, 
		INT=16, DECIMAL=17, BOOL=18, DATE=19, REFERENCE=20, PK=21, REQUIRED=22, 
		MIN=23, DEFAULT=24, UNIQUE=25, GT=26, LT=27, COLON=28, COMMA=29, EQUAL=30, 
		NUMBER=31, ID=32, STRING_LITERAL=33, WS=34, COMMENT=35;
	public static final int
		RULE_start = 0, RULE_entityDecl = 1, RULE_fieldsBlock = 2, RULE_fieldDecl = 3, 
		RULE_type = 4, RULE_constraint = 5, RULE_indexesBlock = 6, RULE_apiBlock = 7, 
		RULE_uiBlock = 8, RULE_apiMode = 9, RULE_apiOption = 10, RULE_uiOption = 11, 
		RULE_idList = 12, RULE_literal = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "entityDecl", "fieldsBlock", "fieldDecl", "type", "constraint", 
			"indexesBlock", "apiBlock", "uiBlock", "apiMode", "apiOption", "uiOption", 
			"idList", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'entity'", "'fields'", "'indexes'", "'api'", "'ui'", "'with'", 
			"'generate'", "'full'", "'basic'", "'pagination'", "'search'", "'filters'", 
			"'sortable'", "'uuid'", "'string'", "'int'", "'decimal'", "'bool'", "'date'", 
			"'reference'", "'pk'", "'required'", "'min'", "'default'", "'unique'", 
			"'>'", "'<'", "':'", "','", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ENTITY", "FIELDS", "INDEXES", "API", "UI", "WITH", "GENERATE", 
			"FULL", "BASIC", "PAGINATION", "SEARCH", "FILTERS", "SORTABLE", "UUID", 
			"STRING", "INT", "DECIMAL", "BOOL", "DATE", "REFERENCE", "PK", "REQUIRED", 
			"MIN", "DEFAULT", "UNIQUE", "GT", "LT", "COLON", "COMMA", "EQUAL", "NUMBER", 
			"ID", "STRING_LITERAL", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CRUDForge.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CRUDForgeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public EntityDeclContext entityDecl() {
			return getRuleContext(EntityDeclContext.class,0);
		}
		public FieldsBlockContext fieldsBlock() {
			return getRuleContext(FieldsBlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CRUDForgeParser.EOF, 0); }
		public IndexesBlockContext indexesBlock() {
			return getRuleContext(IndexesBlockContext.class,0);
		}
		public ApiBlockContext apiBlock() {
			return getRuleContext(ApiBlockContext.class,0);
		}
		public UiBlockContext uiBlock() {
			return getRuleContext(UiBlockContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			entityDecl();
			setState(29);
			fieldsBlock();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INDEXES) {
				{
				setState(30);
				indexesBlock();
				}
			}

			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==API) {
				{
				setState(33);
				apiBlock();
				}
			}

			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UI) {
				{
				setState(36);
				uiBlock();
				}
			}

			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EntityDeclContext extends ParserRuleContext {
		public TerminalNode ENTITY() { return getToken(CRUDForgeParser.ENTITY, 0); }
		public TerminalNode ID() { return getToken(CRUDForgeParser.ID, 0); }
		public EntityDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityDecl; }
	}

	public final EntityDeclContext entityDecl() throws RecognitionException {
		EntityDeclContext _localctx = new EntityDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entityDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(ENTITY);
			setState(42);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldsBlockContext extends ParserRuleContext {
		public TerminalNode FIELDS() { return getToken(CRUDForgeParser.FIELDS, 0); }
		public TerminalNode COLON() { return getToken(CRUDForgeParser.COLON, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public FieldsBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldsBlock; }
	}

	public final FieldsBlockContext fieldsBlock() throws RecognitionException {
		FieldsBlockContext _localctx = new FieldsBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fieldsBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(FIELDS);
			setState(45);
			match(COLON);
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				fieldDecl();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CRUDForgeParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(ID);
			setState(52);
			type();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266338304L) != 0)) {
				{
				{
				setState(53);
				constraint();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode UUID() { return getToken(CRUDForgeParser.UUID, 0); }
		public TerminalNode STRING() { return getToken(CRUDForgeParser.STRING, 0); }
		public TerminalNode INT() { return getToken(CRUDForgeParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(CRUDForgeParser.DECIMAL, 0); }
		public TerminalNode BOOL() { return getToken(CRUDForgeParser.BOOL, 0); }
		public TerminalNode DATE() { return getToken(CRUDForgeParser.DATE, 0); }
		public TerminalNode REFERENCE() { return getToken(CRUDForgeParser.REFERENCE, 0); }
		public TerminalNode ID() { return getToken(CRUDForgeParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UUID:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(UUID);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(INT);
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(DECIMAL);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				match(BOOL);
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				match(DATE);
				}
				break;
			case REFERENCE:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				match(REFERENCE);
				setState(66);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstraintContext extends ParserRuleContext {
		public TerminalNode PK() { return getToken(CRUDForgeParser.PK, 0); }
		public TerminalNode REQUIRED() { return getToken(CRUDForgeParser.REQUIRED, 0); }
		public TerminalNode MIN() { return getToken(CRUDForgeParser.MIN, 0); }
		public TerminalNode EQUAL() { return getToken(CRUDForgeParser.EQUAL, 0); }
		public TerminalNode NUMBER() { return getToken(CRUDForgeParser.NUMBER, 0); }
		public TerminalNode DEFAULT() { return getToken(CRUDForgeParser.DEFAULT, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode GT() { return getToken(CRUDForgeParser.GT, 0); }
		public TerminalNode LT() { return getToken(CRUDForgeParser.LT, 0); }
		public TerminalNode UNIQUE() { return getToken(CRUDForgeParser.UNIQUE, 0); }
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constraint);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PK:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(PK);
				}
				break;
			case REQUIRED:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(REQUIRED);
				}
				break;
			case MIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(MIN);
				setState(72);
				match(EQUAL);
				setState(73);
				match(NUMBER);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(DEFAULT);
				setState(75);
				match(EQUAL);
				setState(76);
				literal();
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				match(GT);
				setState(78);
				match(NUMBER);
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(LT);
				setState(80);
				match(NUMBER);
				}
				break;
			case UNIQUE:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				match(UNIQUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexesBlockContext extends ParserRuleContext {
		public TerminalNode INDEXES() { return getToken(CRUDForgeParser.INDEXES, 0); }
		public TerminalNode COLON() { return getToken(CRUDForgeParser.COLON, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public IndexesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexesBlock; }
	}

	public final IndexesBlockContext indexesBlock() throws RecognitionException {
		IndexesBlockContext _localctx = new IndexesBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_indexesBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(INDEXES);
			setState(85);
			match(COLON);
			setState(86);
			idList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApiBlockContext extends ParserRuleContext {
		public TerminalNode API() { return getToken(CRUDForgeParser.API, 0); }
		public ApiModeContext apiMode() {
			return getRuleContext(ApiModeContext.class,0);
		}
		public TerminalNode WITH() { return getToken(CRUDForgeParser.WITH, 0); }
		public List<ApiOptionContext> apiOption() {
			return getRuleContexts(ApiOptionContext.class);
		}
		public ApiOptionContext apiOption(int i) {
			return getRuleContext(ApiOptionContext.class,i);
		}
		public ApiBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apiBlock; }
	}

	public final ApiBlockContext apiBlock() throws RecognitionException {
		ApiBlockContext _localctx = new ApiBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_apiBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(API);
			setState(89);
			apiMode();
			setState(90);
			match(WITH);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				apiOption();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PAGINATION || _la==SEARCH );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UiBlockContext extends ParserRuleContext {
		public TerminalNode UI() { return getToken(CRUDForgeParser.UI, 0); }
		public TerminalNode GENERATE() { return getToken(CRUDForgeParser.GENERATE, 0); }
		public TerminalNode WITH() { return getToken(CRUDForgeParser.WITH, 0); }
		public List<UiOptionContext> uiOption() {
			return getRuleContexts(UiOptionContext.class);
		}
		public UiOptionContext uiOption(int i) {
			return getRuleContext(UiOptionContext.class,i);
		}
		public UiBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uiBlock; }
	}

	public final UiBlockContext uiBlock() throws RecognitionException {
		UiBlockContext _localctx = new UiBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_uiBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(UI);
			setState(97);
			match(GENERATE);
			setState(98);
			match(WITH);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				uiOption();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FILTERS || _la==SORTABLE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApiModeContext extends ParserRuleContext {
		public TerminalNode FULL() { return getToken(CRUDForgeParser.FULL, 0); }
		public TerminalNode BASIC() { return getToken(CRUDForgeParser.BASIC, 0); }
		public ApiModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apiMode; }
	}

	public final ApiModeContext apiMode() throws RecognitionException {
		ApiModeContext _localctx = new ApiModeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_apiMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==FULL || _la==BASIC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApiOptionContext extends ParserRuleContext {
		public TerminalNode PAGINATION() { return getToken(CRUDForgeParser.PAGINATION, 0); }
		public TerminalNode SEARCH() { return getToken(CRUDForgeParser.SEARCH, 0); }
		public ApiOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apiOption; }
	}

	public final ApiOptionContext apiOption() throws RecognitionException {
		ApiOptionContext _localctx = new ApiOptionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_apiOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==PAGINATION || _la==SEARCH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UiOptionContext extends ParserRuleContext {
		public TerminalNode FILTERS() { return getToken(CRUDForgeParser.FILTERS, 0); }
		public TerminalNode SORTABLE() { return getToken(CRUDForgeParser.SORTABLE, 0); }
		public UiOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uiOption; }
	}

	public final UiOptionContext uiOption() throws RecognitionException {
		UiOptionContext _localctx = new UiOptionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_uiOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==FILTERS || _la==SORTABLE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CRUDForgeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CRUDForgeParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CRUDForgeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CRUDForgeParser.COMMA, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(ID);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(111);
				match(COMMA);
				setState(112);
				match(ID);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CRUDForgeParser.NUMBER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(CRUDForgeParser.STRING_LITERAL, 0); }
		public TerminalNode ID() { return getToken(CRUDForgeParser.ID, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001#y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000 \b"+
		"\u0000\u0001\u0000\u0003\u0000#\b\u0000\u0001\u0000\u0003\u0000&\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0004\u00020\b\u0002\u000b\u0002\f\u00021\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u00037\b\u0003\n\u0003\f\u0003:\t"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004D\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005S\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007]\b\u0007\u000b"+
		"\u0007\f\u0007^\u0001\b\u0001\b\u0001\b\u0001\b\u0004\be\b\b\u000b\b\f"+
		"\bf\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0005\fr\b\f\n\f\f\fu\t\f\u0001\r\u0001\r\u0001\r\u0000\u0000"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0004\u0001\u0000\b\t\u0001\u0000\n\u000b\u0001\u0000\f\r"+
		"\u0001\u0000\u001f!~\u0000\u001c\u0001\u0000\u0000\u0000\u0002)\u0001"+
		"\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000"+
		"\u0000\bC\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000\u0000\fT\u0001"+
		"\u0000\u0000\u0000\u000eX\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000"+
		"\u0000\u0012h\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016"+
		"l\u0001\u0000\u0000\u0000\u0018n\u0001\u0000\u0000\u0000\u001av\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d\u001f\u0003"+
		"\u0004\u0002\u0000\u001e \u0003\f\u0006\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0001\u0000\u0000\u0000"+
		"!#\u0003\u000e\u0007\u0000\"!\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#%\u0001\u0000\u0000\u0000$&\u0003\u0010\b\u0000%$\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0005\u0000"+
		"\u0000\u0001(\u0001\u0001\u0000\u0000\u0000)*\u0005\u0001\u0000\u0000"+
		"*+\u0005 \u0000\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0005\u0002\u0000"+
		"\u0000-/\u0005\u001c\u0000\u0000.0\u0003\u0006\u0003\u0000/.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u00002\u0005\u0001\u0000\u0000\u000034\u0005 \u0000\u0000"+
		"48\u0003\b\u0004\u000057\u0003\n\u0005\u000065\u0001\u0000\u0000\u0000"+
		"7:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009\u0007\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;D\u0005"+
		"\u000e\u0000\u0000<D\u0005\u000f\u0000\u0000=D\u0005\u0010\u0000\u0000"+
		">D\u0005\u0011\u0000\u0000?D\u0005\u0012\u0000\u0000@D\u0005\u0013\u0000"+
		"\u0000AB\u0005\u0014\u0000\u0000BD\u0005 \u0000\u0000C;\u0001\u0000\u0000"+
		"\u0000C<\u0001\u0000\u0000\u0000C=\u0001\u0000\u0000\u0000C>\u0001\u0000"+
		"\u0000\u0000C?\u0001\u0000\u0000\u0000C@\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000D\t\u0001\u0000\u0000\u0000ES\u0005\u0015\u0000\u0000"+
		"FS\u0005\u0016\u0000\u0000GH\u0005\u0017\u0000\u0000HI\u0005\u001e\u0000"+
		"\u0000IS\u0005\u001f\u0000\u0000JK\u0005\u0018\u0000\u0000KL\u0005\u001e"+
		"\u0000\u0000LS\u0003\u001a\r\u0000MN\u0005\u001a\u0000\u0000NS\u0005\u001f"+
		"\u0000\u0000OP\u0005\u001b\u0000\u0000PS\u0005\u001f\u0000\u0000QS\u0005"+
		"\u0019\u0000\u0000RE\u0001\u0000\u0000\u0000RF\u0001\u0000\u0000\u0000"+
		"RG\u0001\u0000\u0000\u0000RJ\u0001\u0000\u0000\u0000RM\u0001\u0000\u0000"+
		"\u0000RO\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\u000b\u0001"+
		"\u0000\u0000\u0000TU\u0005\u0003\u0000\u0000UV\u0005\u001c\u0000\u0000"+
		"VW\u0003\u0018\f\u0000W\r\u0001\u0000\u0000\u0000XY\u0005\u0004\u0000"+
		"\u0000YZ\u0003\u0012\t\u0000Z\\\u0005\u0006\u0000\u0000[]\u0003\u0014"+
		"\n\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u000f\u0001\u0000\u0000"+
		"\u0000`a\u0005\u0005\u0000\u0000ab\u0005\u0007\u0000\u0000bd\u0005\u0006"+
		"\u0000\u0000ce\u0003\u0016\u000b\u0000dc\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"g\u0011\u0001\u0000\u0000\u0000hi\u0007\u0000\u0000\u0000i\u0013\u0001"+
		"\u0000\u0000\u0000jk\u0007\u0001\u0000\u0000k\u0015\u0001\u0000\u0000"+
		"\u0000lm\u0007\u0002\u0000\u0000m\u0017\u0001\u0000\u0000\u0000ns\u0005"+
		" \u0000\u0000op\u0005\u001d\u0000\u0000pr\u0005 \u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000t\u0019\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000vw\u0007\u0003\u0000\u0000w\u001b\u0001\u0000\u0000\u0000\n\u001f"+
		"\"%18CR^fs";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}