package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		// Programa que sume todas las cifras de los numeros que aparecen en
		// una cadena de caracteres

		System.out.print("Introduce una frase: ");
		Scanner input = new Scanner(System.in);
		StringBuilder frase = new StringBuilder(input.nextLine());
		input.close();

		int suma = 0;
		for (int i = 0; i < frase.length(); i++) {
			int valorAscii = frase.charAt(i);
			// El valor 48 es un 0, no hace falta sumar un 0
			// El valor 57 es un 9
			// Asi que desde 49 hasta 57 son los numeros 1 al 9
			if (valorAscii > 48 && valorAscii < 58) {
				suma += valorAscii - 48;
			}
		}

		System.out.printf("Suma de todas las cifras: %d", suma);
	}
}
