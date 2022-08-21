grammar IsiLang;

@header{
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
}

@members{
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
		if(tipo1 != tipo2){
			throw new IsiSemanticException("Error: incompatible types, symbol ["+varName2+"] can not be assign to symbol ["+varName1 + "].");
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
}

prog	: 'programa' decl bloco  'fimprog;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	 
           	 varDeclaradasNaoUsadas();
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  
	                  varTemp = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                     
	                     varMap.put(_varName, varTemp);
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  
	                  varTemp = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                     
	                      varMap.put(_varName, varTemp);
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao  
 		|  cmdrepeticao
		;
		
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                     	  
                     	  setUsedVar(_input.LT(-1).getText());
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP 
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     } 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                    
                    tempVarType = varMap.get(_input.LT(-1).getText()).getType();
                    //System.out.println("Tipoaaaa: " + tempVarType); // ----- TESTE DE COMPATIBILIDADE DE TIPOS
                    
                    setUsedVar(_input.LT(-1).getText());
                   } 
               ATTR { _exprContent = ""; } 
               expr { 
               //System.out.println("AtribExprName: " + _input.LT(-1).getText()); // ----- TESTE DE COMPATIBILIDADE DE TIPOS
               //System.out.println("TermType: " + termType); // ----- TESTE DE COMPATIBILIDADE DE TIPOS
               
               compatibilidadeTipos(tempVarType, _exprID, termType, _input.LT(-1).getText());
               }
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
			
			
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;
            
cmdrepeticao: 'enquanto' AP
			  			 ID    { _exprRepeticao = _input.LT(-1).getText(); }
                         OPREL { _exprRepeticao += _input.LT(-1).getText(); }
                         (ID | NUMBER) {_exprRepeticao += _input.LT(-1).getText(); }
                         FP 
                         ACH 
                         { curThread = new ArrayList<AbstractCommand>(); 
                      	   stack.push(curThread);
                    	 }
                    	 
                         (cmd)+ 
                    
                         FCH 
                         {
                         instrucoes = stack.pop();	
                    	 CommandRepeticao cmd = new CommandRepeticao(_exprRepeticao, instrucoes);
                   		 stack.peek().add(cmd);
                   	     }
            ;      	     
			
expr		:  termo 
				( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo 
	            )*
			;
			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
	                //System.out.println("termoTeste: " +_input.LT(-1).getText());
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              	//System.out.println("termoTeste: " +_input.LT(-1).getText());
              	termType = 0;
              }
            | TEXTO 
              {
              _exprContent += _input.LT(-1).getText();
              termType = 1;
              }
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;

TEXTO : '"' .*? '"' 
		  ;