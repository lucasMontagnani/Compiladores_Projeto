import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
 		Scanner _key = new Scanner(System.in);
		int  a;
		String  tInt2;
		int  b;
		int  c;
		String  welcome;
		String  tInt;
		welcome = "IsiLanguagem em A��o!";
		tInt = "Digite um inteiro: ";
		a= _key.nextInt();
		tInt2 = "Digite outro inteiro: ";
		b= _key.nextInt();
		if (a==b) {
			System.out.println("Os dois inteiros s�o iguais!");
		}
		c = 2*a;
		if (b==c) {
			System.out.println("O segundo inteiro � o dobro do primeiro!");
		} else {
			System.out.println("O segundo inteiro n�o � o dobro do primeiro!");
		}
  }
}