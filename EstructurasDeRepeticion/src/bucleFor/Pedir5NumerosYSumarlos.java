package bucleFor;

import java.util.Scanner;

public class Pedir5NumerosYSumarlos {
	public static void main(String[] args) {
		// Pedir 5 numeros por Input
		Scanner input = new Scanner(System.in);
		int a = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce un numero: ");
			a += input.nextInt();
		}
		input.close();
		
		System.out.println("Resultado: " + a);
	}
}
