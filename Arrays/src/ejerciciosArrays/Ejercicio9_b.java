package ejerciciosArrays;

import java.util.ArrayList;

public class Ejercicio9_b {
	public static void main(String[] args) {
		// Programa que mezcla dos arrays ordenados de N elementos, consiguiendo
		// un array de n*2 elementos igualmente ordenados.

		int[] arrA = {
			4, 8, 15, 22, 25, 40
		};
		int[] arrB = {
			3, 6, 18, 21, 25, 47
		};

		ArrayList<Integer> arrFinal = new ArrayList<>(
			arrA.length + arrB.length
		);

		for (int n : arrA) {
			arrFinal.add(n);
		}

		for (int n : arrB) {
			int pos = -1;
			for (int i = 0; i < arrFinal.size(); i++) {
				if (arrFinal.get(i) > n) {
					pos = i;
					break;
				}
			}

			if (pos == -1) {
				arrFinal.add(n);
			} else {
				arrFinal.add(pos, n);
			}
		}

		System.out.printf("Array final:\n");
		for (int n : arrFinal) {
			System.out.printf("%d ", n);
		}
	}
}
