package pruebas;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecuperarUnNumero {
	public static void main(String[] args) {
		File archivo = new File("datoEntero.int");

		try {
			DataInputStream stream = new DataInputStream(
				new FileInputStream(archivo)
			);
			System.out.println("Dato recuperado: " + stream.read());
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println("Error al escribir el dato");
		}
	}
}
