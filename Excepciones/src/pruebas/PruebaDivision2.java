package pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaDivision2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			System.out.print("Teclea el dividendo: ");
			int a = input.nextInt();

			System.out.print("Teclea el divisor: ");
			int b = input.nextInt();

			System.out.printf("La division es: %d\n", a / b);
		} catch (InputMismatchException e) {
			System.out.println("Eso no es numero");
		} catch (ArithmeticException e) {
			System.out.println("No se puede dividir por cero");
		} catch (Exception e) {
			System.out.println("No se que has hecho, pero no va muy bien.");
		} finally {
			input.close();
		}
	}
}
