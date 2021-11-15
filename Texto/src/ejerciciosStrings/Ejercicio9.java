package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) {
		// Programa que recibe dos cadenas de caracteres y comprueba cunatas
		// veces aparece la primera en la segunda

		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		String frase1 = input.nextLine();
		System.out.print("Introduce otra frase: ");
		StringBuilder frase2 = new StringBuilder(input.nextLine());
		input.close();

		final int L_FRASE1 = frase1.length();
		int apariciones = 0;
		for (int i = 0; i < frase2.length() - L_FRASE1 + 1; i++) {
			if (frase2.substring(i, i + L_FRASE1).equalsIgnoreCase(frase1)) {
				apariciones++;
			}
		}

		System.out.printf(
			"La frase \"%s\" aparece %d ve%s",
			frase1, apariciones, apariciones == 1 ? "z" : "ces"
		);
	}
}
