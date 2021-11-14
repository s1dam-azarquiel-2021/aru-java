package simpleYDoble;

import java.util.Scanner;

public class Ordenar3Numeros {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce 3 numeros: ");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int z = scanner.nextInt();
		scanner.close();

		if (x < y) {
			int temp = x;
			x = y;
			y = temp;
		}
		if (y < z) {
			int temp = y;
			y = z;
			z = temp;
		}
		if (x < y) {
			int temp = x;
			x = y;
			y = temp;
		}

		System.out.printf("%d %d %d\n", x, y, z);
	}
}
