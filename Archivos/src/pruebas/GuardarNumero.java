package pruebas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GuardarNumero {
	public static void main(String[] args) {
		int numero = 742;
		File archivo = new File("datoEntero.int");

		try {
			DataOutputStream stream = new DataOutputStream(
				new FileOutputStream(archivo)
			);
			stream.writeInt(numero);
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException e) {
			System.out.println("Error al escribir el dato");
		}
	}
}
