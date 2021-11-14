package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) {
		System.out.printf("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();

		String binario = "";
		while (n > 1) {
			binario = n % 2 + binario;
			n /= 2;
		}
		if (n == 0) {
			binario = "0";
		} else {
			binario = "1" + binario;
		}

		System.out.printf("En binario: %s\n", binario);
	}
}
