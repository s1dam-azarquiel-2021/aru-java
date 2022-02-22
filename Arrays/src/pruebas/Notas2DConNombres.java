package pruebas;

public class Notas2DConNombres {
	public static void main(String[] args) {
		int[][] notas = {
			{
				8, 10, 6, 2, 3, 5, 9
			}, {
				9, 9, 9, 5, 3, 5, 7
			}, {
				7, 10, 5, 6, 2, 8, 8
			}
		};

		String[] alumnos = {
			"Juan", "Maria", "Carlos"
		};

		String[] modulos = {
			"BBDD", "Programacion", "Ingles", "FOL", "Sistemas", "Entornos",
			"Lenguaje de Marcas"
		};

		for (int i = 0; i < notas.length; i++) {
			System.out.printf("%s:", alumnos[i]);
			for (int j = 0; j < notas[i].length; j++) {
				if (notas[i][j] >= 5) {
					System.out.printf(" %s", modulos[j]);
				}
			}
			System.out.printf("\n");
		}

		System.out.printf("\n");

		for (int j = 0; j < notas[0].length; j++) {
			System.out.printf("%s:", modulos[j]);
			for (int i = 0; i < notas.length; i++) {
				if (notas[i][j] >= 5) {
					System.out.printf(" %s", alumnos[i]);
				}
			}
			System.out.printf("\n");
		}

		System.out.printf("\n");

		for (int i = 0; i < notas.length; i++) {
			int suma = 0;
			for (int j = 0; j < notas[i].length; j++) {
				suma += notas[i][j];
			}
			System.out.printf(
				"%s: %.1f\n", alumnos[i], (double) (suma / notas[i].length)
			);
		}

		System.out.printf("\n");

		double mejorMedia = 0;
		int iMejorMedia = 0;

		for (int j = 0; j < notas[0].length; j++) {
			int suma = 0;
			for (int i = 0; i < notas.length; i++) {
				suma += notas[i][j];
			}
			double media = suma / notas.length;
			if (media > mejorMedia) {
				mejorMedia = media;
				iMejorMedia = j;
			}
		}

		System.out.printf("%s: %.1f\n", modulos[iMejorMedia], mejorMedia);
	}
}
