package simpleYDoble;

import java.util.Scanner;

public class Ordenar2Numeros {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce 2 numeros: ");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		scanner.close();

		if (x > y) { System.out.printf("%d %d\n", x, y); }
		else       { System.out.printf("%d %d\n", y , x); }
	}
}
