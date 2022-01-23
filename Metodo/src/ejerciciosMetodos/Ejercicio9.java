package ejerciciosMetodos;

public class Ejercicio9 {
	public static int inverso(int n) {
		int resultado = 0;
		while (n > 0) {
			resultado *= 10;
			resultado += n % 10;
			n /= 10;
		}

		return resultado;
	}
}
