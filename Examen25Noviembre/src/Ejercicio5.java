import java.util.Scanner;
import java.util.StringTokenizer;

public class Ejercicio5 {
	public static void main(String[] args) {
		StringBuilder resultado = new StringBuilder("");

		System.out.printf("Teclea una frase: ");
		Scanner input = new Scanner(System.in);
		StringTokenizer frase = new StringTokenizer(input.nextLine());
		input.close();

		while (frase.hasMoreTokens()) {
			String palabra = frase.nextToken();
			StringBuilder vocales = new StringBuilder("");

			for (int i = 0; i < palabra.length(); i++) {
				// Si encuentra una vocal mira si ya esta en el string vocales y
				// si no la anade
				switch (palabra.charAt(i)) {
				case 'a', 'A':
					if (vocales.indexOf("a") == -1) {
						vocales.append('a');
					}
					break;
				case 'e', 'E':
					if (vocales.indexOf("e") == -1) {
						vocales.append('e');
					}
					break;
				case 'i', 'I':
					if (vocales.indexOf("i") == -1) {
						vocales.append('i');
					}
					break;
				case 'o', 'O':
					if (vocales.indexOf("o") == -1) {
						vocales.append('o');
					}
					break;
				case 'u', 'U':
					if (vocales.indexOf("u") == -1) {
						vocales.append('u');
					}
					break;
				}
			}

			// Si esa palabra tenia mas de 2 vocales diferentes se anade
			// al resultado
			if (vocales.length() >= 3) {
				resultado.append(palabra + " ");
			}
		}

		System.out.printf("Resultado: %s\n", resultado);
	}
}
