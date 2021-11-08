package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		// Pedir un numero
		System.out.print("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		// Parece raro, pero si i=1 solo damos un 0,
		// si i=2, damos 0 y luego actual=0+1=1, anterior=1-1=0
		// Por lo que decir al principio que el anterior numero de la
		// sucesion es 0, es un truco para hacer que funcione sin complicarlo
		// mucho mas usando if o cualquier otra cosa
		int anterior = 1,
			actual = 0;
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", actual);
			actual += anterior;
			anterior = actual - anterior;
		}
	}
}
