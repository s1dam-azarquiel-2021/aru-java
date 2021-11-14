package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce un numero: ");
		int n = scanner.nextInt();
		scanner.close();

		boolean esMultiploDe7 = (n % 7) == 0;
		System.out.printf("Es multiplo de 7: %s\n", esMultiploDe7);
	}
}
