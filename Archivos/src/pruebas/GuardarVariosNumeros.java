package pruebas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GuardarVariosNumeros {
	public static void main(String[] args) {
		File archivo = new File("variosEntero.int");

		try {
			DataOutputStream stream = new DataOutputStream(
				new FileOutputStream(archivo)
			);

			for (int i = 0; i < 10; i++) {
				stream.writeInt(i);
			}

			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println("Error al escribir el dato");
		}
	}
}
