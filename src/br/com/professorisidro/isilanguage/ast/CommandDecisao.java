package br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand {
 
	private String condition;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public CommandDecisao(String condition, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf) {
		this.condition = condition;
		this.listaTrue = lt;
		this.listaFalse = lf;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		String checkCondition = condition.contains("verdadeiro") ? condition.replaceAll("verdadeiro", "true") : condition.contains("falso") ? condition.replaceAll("falso", "false"): condition;
		str.append("		if ("+ checkCondition+") {\n");
		for (AbstractCommand cmd: listaTrue) {
			str.append("	" + cmd.generateJavaCode());
		}
		str.append("\n		}");
		if (!listaFalse.isEmpty()) {
			str.append(" else {\n");
			for (AbstractCommand cmd: listaFalse) {
				str.append("	" + cmd.generateJavaCode());
			}
			str.append("\n		}");
		
		}
		return str.toString();
	}
	@Override
	public String toString() {
		return "CommandDecisao [condition=" + condition + ", listaTrue=" + listaTrue + ", listaFalse=" + listaFalse
				+ "]";
	}
	
	

}
