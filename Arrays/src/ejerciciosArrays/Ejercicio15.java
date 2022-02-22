package ejerciciosArrays;

import java.util.Scanner;

public class Ejercicio15 {
	public static void main(String[] args) {
		// Escribe un programa que genere automaticamente un cuadrado magico.
		// Un cuadro magico es aquel en el que todas sus filas, columnas y
		// diagonales suman igual. Se debe generar un cuadro de size impar.
		// Ejemplo: si elegimos un cuadro de 5x5 este hay que rellenarlo con
		// numeros del 1 al 25.
		// El proceso de generacion consiste en situar el numero 1 en el centro
		// de la primera fila, el numero siguienteen la casilla situada encima y
		// a la derecha y asi sucesivamente. Suponemos que el array es ciclico,
		// entonces la casilla encima de la primera fila es la ultima fila, y la
		// casilla a la derecha de la ultima es la primera. En caso de caer en
		// una casilla ya ocupada se coloca el numero debajo del que acabamos de
		// colocar.

		Scanner input = new Scanner(System.in);
		System.out.printf("Como de grande quieres el cuadrado: ");
		int n = input.nextInt();
		input.close();

		int[][] cMagico = new int[n][n];
		int[] pos = {
			0, n / 2
		};

		for (int i = 1; i <= n * n; i++) {
			if (cMagico[pos[0]][pos[1]] != 0) {
				pos[0] += 2;
				pos[1]--;

				if (pos[0] >= n) {
					pos[0] -= n;
				}
				if (pos[1] >= n) {
					pos[1] -= n;
				}

				if (pos[0] < 0) {
					pos[0] += n;
				}
				if (pos[1] < 0) {
					pos[1] += n;
				}
			}

			cMagico[pos[0]][pos[1]] = i;

			pos[0]--;
			pos[1]++;

			if (pos[0] >= n) {
				pos[0] -= n;
			}
			if (pos[1] >= n) {
				pos[1] -= n;
			}

			if (pos[0] < 0) {
				pos[0] += n;
			}
			if (pos[1] < 0) {
				pos[1] += n;
			}
		}

		for (int[] arr : cMagico) {
			for (int num : arr) {
				System.out.printf("%d\t", num);
			}
			System.out.printf("\n");
		}
	}
}
