package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		// Programa que lea un numero double, lo convierta a una cadena
		// y le meta las comas separadoras de los miles

		System.out.print("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		double numero = input.nextDouble();
		input.close();

		StringBuilder numeroFinal = new StringBuilder(String.valueOf(numero));
		for (int i = numeroFinal.indexOf(".") - 3; i > 0; i -= 3) {
			numeroFinal.insert(i, ",");
		}

		System.out.printf("Numero con comas: %s", numeroFinal);
	}
}
