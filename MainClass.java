import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
 		Scanner _key = new Scanner(System.in);
		double  a;
		String  teste;
		double  b;
		double  c;
		double  d;
		double  e;
		int  f;
		int  i;
		String  m;
		String  cs;
		int  r;
		int  s;
		Boolean  t;
		char  u;
		double  w;
		double  x;
		double  y;
		u = 't';
		t = false;
		System.out.println(u);
		i = 5;
		teste = "Digite um número: ";
		b = 4.9;
		c = 3.688;
		f = 10;
		System.out.println(teste);
		System.out.println(c);
		d= _key.nextDouble();
		System.out.println(f);
		f = i;
		System.out.println(f);
		System.out.println(i);
		c = b;
		a = b*c;
		System.out.println(a);
		a = b/c;
		System.out.println(a);
		cs = "teste";
		if (f==10) {
			System.out.println(f);
		} else {
			System.out.println(i);
		}
		switch (cs) {
			case "teste":
				System.out.println(cs);
				break;
			case "teste2":
				System.out.println(i);
				break;
			default:
				System.out.println(f);
		}
		i = 10;
		while (i<10) {
			System.out.println(i);
			i = i-1;
		}
		w = Math.sqrt(25.0);
		System.out.println(w);
		y = Math.pow(10.0,2.0);
		System.out.println(y);
		y = Math.pow(10.0,3.0);
		System.out.println(y);
		x = (double) (Math.log(2.0) / Math.log(2.0));
		System.out.println(x);
  }
}