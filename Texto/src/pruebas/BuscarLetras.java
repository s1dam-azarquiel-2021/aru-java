package pruebas;

import java.util.Scanner;

public class BuscarLetras {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String frase = input.nextLine();
		char letra = input.nextLine().charAt(0);
		input.close();

		int i = 0;
		int contador = -1;
		do {
			i = frase.indexOf(letra, i) + 1;
			contador++;
		} while (i > 0);

		System.out.printf("La letra aparece %d veces\n", contador);
	}
}
