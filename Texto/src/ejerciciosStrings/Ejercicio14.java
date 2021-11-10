package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio14 {
	public static void main(String[] args) {
		// Realiza un programa que intercale las letras de dos palabras.
		// El programa debe pedir 2 palabras y luego dar otra palabra resultado
		// con las letras de las palabras intercaladas.

		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce una palabra: ");
		String palabra1 = input.nextLine();
		System.out.printf("Introduce otra palabra: ");
		String palabra2 = input.nextLine();
		input.close();

		StringBuilder palabraFinal = new StringBuilder("");

		final int L_P1 = palabra1.length();
		final int L_P2 = palabra2.length();

		for (int i = 0; i < L_P1 && i < L_P2; i++) {
			palabraFinal.append(palabra1.charAt(i));
			palabraFinal.append(palabra2.charAt(i));
		}

		if (L_P1 < L_P2) {
			palabraFinal.append(palabra2.substring(L_P1));
		} else if (L_P2 < L_P1) {
			palabraFinal.append(palabra1.substring(L_P2));
		}

		System.out.printf("%s\n", palabraFinal);
	}
}
