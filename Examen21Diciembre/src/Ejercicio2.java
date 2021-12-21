import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		System.out.printf("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();

		while (n > 9) {
			int nCopia = n;
			n = 1;

			for (int i; nCopia > 0; nCopia /= 10) {
				i = nCopia % 10;
				n *= i;
			}
		}

		System.out.printf("Persistencia multiplicativa: %d\n", n);
	}
}
