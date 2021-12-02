package ejerciciosArrays;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		// En un array de 20 elementos hay almacenados numeros enteros. Haz un
		// programa que pida un numero y diga cuantas veces aparece el numero
		// dentro del array

		int[] array = {
			1, 2, 5, 8, 8,
			3, 5, 5, 8, 4,
			5, 2, 0, 5, 3,
			4, 9, 7, 4, 3
		};

		System.out.printf("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int numero = input.nextInt();
		input.close();

		int veces = 0;
		for (int n : array) {
			if (n == numero) {
				veces++;
			}
		}

		System.out.printf("El numero aparece %d veces\n", veces);
	}
}
