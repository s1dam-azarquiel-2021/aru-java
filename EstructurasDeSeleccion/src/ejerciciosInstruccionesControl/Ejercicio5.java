package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		// Obtener los valores a, b y c de la ecuacion de 2do grado por Input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce a, b y c: ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		input.close();

		// Calcular el discriminante
		final int discriminante = b * b - 4 * a * c;

		// Segun el valor del discriminante varian las soluciones
		if (discriminante > 0) {
			// Hay dos soluciones
			final double X1 = (-b + Math.sqrt(discriminante)) / (2 * a);
			final double X2 = (-b - Math.sqrt(discriminante)) / (2 * a);
			System.out.printf(
				"x1 = %d\nx2 = %d/n",
				X1, X2
			);
		} else if (discriminante < 0) {
			// No hay solucion
			System.out.printf("No existe solucion\n");
		} else {
			// Hay solo una solucion
			final double X = -b / (2 * a);
			System.out.printf("x = %d\n", X);
		}
	}
}
