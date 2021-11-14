package bucleWhile;

import java.util.Scanner;

public class SumarSoloPositivos {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		int suma = 0;
		do {
			suma += n;
			System.out.printf("Introduce un numero: ");
			n = input.nextInt();
		} while (n > 0);
		input.close();

		System.out.printf("Suma total: %d\n", suma);
	}
}
