package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		byte nMultiplos3 = 0;
		byte nMultiplos5 = 0;
		byte nMultplosNada = 0;

		// Leer 5 numeros
		Scanner input = new Scanner(System.in);
		for (byte i = 0; i < 5; i++) {
			System.out.printf("Introduce un numero: ");
			int n = input.nextInt();

			// Calcular si son divisibles entre 3 y 5
			final boolean divisible3 = n % 3 == 0;
			final boolean divisible5 = n % 5 == 0;

			// Segun sean, se cuenta
			if (divisible3) {
				nMultiplos3++;
			}
			if (divisible5) {
				nMultiplos5++;
			}
			if (!(divisible3 || divisible5)) {
				nMultplosNada++;
			}
		}
		input.close();

		System.out.printf(
			"%d multiplos de 3\n%d multiplos de 5\n%d multiplos de nada",
			nMultiplos3, nMultiplos5, nMultplosNada
		);
	}
}
