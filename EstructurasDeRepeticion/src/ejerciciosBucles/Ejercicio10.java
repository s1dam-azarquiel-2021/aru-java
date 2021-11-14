package ejerciciosBucles;

public class Ejercicio10 {
	public static void main(String[] args) {
		final int[] cubos = {
			0,
			1 * 1 * 1,
			2 * 2 * 2,
			3 * 3 * 3,
			4 * 4 * 4,
			5 * 5 * 5,
			6 * 6 * 6,
			7 * 7 * 7,
			8 * 8 * 8,
			9 * 9 * 9
		};

		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					int sumaCubos = cubos[i] + cubos[j] + cubos[k];
					if (sumaCubos == i * 100 + j * 10 + k) {
						System.out.printf("%d\n", sumaCubos);
					}
				}
			}
		}
	}
}
