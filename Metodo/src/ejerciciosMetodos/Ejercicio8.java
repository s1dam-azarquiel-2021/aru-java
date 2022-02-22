package ejerciciosMetodos;

public class Ejercicio8 {
	public static String quitaFaltas(String st) {
		String resultado = "";
		boolean puntoEncontrado = false;
		for (int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if (c == '.') {
				puntoEncontrado = true;
			} else if (puntoEncontrado && c >= 'a' && c <= 'z') {
				c -= 'a' - 'A';
				puntoEncontrado = false;
			}
			resultado += c;
		}
		return resultado;
	}
}
