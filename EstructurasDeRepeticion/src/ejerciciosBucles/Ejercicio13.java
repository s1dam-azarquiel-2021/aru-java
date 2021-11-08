package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		System.out.print("Introduce dos numeros: ");
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt(),
			n2 = input.nextInt();
		input.close();
		
		int mcm = 1,
			i = 2;
		while (n1 > 1 || n2 > 1) {
			boolean esFactorDeN1 = n1 % i == 0;
			boolean esFactorDeN2 = n2 % i == 0;

			if (esFactorDeN1 || esFactorDeN2) {
				if (esFactorDeN1) {
					n1 /= i;
				}
				if (esFactorDeN2) {
					n2 /= i;
				}
				mcm *= i;
			} else if (i == 2) {
				i = 3;
			} else {
				i += 2;
			}
		}
		
		System.out.printf("MCM: %d", mcm);
	}
}
