package pruebas;

import java.util.Scanner;

public class PruebaDivision {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Teclea el dividendo: ");
		int a;
		try {
			a = input.nextInt();
		} catch (Exception e) {
			System.out.println("Eso no es un numero");
			a = 1;

		}

		System.out.print("Teclea el divisor: ");
		int b;
		try {
			b = input.nextInt();
		} catch (Exception e) {
			System.out.println("Eso no es un numero");
			b = 1;

		}
		input.close();

		try {
			System.out.printf("La division es: %d\n", a / b);
		} catch (Exception e) {
			System.out.println("No se puede dividir por cero");

		}
	}
}
