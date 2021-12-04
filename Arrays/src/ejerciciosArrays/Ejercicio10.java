package ejerciciosArrays;

public class Ejercicio10 {
	public static void main(String[] args) {
		// Dado un array de 5x5, realizar un algoritmo que lo rellene como en
		// la figura.

		// Edit: me cago en todo me sale del reves:
		// 4 3 2 1 0
		// 3 2 1 0 1
		// 2 1 0 1 2
		// 1 0 1 2 3
		// 0 1 2 3 4

		int[][] array = new int [5][5];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.abs(j + i - array.length + 1);
			}
		}

		System.out.printf("Figura:\n");
		for (int[] n : array) {
			for (int m : n) {
				System.out.printf("%d ", m);
			}
			System.out.printf("\n");
		}
	}
}
