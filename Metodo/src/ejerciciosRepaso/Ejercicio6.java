package ejerciciosRepaso;

import java.util.Scanner;

public class Ejercicio6 {
	public static void jugar7yMedia() {
		double puntos = 0;
		Scanner input = new Scanner(System.in);
		while (puntos < 7.5) {
			barajar();
			System.out.printf("Elige que carta tomar [1-40]: ");
			int pos = input.nextInt();

			double carta = tomarCarta(pos);
			System.out.printf("Es un %.1f.\n", carta);

			puntos += carta;
			System.out.printf("Tienes %.1f puntos.\n", puntos);
		}
		input.close();

		if (puntos == 7.5) {
			System.out.printf("Has ganado!\n");
		} else {
			System.out.printf("Mala suerte.\n");
		}
	}

	public static void barajar() {
		if (baraja[0] == 0) {
			rellenarBaraja();
		}

		System.out.printf("Barajando!\n");

		for (int i = 0; i < Math.random() * 20 + 20; i++) {
			intercambiar(
				baraja, (int) (Math.random() * 40), (int) (Math.random() * 40)
			);
		}
	}

	public static void rellenarBaraja() {
		System.out.printf("Rellenando baraja!\n");

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				baraja[i * 10 + j] = j < 7 ? j + 1 : 0.5;
			}
		}
	}

	public static double tomarCarta(int pos) {
		return baraja[pos - 1];
	}

	static double[] baraja = new double[40];

	public static void intercambiar(double[] array, int pos1, int pos2) {
		double temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}
}
