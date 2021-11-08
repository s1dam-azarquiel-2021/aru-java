package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		System.out.println("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		int i = 2;
		while (n > 1) {
			if (n % i == 0) {
				System.out.printf(" %d", i);
				n /= i;
			} else if (i == 2) {
				i = 3;
			} else {
				i += 2;
			}
		}
	}
}
