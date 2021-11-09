package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		// Programa que rote una cadena tantas veces como se le diga

		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String frase = input.nextLine();
		System.out.print("Introduce el numero de rotaciones: ");
		int n = input.nextInt();
		input.close();

		String fraseFinal = frase.substring(n - 1) + frase.substring(0, n - 1);

		System.out.printf(
			"%s",
			fraseFinal
		);
	}
}
