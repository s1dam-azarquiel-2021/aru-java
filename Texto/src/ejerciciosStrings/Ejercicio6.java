package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		// Programa que descubra si una palabra es o no palindroma,
		// es decir se lee igual del derecho que del reves

		System.out.print("Introduce una palabra: ");
		Scanner input = new Scanner(System.in);
		StringBuilder palabra = new StringBuilder(input.nextLine());
		input.close();

		final int L_PALABRA = palabra.length();
		boolean esPalindromo = true;

		for (int i = 0; i <= L_PALABRA / 2; i++) {
			if (palabra.charAt(i) != palabra.charAt(L_PALABRA - i - 1)) {
				esPalindromo = false;
				break;
			}
		}

		System.out.printf(
			"%s",
			esPalindromo
		);
	}
}
