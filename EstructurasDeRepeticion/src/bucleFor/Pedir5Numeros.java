package bucleFor;

import java.util.Scanner;

public class Pedir5Numeros {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Pedir 5 numeros por Input
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.printf("Introduce un numero: ");
			int a = input.nextInt();
		}
		input.close();
	}
}
