package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		// Obtener los valores a, b y c de la ecuacion de 2do grado por Input
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce a, b y c: ");
		int a = input.nextInt(),
			b = input.nextInt(),
			c = input.nextInt();
		input.close();
		
		// Calcular el discriminante
		final int discriminante = b * b - 4 * a * c;
		
		// Segun el valor del discriminante varian las soluciones
		if (discriminante > 0) {
			// Hay dos soluciones
			final double x1 = (-b + Math.sqrt(discriminante)) / (2 * a),
						 x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
			System.out.println("x1 = " + x1 + "\n"
							 + "x2 = " + x2);
		} else if (discriminante < 0) {
			// No hay solucion
			System.out.println("No existe solucion");
		} else {
			// Hay solo una solucion
			final double x = -b / (2 * a);
			System.out.println("x = " + x);
		}
	}
}
