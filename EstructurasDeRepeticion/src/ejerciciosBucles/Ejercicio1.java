package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		int suma = 0;
		byte nCeros = 0;

		// Pedir numeros hasta que se hallan recibido 5
		Scanner input = new Scanner(System.in);
		while (nCeros != 5) {
			System.out.printf("Introduce un numero: ");
			int n = input.nextInt();
			// Si es un cero lo contamos, si no se suma al total
			if (n == 0) {
				nCeros++;
			} else {
				suma += n;
			}
		}
		input.close();

		System.out.printf("Total: %d\n", suma);
	}
}
