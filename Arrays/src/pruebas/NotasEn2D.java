package pruebas;

public class NotasEn2D {
	public static void main(String[] args) {
		// Notas de las tres evaluaciones en un mismo array

		int[][] notas = {
			{
				8, 10, 6, 2, 3, 5, 9
			}, {
				9, 9, 9, 5, 3, 5, 7
			}, {
				7, 10, 5, 6, 2, 8, 8
			}
		};

		for (int[] element : notas) {
			for (int element2 : element) {
				System.out.printf("%2d ", element2);
			}
			System.out.printf("\n");
		}

		int[] totalEvaluaciones = new int[notas.length];
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				totalEvaluaciones[i] += notas[i][j];
			}
		}

		System.out.printf("\nTotal de cada evaluacion:\n");
		for (int i = 0; i < totalEvaluaciones.length; i++) {
			System.out.printf("Evaluacion %d: %d\n", i, totalEvaluaciones[i]);
		}

		int[] totalColumnas = new int[notas[0].length];
		for (int[] element : notas) {
			for (int j = 0; j < element.length; j++) {
				totalColumnas[j] += element[j];
			}
		}

		System.out.printf("\nTotal de cada columna:\n");
		for (int i = 0; i < totalColumnas.length; i++) {
			System.out.printf("Columna %d: %d\n", i, totalColumnas[i]);
		}

		int aprobados = 0;
		for (int[] element : notas) {
			for (int element2 : element) {
				if (element2 >= 5) {
					aprobados++;
				}
			}
		}

		System.out.printf("\nTotal aprobados: %d\n\n", aprobados);

		int[] aprobadosPorEvaluacion = new int[notas.length];
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				if (notas[i][j] >= 5) {
					aprobadosPorEvaluacion[i]++;
				}
			}
		}

		for (int i = 0; i < aprobadosPorEvaluacion.length; i++) {
			System.out.printf(
				"Aprobados en %da Ev: %d\n", i + 1, aprobadosPorEvaluacion[i]
			);
		}
	}
}
