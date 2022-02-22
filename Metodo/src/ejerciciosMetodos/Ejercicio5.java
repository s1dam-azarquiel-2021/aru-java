package ejerciciosMetodos;

public class Ejercicio5 {
	public static int fecha(int d, int m) {
		final int[] diasMeses = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
		};

		int dias = 0;
		for (int i = 1; i < m; i++) {
			dias += diasMeses[i - 1];
		}

		return dias + d;
	}
}
