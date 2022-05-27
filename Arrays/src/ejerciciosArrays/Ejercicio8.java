package ejerciciosArrays;

public class Ejercicio8 {
	public static void main(String[] args) {
		// Comprobar si un array de 5x5 es un cuadrado magico. Se considera un
		// cuadro magico aquel en el que las filas, las columnas y las
		// diagonales suman igual

		int[][] array = {
			{
				15, 8, 1, 24, 17
			}, {
				16, 14, 7, 5, 23
			}, {
				22, 20, 13, 6, 4
			}, {
				3, 21, 19, 12, 10
			}, {
				9, 2, 25, 18, 11
			}
		};

		int[] sumaFilas = new int[array.length];
		int[] sumaColumnas = new int[array[0].length];
		int[] sumaDiagonales = new int[2];
		boolean esMagico = true;

		for (int i = 0; i < array.length && esMagico; i++) {
			for (int j = 0; j < array[i].length && esMagico; j++) {
				sumaFilas[i] += array[i][j];
				sumaColumnas[j] += array[i][j];

				if (i == j) {
					sumaDiagonales[0] += array[i][j];
				}

				if (j == array[i].length - i - 1) {
					sumaDiagonales[1] += array[i][j];
				}

				if (
					i == array.length - 1 && sumaColumnas[j] != sumaColumnas[0]
				) {
					esMagico = false;
				}
			}
			if (sumaFilas[i] != sumaFilas[0]) {
				esMagico = false;
			}
		}

		if (
			sumaDiagonales[0] != sumaDiagonales[1]
			|| sumaDiagonales[0] != sumaFilas[0]
			|| sumaDiagonales[0] != sumaColumnas[0]
		) {
			esMagico = false;
		}

		if (esMagico) {
			System.out.printf("Es un cuadrado magico\n");
		} else {
			System.out.printf("No es un cuadrado magico\n");
		}
	}
}
