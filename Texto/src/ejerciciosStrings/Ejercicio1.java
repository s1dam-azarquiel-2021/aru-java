package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		// Programa que pase un String a mayusculas
		// y diga cuantas letras han cambiado

		System.out.print("Escribe una frase: ");
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine();
		input.close();

		int cambios = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (Character.isLowerCase(frase.charAt(i))) {
				cambios++;
			}
		}

		System.out.printf(
			"Frase en mayusculas: %s\n" + "Numero de letras cambiadas: %d",
			frase.toUpperCase(), cambios
		);
	}
}
