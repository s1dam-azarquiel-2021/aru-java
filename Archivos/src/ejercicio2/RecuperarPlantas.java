package ejercicio2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RecuperarPlantas {
	public static void main(String[] args) {
		File archivo = new File("Plantas.venta");

		ObjectInputStream stream = null;
		try {
			stream = new ObjectInputStream(new FileInputStream(archivo));
			while (true) {
				System.out.println((Planta) stream.readObject());
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException ae) {
			System.out.println("Error al escribir el dato");
		} catch (ClassNotFoundException e) {
			System.out.println("El archivo no contiene objetos contacto");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
