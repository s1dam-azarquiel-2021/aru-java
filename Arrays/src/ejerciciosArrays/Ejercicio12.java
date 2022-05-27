package ejerciciosArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		// Programa que lea numeros enteros hasta que se escriba el -1.
		// Los numeros deben ir quedando almacenados en un array. Como no
		// sabemos los numeros que van a teclear el array debe ir cambiando
		// de size para irse adaptando al numero de datos leido.

		ArrayList<Integer> numeros = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		do {
			numeros.add(input.nextInt());
		} while (numeros.get(numeros.size() - 1) != 0);
		input.close();
		numeros.remove(numeros.size() - 1);

		for (int n : numeros) {
			System.out.printf("%d\n", n);
		}
	}
}
