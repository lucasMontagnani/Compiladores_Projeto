package br.com.professorisidro.isilanguage.ast;

import br.com.professorisidro.isilanguage.datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private IsiVariable var;
	
	public CommandLeitura (String id, IsiVariable var) {
		this.id = id;
		this.var = var;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return "		" + id +"= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": var.getType()==IsiVariable.INT? "nextInt();": var.getType()==IsiVariable.BOOLEAN?"nextBoolean();":var.getType()==IsiVariable.CHAR?"next().charAt(0);":"nextLine();");
	}
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}

}
