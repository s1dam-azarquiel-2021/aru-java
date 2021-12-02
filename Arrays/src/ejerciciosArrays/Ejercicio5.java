package ejerciciosArrays;

public class Ejercicio5 {
	public static void main(String[] args) {
		// Dado un array de 50 numeros entre 1 y 100. Escribir una lista
		// ordenada con los valores que no aparecen en el array.

		int[] array = new int[50];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}

		int[] numeros = new int[100];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i;
		}

		for (int i = 0; i < array.length; i++) {
			numeros[array[i]] = -1;
		}

		System.out.printf("Numeros que no aparecen:\n");
		for (int n : numeros) {
			if (n != -1) {
				System.out.printf("%d\n", n);
			}
		}
	}
}
