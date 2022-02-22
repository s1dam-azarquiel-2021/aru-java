package ejerciciosArrays;

public class Ejercicio9 {
	public static void main(String[] args) {
		// Programa que mezcla dos arrays ordenados de N elementos, consiguiendo
		// un array de n*2 elementos igualmente ordenados.

		int[] arrA = {
			4, 8, 15, 22, 25, 40
		};
		int[] arrB = {
			3, 6, 18, 21, 25, 47
		};

		int[] arrFinal = new int[arrA.length + arrB.length];

		int iA = 0;
		int iB = 0;
		int iF = 0;
		for (; iF < arrFinal.length; iF++) {
			if (iA == arrA.length) {
				arrFinal[iF] = arrB[iB];
				iB++;
			} else if (iB == arrB.length) {
				arrFinal[iF] = arrA[iA];
				iA++;
			} else if (arrA[iA] < arrB[iB]) {
				arrFinal[iF] = arrA[iA];
				iA++;
			} else if (arrB[iB] < arrA[iA]) {
				arrFinal[iF] = arrB[iB];
				iB++;
			} else {
				arrFinal[iF] = arrA[iA];
				iF++;
				arrFinal[iF] = arrA[iB];
				iA++;
				iB++;
			}
		}

		System.out.printf("Array final:\n");
		for (int n : arrFinal) {
			System.out.printf("%d ", n);
		}
	}
}
