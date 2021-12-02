package ejerciciosArrays;

public class Ejercicio2 {
	public static void main(String[] args) {
		// Dado un array de numeros enteros, realiza un programa que diga si
		// esta ordenado o no

		int[] array = { 1, 2, 3, 4, 5 };

		boolean ordMenorMayor = true;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				ordMenorMayor = false;
				break;
			}
		}

		boolean ordMayorMenor = true;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				ordMayorMenor = false;
				break;
			}
		}

		if (ordMayorMenor) {
			System.out.printf("Esta ordenado de mayor a menor\n");
		} else if (ordMenorMayor) {
			System.out.printf("Esta ordenado de menor a mayor\n");
		} else {
			System.out.printf("No esta ordenado\n");
		}
	}
}
