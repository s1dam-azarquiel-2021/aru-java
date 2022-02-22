package ejerciciosMetodos;

import java.util.Scanner;

public class Ejercicio14 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce una frase: \n");
		String frase = input.nextLine();
		input.close();
		System.out.printf("%s\n", ordenar(frase));
	}

	public static String ordenar(String st) {
		StringBuilder resultado = new StringBuilder(st);
		return ordenar(resultado).toString();
	}

	public static StringBuilder ordenar(StringBuilder st) {
		return ordenar(st, 0);
	}

	public static StringBuilder ordenar(StringBuilder st, int i) {
		if (i == st.length() - 1) {
			return st;
		} else {
			int[] posYLetra = posLetraMenor(st, i);
			st.deleteCharAt(posYLetra[0]);
			st.insert(i, (char) (posYLetra[1]));

			return ordenar(st, i + 1);
		}
	}

	public static int[] posLetraMenor(StringBuilder st, int pos) {
		return posLetraMenor(st, pos, (char) (255), 0);
	}

	public static int[] posLetraMenor(
		StringBuilder st, int pos, char c, int max
	) {
		char letra = st.charAt(pos);
		if (letra < c) {
			c = letra;
			max = pos;
		}

		if (pos == st.length() - 1) {
			int[] resultado = {
				max, c
			};
			return resultado;
		} else {
			return posLetraMenor(st, pos + 1, c, max);
		}
	}
}
