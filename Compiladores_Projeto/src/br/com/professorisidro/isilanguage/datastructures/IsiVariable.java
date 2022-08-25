package br.com.professorisidro.isilanguage.datastructures;

public class IsiVariable extends IsiSymbol {

	public static final int INT=0;
	public static final int NUMBER=1;
	public static final int CHAR=2;
	public static final int TEXT=3;
	public static final int BOOLEAN=4;
	
	private int type;
	private String value;
	private Boolean usada;
	
	public IsiVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
		this.usada = false;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

	public Boolean getUsada() {
		return usada;
	}

	public void setUsadaTT() {
		this.usada = true;
	}
	
	@Override
	public String toString() {
		return "IsiVariable [type=" + type + ", value=" + value + ", usada=" + usada + "]";
	}

	public String generateJavaCode() {
       String str;
       if (type == NUMBER) {
    	   str = "double ";
       } else if (type == INT){
    	   str = "int ";
	   } else if (type == CHAR){
		   str = "char ";
	   } else if (type == BOOLEAN){
		   str = "Boolean ";
       } else{
			str = "String ";
		}
       return str + " "+super.name+";";
	}
	
	

}
