
public class Ejercicio2 {
	public static void main(String[] args) {
		System.out.printf("%s\n", eliminarTrozo("1 Uno 1 uNo 1 unO 1", "uno"));
		System.out.printf(
			"%s\n", eliminarTrozo("La clase de DAM es la mejor", "DAM")
		);
		System.out.printf(
			"%s\n", eliminarTrozo("La clase de DAM es la mejor", "la")
		);
	}

	public static String eliminarTrozo(String frase, String trozo) {
		StringBuilder resultado = new StringBuilder(frase);
		if (trozo.length() > frase.length()) {
			return "";
		}

		for (int i = 0; i < resultado.length() - trozo.length() + 1; i++) {
			if (
				resultado.substring(i, i + trozo.length()).equalsIgnoreCase(
					trozo
				)
			) {
				resultado.delete(i, i + trozo.length());
			}
		}

		return resultado.toString();
	}
}
