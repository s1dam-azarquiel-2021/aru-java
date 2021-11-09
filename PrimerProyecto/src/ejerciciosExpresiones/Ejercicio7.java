package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce tres numeros: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();

		boolean estanOrdenados = a > b && b > c || a < b && b < c;
		System.out.println("\nNumero 1: " + a
				+ "\nNumero 2: " + b
				+ "\nNumero 3: " + c
				+ "\nEstan ordenados: " + estanOrdenados);
	}
}
