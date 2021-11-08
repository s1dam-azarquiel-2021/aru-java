package bucleFor;

import java.util.Scanner;

public class NumeroEsPrimo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un numero: ");
		int n = input.nextInt();
		input.close();
		
		boolean esPrimo = true;
		
		if ((n & 1) == 0 && n != 2 && n != -2) {
			esPrimo = false;
		} else {
			for (int i = 3; i <= Math.sqrt(n); i += 2) {
				if (n % i == 0) {
					esPrimo = false;
					break;
				}
			}
		}
		
		System.out.println(esPrimo ? "Es primo" : "No es primo");
	}

}
