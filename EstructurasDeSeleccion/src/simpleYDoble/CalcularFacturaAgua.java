package simpleYDoble;

import java.util.Scanner;

public class CalcularFacturaAgua {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce litros: ");
		int metros3 = scanner.nextInt();
		scanner.close();

		final int pCaro = 10;
		final int pMedio = 4;
		final int pBajo = 1;

		final int limiteCaro = 20;
		final int limiteMedio = 10;
		final int limiteBajo = 0;

		int total = 0;
		if (metros3 > limiteCaro) {
			total = (limiteMedio - limiteBajo) * pBajo +
					(limiteCaro - limiteMedio) * pMedio +
					(metros3 - limiteCaro) * pCaro;
		} else if (metros3 > limiteMedio) {
			total = (limiteMedio - limiteBajo) * pBajo +
					(metros3 - limiteMedio) * pMedio;
		} else {
			total = metros3 * pBajo;
		}

		System.out.printf("Pagaras: %d\n", total);
	}
}
