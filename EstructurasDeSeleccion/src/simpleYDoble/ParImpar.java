package simpleYDoble;

import java.util.Scanner;

public class ParImpar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce un numero: ");
		int n = scanner.nextInt();
		scanner.close();

		if (n % 2 == 0) {
			System.out.printf("Es par\n");
		} else {
			System.out.printf("Es impar\n");
		}
	}
}
