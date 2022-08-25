package br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandEscolha extends AbstractCommand {

	private String condition;

	private ArrayList<String> caseCondition;
	private HashMap<String, ArrayList<AbstractCommand>> cases;

	private ArrayList<AbstractCommand> def;

	public CommandEscolha(String condition, ArrayList<String> csCond, HashMap<String, ArrayList<AbstractCommand>> cs,  ArrayList<AbstractCommand> df) {
		this.condition = condition;
		this.caseCondition = csCond;
		this.cases = cs;
		this.def= df;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("		switch ("+condition+") {\n");
		for (int i = 0; i < cases.size(); i++) {
			str.append("			case ");
			str.append(caseCondition.get(i));
			str.append(":\n");
			for (AbstractCommand cse : cases.get(caseCondition.get(i))) {
				str.append("		" + cse.generateJavaCode() + "\n");
			}
			str.append("				break;\n");
		}
		if(!def.isEmpty()){
			str.append("			default:\n");
			str.append("		" + def.get(0).generateJavaCode() + "\n");
		}
		str.append("		}");
		return str.toString();
	}
	@Override
	public String toString() {
		return "CommandEscolha [switch=" + condition + ", conditionsCases=" + caseCondition + ", cases=" + cases
				+ ", default=" + def + "]";
	}
	
	

}
