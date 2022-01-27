package ejerciciosMetodos;

import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce una frase: \n");
		String frase = input.nextLine();
		input.close();
		System.out.printf("%s\n", ordenar(frase));
	}

	public static String ordenar(String st) {
		StringBuilder resultado = new StringBuilder(st);
		for (int i = 0; i < resultado.length(); i++) {
			int[] posYLetra = posLetraMenor(resultado, i);
			resultado.deleteCharAt(posYLetra[0]);
			resultado.insert(i, (char) (posYLetra[1]));
		}

		return resultado.toString();
	}

	public static int[] posLetraMenor(StringBuilder st, int pos) {
		int[] resultado = {0, 255};
		for (int i = pos; i < st.length(); i++) {
			char letra = st.charAt(i);
			if (letra < resultado[1]) {
				resultado[1] = letra;
				resultado[0] = i;
			}
		}

		return resultado;
	}
}
