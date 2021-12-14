package ejerciciosArrays;

public class Ejercicio11 {
	public static void main(String[] args) {
		// Elabora un programa al que se le pasa un array de 2 dimensiones y
		// averigua si es simetrica, retornando un valor booleano. Un array
		// es simetrico si contiene los mismos valores por encima y por debajo
		// de la diagonal principal.

		int[][] array = {
			{ 1, 4, 6, 2, 9 },
			{ 4, 8, 5, 5, 3 },
			{ 6, 5, 4, 7, 2 },
			{ 2, 5, 7, 9, 4 },
			{ 9, 3, 2, 4, 3 }
		};

		boolean esSimetrico = true;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length && esSimetrico; j++) {
				if (array[i][j] != array[j][i]) {
					esSimetrico = false;
				}
			}
		}

		System.out.printf("Es espejo: %s\n", esSimetrico);
	}
}
