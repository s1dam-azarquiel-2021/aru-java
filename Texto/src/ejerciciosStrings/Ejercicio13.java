package ejerciciosStrings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio13 {
	public static void main(String[] args) {
		// Realiza un programa que averigue cual es la palabra que mas letras
		// tiene de un String. El String solo contendra letras y espacios de
		// separacion, nada mas

		System.out.printf("Introduce una frase: ");
		Scanner input = new Scanner(System.in);
		StringTokenizer palabras = new StringTokenizer(input.nextLine());
		input.close();

		int nMayor = 0;
		String palabraMayor = "";
		while (palabras.hasMoreTokens()) {
			String palabra = palabras.nextToken();
			int nLetras = palabra.length();

			if (nLetras > nMayor) {
				nMayor = nLetras;
				palabraMayor = palabra;
			}
		}

		System.out.printf("La palabra con mas letras es: %s\n", palabraMayor);
	}
}
