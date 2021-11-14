package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce un año: ");
		int n = scanner.nextInt();
		scanner.close();

		boolean esBisiesto = n % 400 == 0 || (n % 4 == 0 && n % 100 != 0);
		System.out.printf("Es bisiesto: %s\n", esBisiesto);
	}
}
