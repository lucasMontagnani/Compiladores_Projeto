package br.com.professorisidro.isilanguage.ast;

public class CommandOpRaiz extends AbstractCommand{

    private String expression;
    private String a;
    private String op;

    public CommandOpRaiz(String expression) {
        this.expression = expression;
    }

    private void getVariables() {
        String[] variable = expression.split(" ");
        a = variable[0];
        op = variable[1];
    }

    @Override
    public String generateJavaCode() {
        getVariables();
        if (op.equalsIgnoreCase("#")) {
            // TODO Auto-generated method stub
            return "Math.sqrt("+ Double.parseDouble(a)+")";
        }
        // TODO Auto-generated method stub
        return "";
    }

    @Override
    public String toString() {
        return "CommandOpRaiz [valor=" + a + ", op=" + op +"]";
    }
}
