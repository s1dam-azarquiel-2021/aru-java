package ejercicio1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class CustomBufferedReader {
	public BufferedReader stream;

	public void read(String file) {
		this.stream = null;
		try {
			this.stream = new BufferedReader(new FileReader(file));
			this.main();
		} catch (EOFException e) {
			this.eofException();
		} catch (FileNotFoundException e) {
			this.fileNotFoundException();
		} catch (IOException e) {
			this.ioException();
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

	public abstract void main() throws IOException;

	public void eofException() {
	}

	public void fileNotFoundException() {
		System.out.println("El archivo no existe");
	}

	public void ioException() {
		System.out.println("Error al leer el dato");
	}
}
