package simpleYDoble;

import java.util.Scanner;

public class MayorDe2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce dos numeros:" );
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.close();

		if (x > y) {
			System.out.printf("El mayor es %d\n", x);
		} else if (y > x) {
			System.out.printf("El mayor es %d\n", y);
		} else {
			System.out.printf("Son iguales\n");
		}
	}
}
