package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {
		// Programa que elimine todas las vocales de una frase

		System.out.printf("Introduce una frase: ");
		Scanner input = new Scanner(System.in);
		StringBuilder frase = new StringBuilder(input.nextLine());
		input.close();

		for (int i = 0; i < frase.length(); i++) {
			switch (frase.charAt(i)) {
			case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U':
				frase.deleteCharAt(i);
			}
		}

		System.out.printf("%s\n", frase);
	}
}
