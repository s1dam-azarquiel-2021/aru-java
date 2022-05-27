package ejerciciosRepaso;

public class Ejercicio5 {
	public static int[] ordenarExtravagante(int[] array) {
		int[] ordenada = array.clone();
		ordenar(ordenada);

		int[] resultado = new int[ordenada.length];
		int posPar = 0;
		int posImpar = resultado.length - 1;
		for (int element : ordenada) {
			if (element % 2 == 0) {
				resultado[posPar] = element;
				posPar++;
			} else {
				resultado[posImpar] = element;
				posImpar--;
			}
		}

		return resultado;
	}

	public static void ordenar(int[] array) {
		for (int i = 0; i < array.length; i++) {
			intercambiar(array, i, posMenor(array, i));
		}
	}

	public static void intercambiar(int[] array, int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	public static int posMenor(int[] array, int pos) {
		for (int i = pos; i < array.length; i++) {
			if (array[i] < array[pos]) {
				pos = i;
			}
		}

		return pos;
	}
}
