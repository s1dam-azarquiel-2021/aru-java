package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		// Obtener la longitud de los tres lados de un triangulo por Input
		Scanner input = new Scanner(System.in);
		System.out.printf(
			"Introduce 3 lados de un triangulo, siendo el primero el mayor: "
		);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		input.close();

		if (a >= b + c) {
			System.out.printf("Eso no es un triangulo.\n");
		} else {
			// Calcular los cuadrados de cada lado para no repetir lo mismo
			// varias veces
			final int A2 = a * a;
			final int B2 = b * b;
			final int C2 = c * c;

			// Calcular la suma de B2 y C2, por lo mismo que antes
			final int SUMA_B2_C2 = B2 + C2;

			if (A2 < SUMA_B2_C2) {
				System.out.printf("Eso es un triangulo acutangulo.\n");
			} else if (A2 > SUMA_B2_C2) {
				System.out.printf("Eso es un triangulo obtusangolo.\n");
			} else {
				System.out.printf("Eso es un triangulo rectangulo.\n");
			}
		}
	}
}
