package ejerciciosRepaso;

public class Ejercicio1 {
	public static void main(String[] args) {
		int[][] array = new int[3][5];

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 5; j++) {
				array[i - 1][j - 1] = i * 10 + j;
			}
		}

		for (int[] ns : array) {
			for (int n : ns) {
				System.out.printf("%d ", n);
			}
			System.out.printf("\n");
		}
	}
}
