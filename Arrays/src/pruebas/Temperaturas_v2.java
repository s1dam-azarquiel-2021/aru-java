package pruebas;

import java.util.Scanner;

public class Temperaturas_v2 {
	public static void main(String[] args) {
		double[] temps = new double[7];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < temps.length; i++) {
			System.out.printf("Introduce una temperatura: ");
			temps[i] = input.nextDouble();
		}
		input.close();

		double media = 0;
		for (double d : temps) {
			media += d;
		}
		media /= temps.length;

		System.out.printf("Temperatura media: %.2f\n", media);
	}
}
