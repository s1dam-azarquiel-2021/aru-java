package pruebas;

public class Prueba3D {
	public static void main(String[] args) {
		int[][][] datos = {
			{
				{ 20, 22 },
				{ 16, 19 },
				{ 28, 25 },
				{ 16, 14 }
			},
			{
				{ 22, 25 },
				{ 22, 15 },
				{ 20, 20 },
				{ 21, 25 }
			},
			{
				{ 19, 27 },
				{ 17, 18 },
				{ 25, 18 },
				{ 23, 21 }
			},
			{
				{ 27, 20 },
				{ 19, 23 },
				{ 22, 19 },
				{ 19, 20 }
			},
			{
				{ 20, 23 },
				{ 19, 21 },
				{ 23, 24 },
				{ 20, 22 }
			},
		};

		String[] grados = {
			"Derecho",
			"Magisterio",
			"Informatico",
			"Periodismo",
			"ADE"
		};

		String[] cursos = {
			"Primero",
			"Segundo",
			"Tercero",
			"Cuarto"
		};

		String[] sexo = { "Hombres", "Mujeres" };

		for (int i = 0; i < datos.length; i++) {
			int suma = 0;
			for (int j = 0; j < datos[i].length; j++) {
				for (int k = 0; k < datos[i][k].length; k++) {
					suma += datos[i][j][k];
				}
			}
			System.out.printf("%s: %d alumnos\n", grados[i], suma);
		}

		System.out.printf("\n");

		for (int j = 0; j < datos[0].length; j++) {
			int suma = 0;
			for (int i = 0; i < datos.length; i++) {
				for (int k = 0; k < datos[i][j].length; k++) {
					suma += datos[i][j][k];
				}
			}
			System.out.printf("%s: %d alumnos\n", cursos[j], suma);
		}

		System.out.printf("\n");

		for (int k = 0; k < datos[0][0].length; k++) {
			int suma = 0;
			for (int i = 0; i < datos.length; i++) {
				for (int j = 0; j < datos[i].length; j++) {
					suma += datos[i][j][k];
				}
			}
			System.out.printf("%s: %d alumnos\n", sexo[k], suma);
		}

		System.out.printf("\n");

		for (int i = 0; i < datos.length; i++) {
			System.out.printf("%s:\n", grados[i]);
			for (int j = 0; j < datos[i].length; j++) {
				System.out.printf("\t%s: ", cursos[j]);
				int suma = 0;
				for (int k = 0; k < datos[i][j].length; k++) {
					suma += datos[i][j][k];
				}
				System.out.printf("%d\n", suma);
			}
		}

		System.out.printf("\n");

		for (int i = 0; i < datos.length; i++) {
			System.out.printf("%s:\n", grados[i]);
			int sumaM = 0;
			int sumaF = 0;
			for (int j = 0; j < datos[i].length; j++) {
				for (int k = 0; k < datos[i][j].length; k++) {
					if (sexo[k].equals("Hombres")) {
						sumaM += datos[i][j][k];
					} else if (sexo[k].equals("Mujeres")) {
						sumaF += datos[i][j][k];
					}
				}
			}
			System.out.printf("\t%s: %d\n", "Hombres", sumaM);
			System.out.printf("\t%s: %d\n", "Mujeres", sumaF);
		}
	}
}
