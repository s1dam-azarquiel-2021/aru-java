package guardandoContacto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardarUnObjeto {
	public static void main(String[] args) {
		File archivo = new File("objetos.obj");

		ObjectOutputStream stream = null;
		Contacto juan = new Contacto("Juan", 67546483);

		try {
			stream = new ObjectOutputStream(new FileOutputStream(archivo));

			stream.writeObject(juan);

			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println("Error al escribir el dato");
		}
	}
}
