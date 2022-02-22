package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {
		System.out.printf("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();

		int espacios = n / 2;
		boolean centroHecho = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j > espacios && j <= n - espacios) {
					System.out.printf("* ");
				} else {
					System.out.printf("  ");
				}
			}

			System.out.printf("\n");
			if (espacios == 0) {
				centroHecho = true;
				espacios = 1;
			} else if (!centroHecho) {
				espacios--;
			} else {
				espacios++;
			}
		}
	}
}
