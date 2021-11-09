package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		// Programa que rote una cadena tantas veces como se le diga

		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		StringBuilder frase = new StringBuilder(input.nextLine());
		System.out.print("Introduce el numero de rotaciones: ");
		int n = input.nextInt();
		input.close();

		final int L_FRASE = frase.length();
		frase.insert(0, frase.substring(L_FRASE - n));

		frase.delete(L_FRASE, L_FRASE + n);

		System.out.printf(
			"%s",
			frase
		);
	}
}
