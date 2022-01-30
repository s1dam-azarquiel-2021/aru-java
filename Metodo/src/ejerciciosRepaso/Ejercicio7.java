package ejerciciosRepaso;

public class Ejercicio7 {
	public static void invertirDiagonalPrincipal(int[][] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int[] pos1 = { i, i };
			int contraria = array.length - i - 1;
			int[] pos2 = { contraria, contraria };
			intercambiar2D(array, pos1, pos2);
		}
	}

	public static void intercambiar2D(int[][] array, int[] pos1, int[] pos2) {
		int temp = array[pos1[0]][pos1[1]];
		array[pos1[0]][pos1[1]] = array[pos2[0]][pos2[1]];
		array[pos2[0]][pos2[1]] = temp;
	}
}
