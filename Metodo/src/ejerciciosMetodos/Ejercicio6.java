package ejerciciosMetodos;

public class Ejercicio6 {
	public static String repite(String st, int n) {
		String resultado = st;
		for (int i = 1; i < n; i++) {
			resultado += st;
		}

		return resultado;
	}
}
