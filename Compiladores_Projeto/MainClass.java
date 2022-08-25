import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
 		Scanner _key = new Scanner(System.in);
		String  txt5;
		double  numTeste;
		String  txt1;
		double  num1;
		double  i;
		double  num3;
		double  num2;
		num3 = 3.14159265359;
		i = 5.0;
		while (i>0) {
			System.out.println(i);
			i = i-1.0;
		}
		System.out.println("Digite o primeiro numero");
		num1= _key.nextDouble();
		System.out.println("Digite o segundo numero");
		num2= _key.nextDouble();
		if (num1>num2) {
			System.out.println(num1);
		} else {
			System.out.println(num2);
		}
  }
}