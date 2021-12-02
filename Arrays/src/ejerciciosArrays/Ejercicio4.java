package ejerciciosArrays;

public class Ejercicio4 {
	public static void main(String[] args) {
		// Programa que ordene los indices de un array de enteros.
		// A partir del array original debe generar otro donde aparezcan
		// ordenados los indices de mayor a menor

		int[] array = { 34, 54, 12, 85, 45 };
		int[] arrayOrdenado = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayOrdenado[i] = i;
		}

		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				int temp = array[i - 1];
				array[i - 1] = array[i];
				array[i] = temp;

				int temp2 = arrayOrdenado[i - 1];
				arrayOrdenado[i - 1] = arrayOrdenado[i];
				arrayOrdenado[i] = temp2;

				i = 0;
			}
		}

		System.out.printf("Indices ordenados:\n");
		for (int n : arrayOrdenado) {
			System.out.printf(" %d", n);
		}
		System.out.printf("\n");
	}
}
