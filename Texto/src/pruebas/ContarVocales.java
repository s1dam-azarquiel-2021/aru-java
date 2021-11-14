package pruebas;

import java.util.Scanner;

public class ContarVocales {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine().toLowerCase();
		input.close();

		int contador = 0;
		for (int i = 0; i < frase.length(); i++) {
			switch (frase.charAt(i)) {
			case 'a', 'e', 'i', 'o', 'u':
				contador++;
			}
		}

		System.out.printf("En la frase hay %d vocales\n", contador);
	}
}
