package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce tres numeros: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();

		boolean estanOrdenados = a > b && b > c || a < b && b < c;
		System.out.printf("Estan ordenados: %s\n", estanOrdenados);
	}
}
