package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		// Obtener un numero por Input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce un numero del 0 al 9999: ");
		int n = input.nextInt();
		input.close();

		// Segun sea menor de potencias de 10 sabremos el resultado
		// Con un bucle seria mas facil
		if (n < 10) {
			System.out.printf("Tiene 1 cifra\n");
		} else if (n < 100) {
			System.out.printf("Tiene 2 cifras\n");
		} else if (n < 1000) {
			System.out.printf("Tiene 3 cifras\n");
		} else if (n < 10000) {
			System.out.printf("Tiene 4 cifras\n");
		} else {
			System.out.printf("Demasiadas cifras\n");
		}
	}
}
