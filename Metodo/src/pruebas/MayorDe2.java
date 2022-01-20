package pruebas;

public class MayorDe2 {
	public static void main(String[] args) {
		System.out.printf("Mayor de 2 y 3: %d\n", mayor(2, 3));
		System.out.printf("Mayor: %d\n", mayor(1, 2, 5, 7, 1, 82, 6969, 54));
	}

	public static int mayor(int... ns) {
		int mayor = Integer.MIN_VALUE;
		for (int n : ns) {
			if (n > mayor) {
				mayor = n;
			}
		}

		return mayor;
	}
}
