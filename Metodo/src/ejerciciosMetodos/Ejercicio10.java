package ejerciciosMetodos;

public class Ejercicio10 {
	public static int mcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}

		return a;
	}
}
