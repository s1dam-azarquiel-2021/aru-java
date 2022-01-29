package ejerciciosRepaso;

public class Ejercicio3 {
	public static int[] insertar(int[] array, int elem, int pos) {
		int length = array.length;
		boolean move = true;
		if (pos >= array.length) {
			length = pos + 1;
			move = false;
		}

		int[] temp = array;
		array = new int[length];
		for (int i = 0; i < temp.length; i++) {
			if (move && i >= pos) {
				if (i < temp.length - 1) {
					array[i + 1] = temp[i];
				}
			} else {
				array[i] = temp[i];
			}
		}

		array[pos] = elem;

		return array;
	}
}
