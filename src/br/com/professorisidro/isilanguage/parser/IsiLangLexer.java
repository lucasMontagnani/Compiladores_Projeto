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
	import br.com.professorisidro.isilanguage.ast.CommandRepeticao;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, AP=13, FP=14, PT=15, COLON=16, SC=17, OP=18, 
		ATTR=19, VIR=20, ACH=21, FCH=22, OPREL=23, BOLEANO=24, ID=25, INT=26, 
		NUMBER=27, WS=28, CARACTER=29, TEXTO=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "AP", "FP", "PT", "COLON", "SC", "OP", "ATTR", 
		"VIR", "ACH", "FCH", "OPREL", "BOLEANO", "ID", "INT", "NUMBER", "WS", 
		"CARACTER", "TEXTO"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'inteiro'", "'numero'", "'caractere'", 
		"'texto'", "'boleano'", "'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", 
		"'('", "')'", "'.'", "':'", "';'", null, "'='", "','", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "AP", "FP", "PT", "COLON", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", 
		"OPREL", "BOLEANO", "ID", "INT", "NUMBER", "WS", "CARACTER", "TEXTO"
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
		private String _exprRepeticao;
		private ArrayList<AbstractCommand> instrucoes;
		
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
		    if(varMap.get(varName1) != null && varMap.get(varName2) != null){
		        //System.out.println("Variável 2: " + varMap.get(varName2));
		        //System.out.println("Valor da variável 2: " + (varMap.get(varName2)).getValue());
		        if((varMap.get(varName2)).getValue() == null){
	                throw new IsiSemanticException("Error: null exception, symbol ["+varName2+"] can not be assign to symbol ["+varName1 + "], because it is null.");
	            }
	            else{
	                (varMap.get(varName1)).setValue((varMap.get(varName2)).getValue());
	            }
		    }
			else if(((tipo1 != tipo2) && (tipo1 != 1 && tipo2 != 0))){
				throw new IsiSemanticException("Error: incompatible types, symbol ["+varName2+"] can not be assign to symbol ["+varName1 + "].");
			}
			else{
			    (varMap.get(varName1)).setValue(varName2);
			}
		
		}
		
		public void varDeclaradasNaoUsadas(){
			for (Map.Entry<String, IsiVariable> entry : varMap.entrySet()) {
				//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				//System.out.println(entry.getValue().getUsada());
				if(entry.getValue().getUsada() == false){
					System.out.println("WARNING: A variável ["+ entry.getKey() + "] foi declarada mas nunca é usada.");
				}
			}
		}
		
		public void setUsedVar(String nameID){
			varMap.get(nameID).setUsadaTT();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00e8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u00b5\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u00c6\n\31\3\32\3\32\7\32\u00ca\n\32\f\32\16"+
		"\32\u00cd\13\32\3\33\6\33\u00d0\n\33\r\33\16\33\u00d1\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\7\37\u00e2\n\37"+
		"\f\37\16\37\u00e5\13\37\3\37\3\37\3\u00e3\2 \3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= \3\2\t\5\2,-//\61\61\4\2"+
		">>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\6\2\f\f\17\17))^^\2"+
		"\u00ef\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5H\3\2\2\2\7Q\3\2\2\2\tY\3\2\2\2\13"+
		"`\3\2\2\2\rj\3\2\2\2\17p\3\2\2\2\21x\3\2\2\2\23}\3\2\2\2\25\u0085\3\2"+
		"\2\2\27\u0088\3\2\2\2\31\u008e\3\2\2\2\33\u0097\3\2\2\2\35\u0099\3\2\2"+
		"\2\37\u009b\3\2\2\2!\u009d\3\2\2\2#\u009f\3\2\2\2%\u00a1\3\2\2\2\'\u00a3"+
		"\3\2\2\2)\u00a5\3\2\2\2+\u00a7\3\2\2\2-\u00a9\3\2\2\2/\u00b4\3\2\2\2\61"+
		"\u00c5\3\2\2\2\63\u00c7\3\2\2\2\65\u00cf\3\2\2\2\67\u00d3\3\2\2\29\u00d7"+
		"\3\2\2\2;\u00db\3\2\2\2=\u00df\3\2\2\2?@\7r\2\2@A\7t\2\2AB\7q\2\2BC\7"+
		"i\2\2CD\7t\2\2DE\7c\2\2EF\7o\2\2FG\7c\2\2G\4\3\2\2\2HI\7h\2\2IJ\7k\2\2"+
		"JK\7o\2\2KL\7r\2\2LM\7t\2\2MN\7q\2\2NO\7i\2\2OP\7=\2\2P\6\3\2\2\2QR\7"+
		"k\2\2RS\7p\2\2ST\7v\2\2TU\7g\2\2UV\7k\2\2VW\7t\2\2WX\7q\2\2X\b\3\2\2\2"+
		"YZ\7p\2\2Z[\7w\2\2[\\\7o\2\2\\]\7g\2\2]^\7t\2\2^_\7q\2\2_\n\3\2\2\2`a"+
		"\7e\2\2ab\7c\2\2bc\7t\2\2cd\7c\2\2de\7e\2\2ef\7v\2\2fg\7g\2\2gh\7t\2\2"+
		"hi\7g\2\2i\f\3\2\2\2jk\7v\2\2kl\7g\2\2lm\7z\2\2mn\7v\2\2no\7q\2\2o\16"+
		"\3\2\2\2pq\7d\2\2qr\7q\2\2rs\7n\2\2st\7g\2\2tu\7c\2\2uv\7p\2\2vw\7q\2"+
		"\2w\20\3\2\2\2xy\7n\2\2yz\7g\2\2z{\7k\2\2{|\7c\2\2|\22\3\2\2\2}~\7g\2"+
		"\2~\177\7u\2\2\177\u0080\7e\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2"+
		"\u0082\u0083\7x\2\2\u0083\u0084\7c\2\2\u0084\24\3\2\2\2\u0085\u0086\7"+
		"u\2\2\u0086\u0087\7g\2\2\u0087\26\3\2\2\2\u0088\u0089\7u\2\2\u0089\u008a"+
		"\7g\2\2\u008a\u008b\7p\2\2\u008b\u008c\7c\2\2\u008c\u008d\7q\2\2\u008d"+
		"\30\3\2\2\2\u008e\u008f\7g\2\2\u008f\u0090\7p\2\2\u0090\u0091\7s\2\2\u0091"+
		"\u0092\7w\2\2\u0092\u0093\7c\2\2\u0093\u0094\7p\2\2\u0094\u0095\7v\2\2"+
		"\u0095\u0096\7q\2\2\u0096\32\3\2\2\2\u0097\u0098\7*\2\2\u0098\34\3\2\2"+
		"\2\u0099\u009a\7+\2\2\u009a\36\3\2\2\2\u009b\u009c\7\60\2\2\u009c \3\2"+
		"\2\2\u009d\u009e\7<\2\2\u009e\"\3\2\2\2\u009f\u00a0\7=\2\2\u00a0$\3\2"+
		"\2\2\u00a1\u00a2\t\2\2\2\u00a2&\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4(\3\2"+
		"\2\2\u00a5\u00a6\7.\2\2\u00a6*\3\2\2\2\u00a7\u00a8\7}\2\2\u00a8,\3\2\2"+
		"\2\u00a9\u00aa\7\177\2\2\u00aa.\3\2\2\2\u00ab\u00b5\t\3\2\2\u00ac\u00ad"+
		"\7@\2\2\u00ad\u00b5\7?\2\2\u00ae\u00af\7>\2\2\u00af\u00b5\7?\2\2\u00b0"+
		"\u00b1\7?\2\2\u00b1\u00b5\7?\2\2\u00b2\u00b3\7#\2\2\u00b3\u00b5\7?\2\2"+
		"\u00b4\u00ab\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4\u00b0"+
		"\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\60\3\2\2\2\u00b6\u00b7\7x\2\2\u00b7"+
		"\u00b8\7g\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7f\2\2\u00ba\u00bb\7c\2\2"+
		"\u00bb\u00bc\7f\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7k\2\2\u00be\u00bf"+
		"\7t\2\2\u00bf\u00c6\7q\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2\7c\2\2\u00c2"+
		"\u00c3\7n\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c6\7q\2\2\u00c5\u00b6\3\2\2"+
		"\2\u00c5\u00c0\3\2\2\2\u00c6\62\3\2\2\2\u00c7\u00cb\t\4\2\2\u00c8\u00ca"+
		"\t\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\64\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\t\6\2"+
		"\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\66\3\2\2\2\u00d3\u00d4\5\65\33\2\u00d4\u00d5\5\37\20\2"+
		"\u00d5\u00d6\5\65\33\2\u00d68\3\2\2\2\u00d7\u00d8\t\7\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00da\b\35\2\2\u00da:\3\2\2\2\u00db\u00dc\7)\2\2\u00dc"+
		"\u00dd\n\b\2\2\u00dd\u00de\7)\2\2\u00de<\3\2\2\2\u00df\u00e3\7$\2\2\u00e0"+
		"\u00e2\13\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e4\3"+
		"\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e7\7$\2\2\u00e7>\3\2\2\2\t\2\u00b4\u00c5\u00c9\u00cb\u00d1\u00e3\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}