package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		int n,
			mayor = -2147483648;
		System.out.printf("Introduce numeros:\n");
		byte contadorMayor = 0;

		// Coger numeros hasta el 0
		Scanner input = new Scanner(System.in);
		do {
			n = input.nextInt();
			if (n > mayor) {
				// Si es mayor que el mas grande registrado, se cambia el mayor
				// por ese y se reinicia el marcador
				mayor = n;
				contadorMayor = 1;
			} else if (n == mayor) {
				// Si es igual que el mayor se aumenta el contador
				contadorMayor++;
			}
		} while (n != 0);
		input.close();

		System.out.printf(
			"El mayor es el %d, se repite %d veces.\n",
			mayor, contadorMayor
		);
	}
}
