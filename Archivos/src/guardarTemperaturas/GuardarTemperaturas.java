package guardarTemperaturas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GuardarTemperaturas {
	public static void main(String[] args) {
		File archivo = new File("temperaturas.txt");

		DataOutputStream stream = null;
		try {
			stream = new DataOutputStream(new FileOutputStream(archivo));

			for (int i = 0; i < 30; i++) {
				stream.writeFloat(
					(float) Math.round((Math.random() * 60 - 20) * 100) / 100
				);
			}

			stream.close();
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
