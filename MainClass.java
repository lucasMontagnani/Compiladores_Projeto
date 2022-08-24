import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
 		Scanner _key = new Scanner(System.in);
		int  a;
		int  b;
		int  c;
		double  d;
		String  tCase;
		String  tBoolean;
		String  tChar;
		String  tInt;
		int  cs;
		String  tInt2;
		Boolean  t;
		String  welcome;
		char  fimIsi;
		welcome = "IsiLanguagem em Ação!";
		System.out.println(welcome);
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
			System.out.println("O segundo inteiro não é exatamente o dobro do primeiro!");
		}
		tBoolean = "Escreva true (verdadeiro) para multiplicar o primeiro inteiro pelo segundo e retornar o inteiro ou false (falso) para dividir";
		System.out.println(tBoolean);
		t= _key.nextBoolean();
		if (t==true) {
			d = a*b;			System.out.println(d);
		} else {
			d = a/b;			System.out.println(d);
		}
		tCase = "Digite: 1 - Para imprimir o 1º inteiro; 2 - Para imprimir o 2º inteiro; 3 - Somar os dois inteiros; 4 - Para subtrair o segundo inteiro do primeiro; 4 - Para o real resultante:";
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
				c = a+b;
				System.out.println(c);
				break;
			case 4:
				System.out.println("Opção 4 escolhida!");
				c = a-b;
				System.out.println(c);
				break;
			case 5:
				System.out.println("Opção 5 escolhida!");
				System.out.println(d);
				break;
			default:
				System.out.println("Opção inválida!");
		}
		tChar = "Digite um caractere para finalizar o programa: ";
		System.out.println(tChar);
		fimIsi= _key.next().charAt(0);
		System.out.println("Caractere digitado : ");
		System.out.println(fimIsi);
		System.out.println("Programa encerrado. Goodbye!");
  }
}