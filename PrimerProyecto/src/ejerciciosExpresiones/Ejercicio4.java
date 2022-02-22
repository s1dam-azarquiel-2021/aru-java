package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce tu peso: ");
		float pesoEnLaTierra = scanner.nextFloat();
		scanner.close();

		final float gTierra = 9.8F;
		final float gLuna = 1.62F;
		float pesoEnLaLuna = pesoEnLaTierra / gTierra * gLuna;
		System.out.printf("Peso en la luna: %d\n", pesoEnLaLuna);
	}
}
