package pruebas;

public class Notas {
	public static void main(String[] args) {
		// Trabajar con un array de notas
		// y otro con los modulos

		int[] notas = { 10, 10, 9, 8, 8, 6, 5 };
		String[] modulos = {
			"Programacion",
			"Lenguaje de marcas",
			"Sistemas",
			"Entornos",
			"Ingles",
			"Bases de datos",
			"FOL"
		};

		System.out.printf("Aprobadas:\n----------\n");
		for (int i = 0; i < modulos.length; i++) {
			if (notas[i] >= 5) {
				System.out.printf("%s\n", modulos[i]);
			}
		}

		// Quiero saber cual es mi modulo favorito
		int posMayor = -1;
		for (int i = 0; i < modulos.length; i++) {
			if (notas[i] > notas[posMayor]) {
				posMayor = i;
			}
		}
		System.out.printf(
			"\nTu asignatura favorita es:\n%s\n",
			modulos[posMayor]
		);
	}
}
