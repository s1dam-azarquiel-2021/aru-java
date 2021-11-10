package ejerciciosStrings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio12 {
	public static void main(String[] args) {
		// Realiza un programa que lea un String y elimine las palabras de
		// menos de tres letras. Una vez eliminadas esas palabras, no deben
		// existir espacios duplicados

		System.out.printf("Introduce una frase: ");
		Scanner input = new Scanner(System.in);
		StringTokenizer palabras = new StringTokenizer(input.nextLine());
		input.close();

		StringBuilder fraseFinal = new StringBuilder("");

		while (palabras.hasMoreTokens()) {
			String palabra = palabras.nextToken();
			if (palabra.length() >= 3) {
				fraseFinal.append(palabra + " ");
			}
		}

		System.out.printf("%s\n", fraseFinal);
	}
}
