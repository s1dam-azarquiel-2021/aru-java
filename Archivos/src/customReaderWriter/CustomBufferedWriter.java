package customReaderWriter;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class CustomBufferedWriter {
	public BufferedWriter stream;

	public void write(String file) {
		this.stream = null;
		try {
			this.stream = new BufferedWriter(new FileWriter(file));
			this.streamWrite();
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

	public abstract void streamWrite() throws IOException;

	public void fileNotFoundException() {
		System.out.println("El archivo no existe");
	}

	public void ioException() {
		System.out.println("Error al escribir el dato");
	}
}
