package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		// Programa que reciba una cadena y diga cuantas palabras contiene
		// Las palabras pueden estar separadas por espacios, puntos o comas

		System.out.print("Escribe una frase: ");
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine();
		input.close();

		int palabras = 1;
		for (int i = 1; i < frase.length() - 1; i++) {
			if (" ,.".indexOf(frase.charAt(i)) > -1) {
				palabras++;
			}
		}

		System.out.printf(
			"La frase tiene: %d palabra%c", palabras, palabras == 1 ? ' ' : 's'
		);
	}
}
