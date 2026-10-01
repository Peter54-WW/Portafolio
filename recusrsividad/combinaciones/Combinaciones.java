//package recusrsividad.combinaciones.Combinaciones.java;
import java.util.Scanner; 

public class Combinaciones { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		System.out.print("Ingrese n: "); 
		int n = sc.nextInt(); 

		System.out.print("Ingrese m: "); 
		int m = sc.nextInt(); 

		int resultado = combinacion(n,m); // Llamada al método que calcula C(m, n) 
		System.out.println("C(" + m + ", " + n + ") = " + resultado); 
	} 

	public static int factorial(int x){
		if (x == 0){
			return 1;
		}
		return x * factorial(x - 1);
	}

	public static int combinacion(int n, int m){
		return factorial(n)/(factorial(m) * factorial(n - m));
	}
}