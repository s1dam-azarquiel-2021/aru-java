package ejerciciosArrays;

public class Ejercicio7 {
	public static void main(String[] args) {
		// Dado un array de 3x3 elementos, calcular la suma de sus filas y sus
		// columnas almacenandolas en dos array de 3 elementos.

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
