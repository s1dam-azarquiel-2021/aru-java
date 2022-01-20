package pruebas;

import java.util.StringTokenizer;

public class Palabras {
	public static void main(String[] args) {
		System.out.printf("%d\n", contarVocales("hay 4 vocales"));
		System.out.printf("%s\n", ultimaPalabra("hay 3 palabras"));
	}

	public static int contarVocales(String st) {
		int vocales = 0;
		for (int i = 0; i < st.length(); i++) {
			if ("aoeuiAOEUI".indexOf(st.charAt(i)) >= 0) {
				vocales++;
			};
		}

		return vocales;
	}

	public static String ultimaPalabra(String st) {
		StringTokenizer palabras = new StringTokenizer(st);
		while (palabras.countTokens() > 1) {
			palabras.nextToken();
		}

		return palabras.nextToken();
	}
}
