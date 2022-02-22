package ejerciciosStrings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio17 {
	public static void main(String[] args) {
		// Realiza un programa que averigue cuantas asignaturas tiene aprobadas
		// un alumno. El programa debe leer un String con el nombre de las
		// asignaturas y despues otro String con la lista de sus notas. Debe
		// dar como resultado el nombre de las asignaturas aprobadas. Tanto la
		// lista de asignaturas como la lista de notas utilizan el simbolo ':'
		// como separador.

		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce las asignaturas:\n");
		StringTokenizer asignaturas = new StringTokenizer(
			input.nextLine(), ":"
		);

		System.out.printf("Introduce las notas:\n");
		StringTokenizer notas = new StringTokenizer(input.nextLine(), ":");
		input.close();

		if (asignaturas.countTokens() == notas.countTokens()) {
			StringBuilder aprobadas = new StringBuilder("");

			while (asignaturas.hasMoreTokens()) {
				if (Integer.parseInt(notas.nextToken()) >= 5) {
					aprobadas.append(asignaturas.nextToken() + " ");
				} else {
					asignaturas.nextToken();
				}
			}

			System.out.printf("\nAsignaturas aprobadas: %s\n", aprobadas);
		} else {
			System.out.printf(
				"Tiene que haber la misma cantidad"
					+ " de asignaturas que de notas\n"
			);
		}
	}
}
