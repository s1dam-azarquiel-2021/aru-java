package ejerciciosArrays;

import java.util.Scanner;

public class Ejercicio14 {
	public static void main(String[] args) {
		// Programa que simule el juego de las minas. El programa rellenara
		// de forma aleatoria un array de 5x5 con 10 minas. Una vez relleno,
		// pedira que escribamos coordenadas y mostrara el mensaje MINA, en
		// caso de haber pisado una, o bien un numero que indica cuantos minas
		// hay alredador.

		int[][] mapaMinas = new int[5][5];
		final int N_MINAS = 10;
		for (int i = 0; i < N_MINAS; i++) {
			int iRandom = (int) (Math.abs(Math.random() * N_MINAS - 5));
			int jRandom = (int) (Math.abs(Math.random() * N_MINAS - 5));

			if (mapaMinas[iRandom][jRandom] == 0) {
				mapaMinas[iRandom][jRandom] = 1;
			} else {
				i--;
			}
		}

		boolean esGanador = true;
		int intentos = 0;
		int[][] mapaJugador = new int[5][5];

		final int N_F_MAPAJ = mapaJugador.length;
		final int N_C_MAPAJ = mapaJugador[0].length;

		Scanner input = new Scanner(System.in);
		while (esGanador && intentos < (N_F_MAPAJ * N_C_MAPAJ - N_MINAS)) {
			System.out.printf(
				"Introduce la fila (del 1 al %d): ",
				mapaMinas.length
			);
			int fila = input.nextInt();
			fila--;
			System.out.printf(
				"Introduce la columna (del 1 al %d): ",
				mapaMinas[0].length
			);
			int columna = input.nextInt();
			columna--;

			if (mapaMinas[fila][columna] == 1) {
				System.out.printf("MINA!\n");
				esGanador = false;
			} else {
				if (mapaJugador[fila][columna] != 0) {
					System.out.printf("Ya probaste ahi\n");
				}

				int nMinas = 0;
				for (int i = fila - 1; i <= fila + 1; i++) {
					for (int j = columna - 1; j <= columna + 1; j++) {
						if (
							i >= 0 && j >= 0
							&& i < N_F_MAPAJ && j < N_C_MAPAJ
							&& mapaMinas[i][j] == 1
						) {
							nMinas++;
						}
					}
				}
				System.out.printf("%d minas alrededor\n\n", nMinas);

				if (nMinas == 0) {
					mapaJugador[fila][columna] = -1;
				} else {
					mapaJugador[fila][columna] = nMinas;
				}

				System.out.printf("Mapa actual:\n");
				for (int i = 0; i < N_F_MAPAJ; i++) {
					System.out.printf( "%s\n|", "-".repeat(N_F_MAPAJ * 4 + 1));
					for (int j = 0; j < N_C_MAPAJ; j++) {
						int actual = mapaJugador[i][j];
						if (actual == 0) {
							System.out.printf("   |");
						} else if (actual == -1) {
							System.out.printf(" 0 |");
						} else {
							System.out.printf(" %d |", actual);
						}
					}
					System.out.printf("\n");
				}
				System.out.printf( "%s\n\n", "-".repeat(N_F_MAPAJ * 4 + 1));
			}

			intentos++;
		}
		input.close();

		if (esGanador) {
			System.out.printf("\n\nGanador!\n");
		} else {
			System.out.printf("\n\nPenoso!\n");
		}
	}
}
