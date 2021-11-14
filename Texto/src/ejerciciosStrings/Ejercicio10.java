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

		// Pedimos la palabra
		System.out.printf("Introduce una palabra: ");
		StringBuilder palabra = new StringBuilder(input.nextLine());

		// Ya que lo necesito mas de una vez lo meto en una constante
		final int L_PALABRA = palabra.length();

		boolean acertado = false;
		int nIntentos = 0;
		char letraActual;

		// La palabra con los aciertos, al principio solo sera un ____
		StringBuilder letrasAcertadas = new StringBuilder(
			"_".repeat(L_PALABRA)
		);

		while (!acertado && nIntentos < 8) {
			// Mostramos las letras acertadas
			System.out.printf(
				"\nLetras acertadas: %s\n",
				letrasAcertadas
			);

			// Pedimos una letra
			System.out.printf("Introduce una letra: ");
			letraActual = input.nextLine().charAt(0);

			// Buscamos en la palabra original si esa letra estaba,
			// si estaba ponemos las letras en letrasAcertadas
			// y decimos que acerto la letra
			boolean acertoLetra = false;
			for (int i = 0; i < L_PALABRA; i++) {
				if (palabra.charAt(i) == letraActual) {
					letrasAcertadas.setCharAt(i, letraActual);
					acertoLetra = true;
				}
			}

			// Le decimos si acerto o no
			if (acertoLetra) {
				System.out.printf("Acertaste!\n");
			} else {
				System.out.printf("Pero que malo eres\n");
			}

			// Comprobamos si hay _ en los aciertos, si no hay la palabra ya
			// esta acertada
			acertado = letrasAcertadas.indexOf("_") == -1;

			// Sumamos un intento
			nIntentos++;

			System.out.printf(
				"Intentos restantes: %d\n",
				8 - nIntentos
			);
		}
		input.close();

		if (acertado) {
			System.out.printf("\nAcertaste la palabra, enhorabuena\n");
		} else {
			System.out.printf(
				"\nEres malisimo, la palabra era: %s\n",
				palabra
			);
		}
	}
}
