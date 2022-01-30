package ejerciciosRepaso;

public class Ejercicio8 {
	public static void invertirMitades(int[] array) {
		int mitad = array.length / 2;
		int comienzoMitad2 = mitad + (array.length % 2 == 1 ? 1 : 0);

		for (int i = 0; i < mitad / 2; i++) {
			intercambiar(array, i, mitad - i - 1);
			intercambiar(array, i + comienzoMitad2, array.length - i - 1);
		}
	}

	public static void intercambiar(int[] array, int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}
}
