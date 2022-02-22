package simpleYDoble;

import java.util.Scanner;

public class MayorDeEdad {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce tu edad:");
		int edad = scanner.nextInt();
		scanner.close();

		// if (edad >= 18) {
		// System.out.printf("Enhorabuena!!! Ya puedes votar");
		// }

		if (edad >= 18) {
			System.out.printf("Enhorabuena!!! Ya puedes votar\n");
		} else {
			System.out.printf("No puedes votar, con la ilusion que te hacia\n");
		}
	}
}
