package bucleWhile;

import java.util.Scanner;

public class NumeroSecretoConAyuda {
	public static void main(String[] args) {
		// Generamos un numero aleatorio
		final int nSecreto = (int) (Math.random() * 100 + 1);

		Scanner input = new Scanner(System.in);
		int nIntroducido;
		int intentos = 0;
		boolean ganador = false;
		do {
			// Pedimos un numero por input y incrementamos el intento
			System.out.printf("Prueba suerte: ");
			nIntroducido = input.nextInt();
			intentos++;
			// Si el numero introducido es  mayor o menor que el secreto
			// Ayudar al usuario diciendoselo
			if (nIntroducido > nSecreto) {
				System.out.printf("Te pasas prro\n");
			} else if (nIntroducido < nSecreto) {
				System.out.printf("Te quedas corto\n");
			} else {
				ganador = true;
			}
			// Mientras que no acertemos o nos queden intentos
		} while (!ganador && intentos < 8);
		input.close();

		if (ganador) {
			System.out.printf("Ganador!\n");
		} else {
			System.out.printf(
				"\nPero que malo eres!\nEl numero era: %d\n",
				nSecreto
			);
		}
	}
}
