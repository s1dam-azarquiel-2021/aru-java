package pruebas;

public class Media {
	public static void main(String[] args) {
		System.out.printf("Media de 1 9 6: %f\n", media(1, 9, 6));
	}

	public static double media(int... ns) {
		double suma = 0;
		for (int n : ns) {
			suma += n;
		}

		return suma / ns.length;
	}

	public static double media(double... ns) {
		double suma = 0;
		for (double n : ns) {
			suma += n;
		}

		return suma / ns.length;
	}
}
