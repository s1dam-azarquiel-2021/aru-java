package ejerciciosRepaso;

public class Ejercicio4 {
	public static int[] secuencia(int[] array) {
		int[] resultado = {
			0, 0
		};
		int[] actual = {
			-1, 1
		};
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				if (actual[0] == -1) {
					actual[0] = i - 1;
				}
				actual[1]++;
			} else {
				if (actual[1] > resultado[1]) {
					resultado[0] = actual[0];
					resultado[1] = actual[1];
				}
				actual[0] = -1;
				actual[1] = 1;
			}
		}

		if (actual[1] > resultado[1]) {
			resultado[0] = actual[0];
			resultado[1] = actual[1];
		}

		return resultado;
	}
}
