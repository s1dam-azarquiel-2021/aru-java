package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaConMetodo {
	public static void main(String[] args) throws NumberFormatException,
		IOException {
		int valor = leerDato();
		System.out.printf("El dato es: %d", valor);
	}

	public static int leerDato() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(
			new InputStreamReader(System.in)
		);

		System.out.print("Mete un numero: ");
		int numero = Integer.parseInt(input.readLine());

		return numero;
	}
}
