package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		System.out.print("Introduco una base y un exponente: ");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(),
			n = input.nextInt();
		input.close();
		
		double total = 1;
		for (int i = 0; i < Math.abs(n); i++) {
			total *= a;
		}
		if (n < 0) { total = 1.0 / total; }
		
		System.out.printf("Solucion: %f", total);
	}
}
