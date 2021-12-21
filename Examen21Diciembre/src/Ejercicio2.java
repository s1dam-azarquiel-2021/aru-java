import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		System.out.printf("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();

		int persistencia = 0;
		while (n > 9) {
			int nCopia = n;
			n = 1;
			persistencia++;

			while (nCopia > 0) {
				n *= nCopia % 10;
				nCopia /= 10;
			}
		}

		System.out.printf("Persistencia multiplicativa: %d\n", persistencia);
	}
}
