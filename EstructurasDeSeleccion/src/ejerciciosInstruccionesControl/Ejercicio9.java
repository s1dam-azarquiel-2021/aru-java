package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) {
		// Obtener un numero por Input
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un numero del 0 al 9999: ");
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
			n_reves /= 1000;
		} else if (n < 100) {
			n_reves /= 100;
		} else if (n < 1000) {
			n_reves /= 10;
		}		

		if (n == n_reves) {
			System.out.println("Es un numero capicua.");
		} else {
			System.out.println("No es un numero capicua.");
		}
	}
}
