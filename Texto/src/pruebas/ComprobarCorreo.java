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
			System.out.println("Error: debe haber un arroba");
		} else if (POS_ARROBA < 4) {
			System.out.println("Error: nombre del usuario demasiado corto");
		} else if (!correo.endsWith(".es") && !correo.endsWith(".com")) {
			System.out.println("Error: nombre de dominio incorrecto");
		} else if (POS_PUNTO - POS_ARROBA <= 1) {
			System.out.println("Error: Nombre de dominia incorrecto");
		} else {
			System.out.println("Correo valido");
		}
	}
}
