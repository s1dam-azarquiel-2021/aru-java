package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		// Programa que simule el juego del ahorcado.
		// Elegimos una palabra y vamos pidiendo letras al usuario.
		// Cada vez mostramos la palabras solo con las letras acertadas.
		// Si no acierta todas las letras en 8 intentos,
		// se da el juego por perdido

		Scanner input = new Scanner(System.in);
		System.out.print("Introduce una palabra: ");
		StringBuilder palabra = new StringBuilder(input.nextLine());

		final int L_PALABRA = palabra.length();

		boolean acertado = false;
		int nIntentos = 0;
		StringBuilder letrasAcertadas = new StringBuilder("_".repeat(L_PALABRA));
		char letraActual;

		while (!acertado && nIntentos < 8) {
			System.out.printf(
				"\nLetras acertadas: %s\n",
				letrasAcertadas
			);
			System.out.print("Introduce una letra: ");
			letraActual = input.nextLine().charAt(0);

			boolean acertoLetra = false;
			for (int i = 0; i < L_PALABRA; i++) {
				if (palabra.charAt(i) == letraActual) {
					letrasAcertadas.setCharAt(i, letraActual);
					acertoLetra = true;
				}
			}

			if (acertoLetra) {
				System.out.println("Acertaste!");
			} else {
				System.out.println("Pero que malo eres");
			}

			acertado = letrasAcertadas.indexOf("_") == -1;
			nIntentos++;

			System.out.printf(
				"Intentos restantes: %d\n",
				8 - nIntentos
			);
		}
		input.close();

		if (acertado) {
			System.out.println("Acertaste la palabra, enhorabuena");
		} else {
			System.out.printf(
				"Eres malisimo, la palabra era:	%s",
				palabra
			);
		}
	}
}
