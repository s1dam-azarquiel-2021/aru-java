package pruebas;

import java.util.StringTokenizer;

public class PruebaStringTokenizer {
	public static void main(String[] args) {
		String frase = "Buenos dias. A todos.";
		StringTokenizer st = new StringTokenizer(frase, " ,.");
		System.out.printf("%d\n", st.countTokens());
	}
}
