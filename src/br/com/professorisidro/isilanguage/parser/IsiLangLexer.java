// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.professorisidro.isilanguage.parser;

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import java.util.Map;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, AP=9, 
		FP=10, SC=11, OP=12, ATTR=13, VIR=14, ACH=15, FCH=16, OPREL=17, ID=18, 
		NUMBER=19, WS=20, TEXTO=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "AP", 
		"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
		"WS", "TEXTO"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'('", "')'", "';'", null, "'='", "','", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "AP", "FP", "SC", 
		"OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS", "TEXTO"
	};
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		private Map<String, IsiVariable> varMap = new HashMap<String, IsiVariable>();
		private IsiVariable varTemp;
		private int termType;
		private int tempVarType;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		
		public void compatibilidadeTipos(int tipo1, String varName1, int tipo2, String varName2){
			if(tipo1 != tipo2){
				throw new IsiSemanticException("Error: incompatible types, symbol ["+varName2+"] can not be assign to symbol ["+varName1 + "].");
			} 
		
		}
		
		public void verificaTipo(String name){
			//System.out.println(symbolTable.get(name));
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u009e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\5\22|\n\22\3\23\3\23\7\23\u0080\n\23\f\23"+
		"\16\23\u0083\13\23\3\24\6\24\u0086\n\24\r\24\16\24\u0087\3\24\3\24\6\24"+
		"\u008c\n\24\r\24\16\24\u008d\5\24\u0090\n\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\7\26\u0098\n\26\f\26\16\26\u009b\13\26\3\26\3\26\3\u0099\2\27\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62"+
		";C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00a6\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\66\3\2\2\2\7?\3\2\2\2\tF\3\2\2\2\13"+
		"L\3\2\2\2\rQ\3\2\2\2\17Y\3\2\2\2\21\\\3\2\2\2\23b\3\2\2\2\25d\3\2\2\2"+
		"\27f\3\2\2\2\31h\3\2\2\2\33j\3\2\2\2\35l\3\2\2\2\37n\3\2\2\2!p\3\2\2\2"+
		"#{\3\2\2\2%}\3\2\2\2\'\u0085\3\2\2\2)\u0091\3\2\2\2+\u0095\3\2\2\2-.\7"+
		"r\2\2./\7t\2\2/\60\7q\2\2\60\61\7i\2\2\61\62\7t\2\2\62\63\7c\2\2\63\64"+
		"\7o\2\2\64\65\7c\2\2\65\4\3\2\2\2\66\67\7h\2\2\678\7k\2\289\7o\2\29:\7"+
		"r\2\2:;\7t\2\2;<\7q\2\2<=\7i\2\2=>\7=\2\2>\6\3\2\2\2?@\7p\2\2@A\7w\2\2"+
		"AB\7o\2\2BC\7g\2\2CD\7t\2\2DE\7q\2\2E\b\3\2\2\2FG\7v\2\2GH\7g\2\2HI\7"+
		"z\2\2IJ\7v\2\2JK\7q\2\2K\n\3\2\2\2LM\7n\2\2MN\7g\2\2NO\7k\2\2OP\7c\2\2"+
		"P\f\3\2\2\2QR\7g\2\2RS\7u\2\2ST\7e\2\2TU\7t\2\2UV\7g\2\2VW\7x\2\2WX\7"+
		"c\2\2X\16\3\2\2\2YZ\7u\2\2Z[\7g\2\2[\20\3\2\2\2\\]\7u\2\2]^\7g\2\2^_\7"+
		"p\2\2_`\7c\2\2`a\7q\2\2a\22\3\2\2\2bc\7*\2\2c\24\3\2\2\2de\7+\2\2e\26"+
		"\3\2\2\2fg\7=\2\2g\30\3\2\2\2hi\t\2\2\2i\32\3\2\2\2jk\7?\2\2k\34\3\2\2"+
		"\2lm\7.\2\2m\36\3\2\2\2no\7}\2\2o \3\2\2\2pq\7\177\2\2q\"\3\2\2\2r|\t"+
		"\3\2\2st\7@\2\2t|\7?\2\2uv\7>\2\2v|\7?\2\2wx\7?\2\2x|\7?\2\2yz\7#\2\2"+
		"z|\7?\2\2{r\3\2\2\2{s\3\2\2\2{u\3\2\2\2{w\3\2\2\2{y\3\2\2\2|$\3\2\2\2"+
		"}\u0081\t\4\2\2~\u0080\t\5\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082&\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0086\t\6\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u008f\3\2\2\2\u0089\u008b\7\60\2\2\u008a"+
		"\u008c\t\6\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u0089\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090(\3\2\2\2\u0091\u0092\t\7\2\2\u0092\u0093\3\2\2\2"+
		"\u0093\u0094\b\25\2\2\u0094*\3\2\2\2\u0095\u0099\7$\2\2\u0096\u0098\13"+
		"\2\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7$"+
		"\2\2\u009d,\3\2\2\2\n\2{\177\u0081\u0087\u008d\u008f\u0099\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}