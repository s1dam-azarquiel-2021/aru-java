package pruebas;

import java.util.Scanner;

public class ComprobarCorreo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String correo = input.nextLine();
		input.close();

		final int POS_ARROBA = correo.indexOf("@");
		final int POS_PUNTO  = correo.lastIndexOf(".");

		if (POS_ARROBA == -1) {
			System.out.printf("Error: debe haber un arroba\n");
		} else if (POS_ARROBA < 4) {
			System.out.printf("Error: nombre del usuario demasiado corto\n");
		} else if (!correo.endsWith(".es") && !correo.endsWith(".com")) {
			System.out.printf("Error: nombre de dominio incorrecto\n");
		} else if (POS_PUNTO - POS_ARROBA <= 1) {
			System.out.printf("Error: Nombre de dominia incorrecto\n");
		} else {
			System.out.printf("Correo valido\n");
		}
	}
}
