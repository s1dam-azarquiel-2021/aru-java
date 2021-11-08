package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		// Obtener una nota por Input
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una nota del 0 al 10: ");
		int nota = input.nextInt();
		input.close();
		
		switch (nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("Insuficiente.");
			break;
		case 5:
			System.out.println("Suficiente.");
			break;
		case 6:
			System.out.println("Bien.");
			break;
		case 7:
		case 8:
			System.out.println("Notable.");
			break;
		case 9:
		case 10:
			System.out.println("Sobresaliente.");
			break;
		default:
			System.out.println("Que nota mas rara tienes.");
			break;
		}
	}
}
