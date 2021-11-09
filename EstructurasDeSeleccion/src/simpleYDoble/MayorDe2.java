package simpleYDoble;

import java.util.Scanner;

public class MayorDe2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce dos numeros:" );
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.close();

		if (x == y) {
			System.out.println("\nSon iguales");
		} else {
			System.out.println("\nEl mayor es: " + (x > y ? x : y));
		}
	}
}
