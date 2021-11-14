package simpleYDoble;

import java.util.Scanner;

public class EsVocal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce una vocal:");
		char vocal = scanner.nextLine().charAt(0);
		scanner.close();

		switch (vocal) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			System.out.printf("Es una vocal\n");
		default:
			System.out.printf("No es una vocal\n");
		}
	}
}
