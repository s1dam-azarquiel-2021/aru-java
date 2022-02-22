package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		boolean nRepetido = false;

		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce numeros: ");
		int n = input.nextInt();

		while (n >= 0) {
			int nAnterior = n;
			n = input.nextInt();

			if (n == nAnterior) {
				nRepetido = true;
			}
		}
		input.close();

		if (nRepetido) {
			System.out.printf("Has puesto dos repetidos consecutivos\n");
		} else {
			System.out.printf("No has puesto dos repetidos consecutivos\n");
		}
	}
}
