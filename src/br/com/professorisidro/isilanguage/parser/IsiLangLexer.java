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
	import br.com.professorisidro.isilanguage.ast.CommandOpExp;
	import br.com.professorisidro.isilanguage.ast.CommandOpRaiz;
	import br.com.professorisidro.isilanguage.ast.CommandOpLog;
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
		NUMBER=27, WS=28, CARACTER=29, TEXTO=30, OPEXP=31, OPRAIZ=32, OPLOG=33;
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
		"CARACTER", "TEXTO", "OPEXP", "OPRAIZ", "OPLOG"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'inteiro'", "'numero'", "'caractere'", 
		"'texto'", "'boleano'", "'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", 
		"'('", "')'", "'.'", "':'", "';'", null, "'='", "','", "'{'", "'}'", null, 
		null, null, null, null, null, null, null, null, "'#'", "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "AP", "FP", "PT", "COLON", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", 
		"OPREL", "BOLEANO", "ID", "INT", "NUMBER", "WS", "CARACTER", "TEXTO", 
		"OPEXP", "OPRAIZ", "OPLOG"
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

		private boolean isOpExp = false;
	    private boolean isOpRaiz = false;
	    private boolean isOpLog = false;
		
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00f7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u00bb\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00cc\n\31\3\32\3\32"+
		"\7\32\u00d0\n\32\f\32\16\32\u00d3\13\32\3\33\6\33\u00d6\n\33\r\33\16\33"+
		"\u00d7\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\7\37\u00e8\n\37\f\37\16\37\u00eb\13\37\3\37\3\37\3 \3 \3 \5 \u00f2"+
		"\n \3!\3!\3\"\3\"\3\u00e9\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\t\5\2,-//\61\61\4\2>>@@\3\2"+
		"c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\6\2\f\f\17\17))^^\2\u00ff\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5N\3\2\2\2"+
		"\7W\3\2\2\2\t_\3\2\2\2\13f\3\2\2\2\rp\3\2\2\2\17v\3\2\2\2\21~\3\2\2\2"+
		"\23\u0083\3\2\2\2\25\u008b\3\2\2\2\27\u008e\3\2\2\2\31\u0094\3\2\2\2\33"+
		"\u009d\3\2\2\2\35\u009f\3\2\2\2\37\u00a1\3\2\2\2!\u00a3\3\2\2\2#\u00a5"+
		"\3\2\2\2%\u00a7\3\2\2\2\'\u00a9\3\2\2\2)\u00ab\3\2\2\2+\u00ad\3\2\2\2"+
		"-\u00af\3\2\2\2/\u00ba\3\2\2\2\61\u00cb\3\2\2\2\63\u00cd\3\2\2\2\65\u00d5"+
		"\3\2\2\2\67\u00d9\3\2\2\29\u00dd\3\2\2\2;\u00e1\3\2\2\2=\u00e5\3\2\2\2"+
		"?\u00f1\3\2\2\2A\u00f3\3\2\2\2C\u00f5\3\2\2\2EF\7r\2\2FG\7t\2\2GH\7q\2"+
		"\2HI\7i\2\2IJ\7t\2\2JK\7c\2\2KL\7o\2\2LM\7c\2\2M\4\3\2\2\2NO\7h\2\2OP"+
		"\7k\2\2PQ\7o\2\2QR\7r\2\2RS\7t\2\2ST\7q\2\2TU\7i\2\2UV\7=\2\2V\6\3\2\2"+
		"\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z[\7g\2\2[\\\7k\2\2\\]\7t\2\2]^\7q\2\2^\b"+
		"\3\2\2\2_`\7p\2\2`a\7w\2\2ab\7o\2\2bc\7g\2\2cd\7t\2\2de\7q\2\2e\n\3\2"+
		"\2\2fg\7e\2\2gh\7c\2\2hi\7t\2\2ij\7c\2\2jk\7e\2\2kl\7v\2\2lm\7g\2\2mn"+
		"\7t\2\2no\7g\2\2o\f\3\2\2\2pq\7v\2\2qr\7g\2\2rs\7z\2\2st\7v\2\2tu\7q\2"+
		"\2u\16\3\2\2\2vw\7d\2\2wx\7q\2\2xy\7n\2\2yz\7g\2\2z{\7c\2\2{|\7p\2\2|"+
		"}\7q\2\2}\20\3\2\2\2~\177\7n\2\2\177\u0080\7g\2\2\u0080\u0081\7k\2\2\u0081"+
		"\u0082\7c\2\2\u0082\22\3\2\2\2\u0083\u0084\7g\2\2\u0084\u0085\7u\2\2\u0085"+
		"\u0086\7e\2\2\u0086\u0087\7t\2\2\u0087\u0088\7g\2\2\u0088\u0089\7x\2\2"+
		"\u0089\u008a\7c\2\2\u008a\24\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d\7"+
		"g\2\2\u008d\26\3\2\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\u0091"+
		"\7p\2\2\u0091\u0092\7c\2\2\u0092\u0093\7q\2\2\u0093\30\3\2\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u0096\7p\2\2\u0096\u0097\7s\2\2\u0097\u0098\7w\2\2\u0098"+
		"\u0099\7c\2\2\u0099\u009a\7p\2\2\u009a\u009b\7v\2\2\u009b\u009c\7q\2\2"+
		"\u009c\32\3\2\2\2\u009d\u009e\7*\2\2\u009e\34\3\2\2\2\u009f\u00a0\7+\2"+
		"\2\u00a0\36\3\2\2\2\u00a1\u00a2\7\60\2\2\u00a2 \3\2\2\2\u00a3\u00a4\7"+
		"<\2\2\u00a4\"\3\2\2\2\u00a5\u00a6\7=\2\2\u00a6$\3\2\2\2\u00a7\u00a8\t"+
		"\2\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7?\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7"+
		".\2\2\u00ac*\3\2\2\2\u00ad\u00ae\7}\2\2\u00ae,\3\2\2\2\u00af\u00b0\7\177"+
		"\2\2\u00b0.\3\2\2\2\u00b1\u00bb\t\3\2\2\u00b2\u00b3\7@\2\2\u00b3\u00bb"+
		"\7?\2\2\u00b4\u00b5\7>\2\2\u00b5\u00bb\7?\2\2\u00b6\u00b7\7?\2\2\u00b7"+
		"\u00bb\7?\2\2\u00b8\u00b9\7#\2\2\u00b9\u00bb\7?\2\2\u00ba\u00b1\3\2\2"+
		"\2\u00ba\u00b2\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00bb\60\3\2\2\2\u00bc\u00bd\7x\2\2\u00bd\u00be\7g\2\2\u00be"+
		"\u00bf\7t\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7f\2\2"+
		"\u00c2\u00c3\7g\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7t\2\2\u00c5\u00cc"+
		"\7q\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9"+
		"\u00ca\7u\2\2\u00ca\u00cc\7q\2\2\u00cb\u00bc\3\2\2\2\u00cb\u00c6\3\2\2"+
		"\2\u00cc\62\3\2\2\2\u00cd\u00d1\t\4\2\2\u00ce\u00d0\t\5\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\64\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\t\6\2\2\u00d5\u00d4\3\2\2"+
		"\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\66"+
		"\3\2\2\2\u00d9\u00da\5\65\33\2\u00da\u00db\5\37\20\2\u00db\u00dc\5\65"+
		"\33\2\u00dc8\3\2\2\2\u00dd\u00de\t\7\2\2\u00de\u00df\3\2\2\2\u00df\u00e0"+
		"\b\35\2\2\u00e0:\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e3\n\b\2\2\u00e3"+
		"\u00e4\7)\2\2\u00e4<\3\2\2\2\u00e5\u00e9\7$\2\2\u00e6\u00e8\13\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00ea\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7$\2\2\u00ed"+
		">\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef\u00f2\7,\2\2\u00f0\u00f2\7`\2\2\u00f1"+
		"\u00ee\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2@\3\2\2\2\u00f3\u00f4\7%\2\2\u00f4"+
		"B\3\2\2\2\u00f5\u00f6\7&\2\2\u00f6D\3\2\2\2\n\2\u00ba\u00cb\u00cf\u00d1"+
		"\u00d7\u00e9\u00f1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}