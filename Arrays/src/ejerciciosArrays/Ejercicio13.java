package ejerciciosArrays;

import java.util.ArrayList;

public class Ejercicio13 {
	public static void main(String[] args) {
		// Crea un programa que almacene en un array bidimensional (6x6) con
		// pocos valores en un array unidimensional. En el array unidimensional
		// vamos almacenando cada valor original junto con su fila y columna,
		// es decir por cada valor del array original almacenamos tres valores
		// en el resultado.

		int[][] array = {
			{
				0, 0, 0, 0, 0, 0
			}, {
				0, 0, 0, 0, 5, 0
			}, {
				0, 8, 0, 0, 0, 9
			}, {
				0, 0, 0, 0, 0, 0
			}, {
				0, 0, 0, 7, 0, 0
			}, {
				0, 0, 3, 0, 0, 0
			}
		};

		ArrayList<Integer> resultado = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					resultado.add(array[i][j]);
					resultado.add(i);
					resultado.add(j);
				}
			}
		}

		for (int i = 0; i < resultado.size(); i++) {
			System.out.printf("%d ", resultado.get(i));
			if (i % 3 == 2) {
				System.out.printf("\n");
			}
		}
	}
}
