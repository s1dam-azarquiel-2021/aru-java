package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Cuenta {
	public static void main(String[] args) {
		System.out.println(
			"Palabras: " + cuentaPalabras(new File("quijote.txt"))
		);
	}

	public static int cuentaPalabras(File file) {
		int lineas = 0;

		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new FileReader(file));
			String linea = stream.readLine();
			while (linea != null) {
				StringTokenizer palabras = new StringTokenizer(linea);
				lineas += palabras.countTokens();
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

		return lineas;
	}
}
