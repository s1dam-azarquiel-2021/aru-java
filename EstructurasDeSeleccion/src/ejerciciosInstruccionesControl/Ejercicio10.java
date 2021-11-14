package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		// Obtener una nota por Input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce una nota del 0 al 10: ");
		int nota = input.nextInt();
		input.close();

		switch (nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.printf("Insuficiente.\n");
			break;
		case 5:
			System.out.printf("Suficiente.\n");
			break;
		case 6:
			System.out.printf("Bien.\n");
			break;
		case 7:
		case 8:
			System.out.printf("Notable.\n");
			break;
		case 9:
		case 10:
			System.out.printf("Sobresaliente.\n");
			break;
		default:
			System.out.printf("Que nota mas rara tienes.\n");
			break;
		}
	}
}
