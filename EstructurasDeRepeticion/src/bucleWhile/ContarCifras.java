package bucleWhile;

import java.util.Scanner;

public class ContarCifras {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce un numero: ");
		int n = input.nextInt();
		input.close();

		int nCifras = 0;
		do {
			n /= 10;
			nCifras++;
		} while (n != 0);

		System.out.printf("Numero de cifras: %d\n", nCifras);
	}
}
