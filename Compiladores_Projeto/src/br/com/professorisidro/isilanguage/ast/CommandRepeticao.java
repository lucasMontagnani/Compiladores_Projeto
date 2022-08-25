package br.com.professorisidro.isilanguage.ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand{
	
	private String condition;
	private ArrayList<AbstractCommand> contend;

	public CommandRepeticao(String condition, ArrayList<AbstractCommand> contend) {
		super();
		this.condition = condition;
		this.contend = contend;
	}

	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("		while ("+condition+") {\n");
		for (AbstractCommand cmd: contend) {
			str.append("	" + cmd.generateJavaCode() + "\n");
		}
		str.append("		}");
		return str.toString();
	}

	@Override
	public String toString() {
		return "CommandRepeticao [condition=" + condition + ", contend=" + contend + "]";
	}

}
