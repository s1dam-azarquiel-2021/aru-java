package ejerciciosMetodos;

public class Ejercicio7 {
	public static String cifrar(String st) {
		String resultado = "";
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (
				c >= 'a' && c <= 'z' ||
				c >= 'A' && c <= 'Z'
			) {
				switch (c) {
				case 'y': c = 'a'; break;
				case 'Y': c = 'A'; break;
				case 'z': c = 'b'; break;
				case 'Z': c = 'B'; break;
				default: c += 2;
				}
			}
			resultado += c;
		}

		return resultado;
	}

	public static String descifrar(String st) {
		String resultado = "";
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (
				c >= 'a' && c <= 'z' ||
				c >= 'A' && c <= 'Z'
			) {
				switch (c) {
				case 'a': c = 'y'; break;
				case 'A': c = 'Y'; break;
				case 'b': c = 'z'; break;
				case 'B': c = 'Z'; break;
				default: c -= 2;
				}
			}
			resultado += c;
		}

		return resultado;
	}
}
