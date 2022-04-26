package streamsDeTexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarTexto {
	public static void main(String[] args) {
		File archivo = new File("texto.txt");

		BufferedWriter stream = null;

		try {
			stream = new BufferedWriter(new FileWriter(archivo));
			stream.write("Hola");
			stream.newLine();
			stream.write("¿Qué tal?");
		} catch (IOException e) {
			System.out.println("Error escribiendo el texto");
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					System.out.println("Error cerrando stream");
				}
			}
		}
	}
}
