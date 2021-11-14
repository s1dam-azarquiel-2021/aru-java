package simpleYDoble;

import java.util.Scanner;

public class DiaDeLaSemana {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce numero de dia:");
		int dia = scanner.nextInt();
		scanner.close();

		switch (dia) {
		case 1:
			System.out.printf("Lunes\n");
			break;
		case 2:
			System.out.printf("Martes\n");
			break;
		case 3:
			System.out.printf("Miercoles\n");
			break;
		case 4:
			System.out.printf("Jueves\n");
			break;
		case 5:
			System.out.printf("Viernes\n");
			break;
		case 6:
			System.out.printf("Sabado\n");
			break;
		case 7:
			System.out.printf("Domingo\n");
			break;
		default:
			System.out.printf("Ese numero no existe\n");
		}
	}
}
