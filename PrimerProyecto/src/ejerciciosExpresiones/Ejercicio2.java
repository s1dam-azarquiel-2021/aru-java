package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int n = scanner.nextInt();
		scanner.close();

		boolean esMultiploDe7 = (n % 7) == 0;
		System.out.println("\nEs multiplo de 7: " + esMultiploDe7);
	}
}
