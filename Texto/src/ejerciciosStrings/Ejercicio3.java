package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		// Programa que codifique una cadena cambiando cada letra
		// por la siguiente en el codigo ASCII

		System.out.print("Escribe una frase: ");
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine();
		input.close();

		String fraseFinal = "";
		for (int i = 0; i < frase.length(); i++) {
			fraseFinal += (char) (frase.charAt(i) + 1);
		}

		System.out.printf("%s", fraseFinal);
	}
}
