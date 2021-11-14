package bucleFor;

import java.util.Scanner;

public class TablaDelNumeroDado {
	public static void main(String[] args) {
		// Pedir un numero por input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce un numero: ");
		final int n = input.nextInt();
		input.close();

		for (int i = 0; i <= 10; i++) {
			System.out.printf(
				"%d x %d = %d\n",
				n, i, (i * n)
			);
		}
	}
}
