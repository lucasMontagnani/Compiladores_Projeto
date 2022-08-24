import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
 		Scanner _key = new Scanner(System.in);
		int  cs;
		int  a;
		String  tInt2;
		int  b;
		int  c;
		Boolean  t;
		double  d;
		String  tCase;
		String  tBoolean;
		String  welcome;
		String  tInt;
		welcome = "IsiLanguagem em Ação!";
		tInt = "Digite um inteiro: ";
		System.out.println(tInt);
		a= _key.nextInt();
		tInt2 = "Digite outro inteiro: ";
		System.out.println(tInt2);
		b= _key.nextInt();
		if (a==b) {
			System.out.println("Os dois inteiros são iguais!");
		}
		c = 2*a;
		if (b==c) {
			System.out.println("O segundo inteiro é o dobro do primeiro!");
		} else {
			System.out.println("O segundo inteiro não é o dobro do primeiro!");
		}
		tBoolean = "Escreva true (verdadeiro) para multiplicar o primeiro inteiro pelo segundo e retornar o inteiro ou false (falso) para dividir";
		System.out.println(tBoolean);
		t= _key.nextBoolean();
		if (t==true) {
			d = a*b;			System.out.println(d);
		} else {
			d = a;			System.out.println(d);
		}
		tCase = "Digite: 1 - Para imprimir o 1º inteiro; 2 - Para imprimir o 2º inteiro; 3 - Para o real resultante:";
		System.out.println(tCase);
		cs= _key.nextInt();
		switch (cs) {
			case 1:
				System.out.println("Opção 1 escolhida!");
				System.out.println(a);
				break;
			case 2:
				System.out.println("Opção 2 escolhida!");
				System.out.println(b);
				break;
			case 3:
				System.out.println("Opção 3 escolhida!");
				System.out.println(d);
				break;
			default:
				System.out.println("Opção inválida!");
		}
  }
}