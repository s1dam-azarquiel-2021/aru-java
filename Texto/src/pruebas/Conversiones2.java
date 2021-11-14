package pruebas;

import java.util.Scanner;

public class Conversiones2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double numero = input.nextDouble();
		input.close();

		String texto = String.valueOf(numero);

		final int POS_PUNTO = texto.indexOf('.');
		String trozo1 = texto.substring(0, POS_PUNTO);
		String trozo2 = texto.substring(POS_PUNTO + 1);

		int t1 = Integer.parseInt(trozo1);
		int t2 = Integer.parseInt(trozo2);

		System.out.printf("La suma es: %d\n", t1 + t2);
	}
}
