package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio15 {
	public static void main(String[] args) {
		// Realiza un programa que pida al usuario que escriba varias palabras.
		// El programa debe contar cuantas vocales tiene cada palabra y dara
		// como resultado la palabra que mas vocales tenga. Se deben ir pidiendo
		// palabras al usuario hasta que este escriba la palabra "FIN"

		Scanner input = new Scanner(System.in);
		String palabra;

		int nMayor = 0;
		String palabraMayor = "";

		do {
			System.out.printf("Introduce una palabra: ");
			palabra = input.nextLine();
			int nLetras = palabra.length();

			if (nLetras > nMayor) {
				nMayor = nLetras;
				palabraMayor = palabra;
			}
		} while (!palabra.equals("FIN"));
		input.close();

		System.out.printf(
			"La palabra con mas vocales es: %s\nY tiene %d vocales",
			palabraMayor, nMayor
		);
	}
}
