package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		// Igual al anterior, pero sumando los numeros completos

		System.out.print("Introduce una frase: ");
		Scanner input = new Scanner(System.in);
		StringBuilder frase = new StringBuilder(input.nextLine());
		input.close();

		int suma = 0;
		int numActual = 0;
		for (int i = 0; i < frase.length(); i++) {
			int valorAscii = frase.charAt(i);
			// Aqui si que necesitamos contar el 0
			// Si no un 100 lo veria como un 1
			if (valorAscii >= 48 && valorAscii < 58) {
				numActual *= 10;
				numActual += valorAscii - 48;
			} else {
				suma += numActual;
				numActual = 0;
			}
		}

		// Por si acaso quedo algun numero sin sumarse
		suma += numActual;

		System.out.printf("Suma de todas las cifras: %d", suma);
	}
}
