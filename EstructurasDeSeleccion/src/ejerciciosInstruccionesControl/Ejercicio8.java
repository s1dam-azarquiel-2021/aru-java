package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		// Obtener un numero por Input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce un numero del 0 al 9999: ");
		int n = input.nextInt();
		input.close();

		// Calcular el numero del reves
		int n_reves = 0,
			resto = n;

		n_reves += resto % 10 * 1000;
		resto /= 10;
		n_reves += resto % 10 * 100;
		resto /= 10;
		n_reves += resto % 10 * 10;
		resto /= 10;
		n_reves += resto % 10;

		// Segun sea menor de potencias de 10 sabremos cuantas cifras tiene
		// Con un bucle seria mas facil
		if (n < 10) {
			System.out.printf("Del reves: %d\n", n_reves / 1000);
		} else if (n < 100) {
			System.out.printf("Del reves: %d\n", n_reves / 100);
		} else if (n < 1000) {
			System.out.printf("Del reves: %d\n", n_reves / 10);
		} else if (n < 10000) {
			System.out.printf("Del reves: %d\n", n_reves);
		} else {
			System.out.printf("Demasiadas cifras\n");
		}
	}
}
