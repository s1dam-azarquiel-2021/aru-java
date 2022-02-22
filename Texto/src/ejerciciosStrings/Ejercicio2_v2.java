package ejerciciosStrings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio2_v2 {
	public static void main(String[] args) {
		// Programa que reciba una cadena y diga cuantas palabras contiene
		// Las palabras pueden estar separadas por espacios, puntos o comas

		System.out.print("Escribe una frase: ");
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine();
		input.close();

		StringTokenizer st = new StringTokenizer(frase, " ,.");
		int palabras = st.countTokens();

		System.out.printf(
			"La frase tiene: %d palabra%c", palabras, palabras == 1 ? ' ' : 's'
		);
	}
}
