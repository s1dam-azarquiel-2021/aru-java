package ejerciciosArrays;

public class Ejercicio7 {
	public static void main(String[] args) {
		int[][] array = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		int[] sumaFilas = new int[array.length];
		int[] sumaColumnas = new int[array[0].length];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sumaFilas[i] += array[i][j];
				sumaColumnas[j] += array[i][j];
			}
		}

		for (int i = 0; i < sumaFilas.length; i++) {
			System.out.printf("Fila %d: %d\n", i, sumaFilas[i]);
		}

		for (int i = 0; i < sumaColumnas.length; i++) {
			System.out.printf("Columna %d: %d\n", i, sumaColumnas[i]);
		}
	}
}
