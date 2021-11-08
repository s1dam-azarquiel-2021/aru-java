package pruebas;

import java.util.Scanner;

public class Ej1String {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		
		int espacio1 = s.indexOf(' '),
			espacio2 = s.indexOf(' ', espacio1 + 1);
		
		if (espacio1 == -1) {
			System.out.println("No te sabes tu apellido o que");
		} else if (espacio2 == -1) {
			System.out.println("Menudo tio raro solo un apellido");
		} else {
			String nombre    = s.substring(0, espacio1),
				   apellido1 = s.substring(espacio1 + 1, espacio2),
				   apellido2 = s.substring(espacio2 + 1, s.length());

			System.out.println("Tu nombre es: " + nombre);
			System.out.println("Tu primer apellido es: " + apellido1);
			System.out.println("Tu segundo apellido es: " + apellido2);
		}
	}
}
