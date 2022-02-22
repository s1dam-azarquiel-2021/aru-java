package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce dinero: ");
		int dinero = scanner.nextInt();
		scanner.close();

		final int[] billetes = {
			500, 200, 100, 50, 20, 10, 5
		};

		for (int i : billetes) {
			System.out.printf("%d\n", dinero / i);
			dinero %= i;
		}
	}
}
