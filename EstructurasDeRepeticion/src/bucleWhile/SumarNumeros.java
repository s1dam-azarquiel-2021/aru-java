package bucleWhile;

import java.util.Scanner;

public class SumarNumeros {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n,
			suma = 0;
		do {
			System.out.print("Introduce un numero: ");
			n = input.nextInt();
			suma += n;
		} while (n != 0);
		input.close();
		
		System.out.println("Suma total: " + suma);
	}
}
