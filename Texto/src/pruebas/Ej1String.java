package pruebas;

import java.util.Scanner;

public class Ej1String {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();

		int espacio1 = s.indexOf(' ');
		int espacio2 = s.indexOf(' ', espacio1 + 1);

		if (espacio1 == -1) {
			System.out.printf("No te sabes tu apellido o que\n");
		} else if (espacio2 == -1) {
			System.out.printf("Menudo tio raro solo un apellido\n");
		} else {
			String nombre    = s.substring(0, espacio1);
			String apellido1 = s.substring(espacio1 + 1, espacio2);
			String apellido2 = s.substring(espacio2 + 1, s.length());

			System.out.printf("Tu nombre es: %s\n", nombre);
			System.out.printf("Tu primer apellido es: %s\n", apellido1);
			System.out.printf("Tu segundo apellido es: %s\n", apellido2);
		}
	}
}
