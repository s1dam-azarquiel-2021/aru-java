package pruebas;

public class Suma {
	public static void main(String[] args) {
		System.out.printf("Suma de 5 y 6: %d\n", suma(5, 6));
	}

	public static int suma(int... ns) {
		int suma = 0;
		for (int n : ns) {
			suma += n;
		}

		return suma;
	}

	public static double suma(double... ns) {
		int suma = 0;
		for (double n : ns) {
			suma += n;
		}

		return suma;
	}
}
