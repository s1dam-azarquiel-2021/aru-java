package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		// Obtener horas, minutos y segundos por Input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce horas, minutos y segundos: ");
		int h = input.nextInt();
		int m = input.nextInt();
		int s = input.nextInt();
		input.close();

		// Calcular el total de minutos
		// (los segundos ya son el total y las horas no hay que transformarlas)
		final int M_TOTALES = m + s / 60;
		// Transformar lo anterior en expresiones correctas
		final int S_CORRECTO = s % 60;
		final int M_CORRECTO = M_TOTALES % 60;
		final int H_CORRECTO = h + M_TOTALES / 60;

		System.out.printf(
			"%d horas, %d minutos y %d segundos.\n",
			H_CORRECTO, M_CORRECTO, S_CORRECTO
		);
	}
}
