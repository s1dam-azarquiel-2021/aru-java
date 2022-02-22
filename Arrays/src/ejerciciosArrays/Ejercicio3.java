package ejerciciosArrays;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		// Crea una agenda para almacenar nombres y direcciones de N personas.
		// Despues haz un programa que permita ir consultando el nombre y la
		// direccion de las personas almacenadas.

		String[] nombres = {
			"Juanito", "Pepito", "Menganito"
		};
		String[] direcciones = {
			"C/ Vacio", "C/ Llena", "C/ Amedias"
		};

		Scanner input = new Scanner(System.in);
		String nombre;
		do {
			System.out.printf("Introduce un nombre: ");
			nombre = input.nextLine();
			int indice = -1;
			for (int i = 0; i < nombres.length; i++) {
				if (nombre.equals(nombres[i])) {
					indice = i;
					break;
				}
			}
			if (indice == -1) {
				System.out.printf("Ese nombre no exste en el array\n");
			} else {
				System.out.printf("Direccion: %s\n", direcciones[indice]);
			}
		} while (!nombre.equals("0"));
		input.close();
	}
}
