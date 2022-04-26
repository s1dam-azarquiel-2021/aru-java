package streamsDeTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecuperarTexto {
	public static void main(String[] args) {
		File archivo = new File("texto.txt");

		BufferedReader stream = null;

		try {
			stream = new BufferedReader(new FileReader(archivo));
			String linea = stream.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = stream.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error leyendo el texto");
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
