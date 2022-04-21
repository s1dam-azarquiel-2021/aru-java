package guardandoContacto;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RecuperarUnObjeto {
	public static void main(String[] args) {
		File archivo = new File("objetos.obj");

		ObjectInputStream stream = null;
		try {
			stream = new ObjectInputStream(new FileInputStream(archivo));

			System.out.printf(
				"Hola, soy %s", ((Contacto) stream.readObject()).getNombre()
			);
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
