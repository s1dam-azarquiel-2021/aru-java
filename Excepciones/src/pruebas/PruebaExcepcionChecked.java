package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaExcepcionChecked {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(
			new InputStreamReader(System.in)
		);

		System.out.print("Mete un numero: ");
		try {
			int numero = Integer.parseInt(input.readLine());
		} catch (NumberFormatException e) {
			System.out.println("El dato no es correcto");
		} catch (IOException e) {
			System.out.println("Error general de E/S");
		}

		try {
			int numero2 = Integer.parseInt(input.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error de lectura de teclado");
		}
	}
}
