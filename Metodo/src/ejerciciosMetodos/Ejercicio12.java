package ejerciciosMetodos;

public class Ejercicio12 {
	public static int fibonacci(int n) {
		int anterior = 1;
		int resultado = 0;
		for (int i = 1; i < n; i++) {
			int temp = anterior + resultado;
			anterior = resultado;
			resultado = temp;
		}

		return resultado;
	}
}
