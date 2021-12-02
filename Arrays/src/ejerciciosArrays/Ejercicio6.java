package ejerciciosArrays;

public class Ejercicio6 {
	public static void main(String[] args) {
		// Programa que rellene un array de 4x4 de la siguiente manera:

		int[][] array = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <	4; j++) {
				if (j == i) {
					array[i][j] = 1;
				} else {
					array[i][j] = 0;
				}
			}
		}

		for (int[] n : array) {
			for (int m : n) {
				System.out.printf("%d ", m);
			}
			System.out.printf("\n");
		}
	}
}
