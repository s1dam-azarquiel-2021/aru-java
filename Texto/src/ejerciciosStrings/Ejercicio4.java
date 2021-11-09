package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		// Programa que rote una cadena tantas veces como se le diga

		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una frase: ");
		StringBuilder frase = new StringBuilder(input.nextLine());
		System.out.print("Introduce el numero de rotaciones: ");
		int n = input.nextInt();
		input.close();

		int lFrase = frase.length();
		frase.insert(0, frase.substring(lFrase - n));

		lFrase = frase.length();
		frase.delete(lFrase - n, lFrase);

		System.out.printf(
			"%s",
			frase
		);
	}
}
