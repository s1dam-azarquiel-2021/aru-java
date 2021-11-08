package bucleWhile;

import java.util.Scanner;

public class SumaDeFracciones {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un total: ");
		double total = input.nextDouble();
		input.close();

		double suma = 0;
		long nSumas = 0;
		while (suma < total) {
			// Le sumamos el resultado de dividir 1 y el siguiente contador
			suma += 1.0 / ++nSumas;
		}

		System.out.println("Se necesitaron " + nSumas + " sumas.");
	}
}
