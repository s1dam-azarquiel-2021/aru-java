package simpleYDoble;

import java.util.Scanner;

public class EstadoCivil {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce tu letra del estado civil: ");
		char letra = scanner.nextLine().charAt(0);
		scanner.close();

		switch (letra) {
		case 's':
		case 'S':
			System.out.printf("Soltero/a\n");
			break;
		case 'c':
		case 'C':
			System.out.printf("Casado/a\n");
			break;
		case 'v':
		case 'V':
			System.out.printf("Viudo/a\n");
			break;
		case 'd':
		case 'D':
			System.out.printf("Divorciado/a\n");
			break;
		default:
			System.out.printf("Letra incorrecta\n");
		}
	}
}
