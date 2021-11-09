package simpleYDoble;

import java.util.Scanner;

public class ParImpar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int n = scanner.nextInt();
		scanner.close();

		if (n % 2 == 0) {
			System.out.println("\nEs par");
		} else {
			System.out.println("\nEs impar");
		}
	}
}
