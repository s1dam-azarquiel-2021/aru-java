package ejerciciosMetodos;

public class Ejercicio4 {
	public static int factorial(int n) {
		if (n < 0) {
			return -1;
		} else if (n == 0) {
			return -2;
		} else {
			int factorial = 1;
			for (int i = 2; i <= n; i++) {
				factorial *= i;
			}

			return factorial;
		}
	}
}
