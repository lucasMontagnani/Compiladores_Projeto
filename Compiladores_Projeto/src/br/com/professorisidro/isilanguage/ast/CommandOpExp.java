package br.com.professorisidro.isilanguage.ast;

public class CommandOpExp extends AbstractCommand{

    private String expression;
    private String a;
    private String op;
    private String b;

    public CommandOpExp(String expression) {
        this.expression = expression;
    }

    private void getVariables() {
        String[] variable = expression.split(" ");
        a = variable[0];
        op = variable[1];
        b = variable[2];
    }

    @Override
    public String generateJavaCode() {
        getVariables();
        if (op.equalsIgnoreCase("^")) {
            // TODO Auto-generated method stub
            return "Math.pow("+ Double.parseDouble(a) + "," + Double.parseDouble(b) +")";
        }
        else if (op.equalsIgnoreCase("**")) {
            // TODO Auto-generated method stub
            return "Math.pow("+ Double.parseDouble(a) + "," + Double.parseDouble(b) +")";
        }
        // TODO Auto-generated method stub
        return "";
    }

    @Override
    public String toString() {
        return "CommandOpExponenciacao [base=" + a + ", op=" + op + ", expoente=" + b+ "]";
    }
}
