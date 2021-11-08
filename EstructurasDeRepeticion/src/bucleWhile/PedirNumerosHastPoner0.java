package bucleWhile;

import java.util.Scanner;

public class PedirNumerosHastPoner0 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = -1;
		while (n != 0) {
			System.out.print("Introduce un numero: ");
			n = input.nextInt();
		}
		input.close();
		
		Scanner input2 = new Scanner(System.in);
		int n2;
		do {
			System.out.print("Introduce un numero: ");
			n2 = input2.nextInt();
		} while (n2 != 0);
		input2.close();
	}
}
