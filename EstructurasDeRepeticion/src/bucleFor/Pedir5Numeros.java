package bucleFor;

import java.util.Scanner;

public class Pedir5Numeros {
	public static void main(String[] args) {
		// Pedir 5 numeros por Input
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce un numero: ");
			@SuppressWarnings("unused")
			int a = input.nextInt();
		}
		input.close();
	}
}
