package ejerciciosRepaso;

public class Ejercicio2 {
	public static int[] insertar(int[] array, int elem, int pos) {
		int length = array.length + 1;
		boolean move = true;
		if (pos >= array.length) {
			length = pos + 1;
			move = false;
		}

		int[] temp = array;
		array = new int[length];
		for (int i = 0; i < temp.length; i++) {
			if (move && i >= pos) {
				array[i + 1] = temp[i];
			} else {
				array[i] = temp[i];
			}
		}

		array[pos] = elem;

		return array;
	}
}
