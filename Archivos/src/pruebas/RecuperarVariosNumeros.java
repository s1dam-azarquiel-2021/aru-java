package pruebas;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecuperarVariosNumeros {
	public static void main(String[] args) {
		File archivo = new File("variosEntero.int");

		DataInputStream stream = null;
		try {
			stream = new DataInputStream(new FileInputStream(archivo));

			while (true) {
				System.out.println(stream.readInt());
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println("Error al escribir el dato");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
