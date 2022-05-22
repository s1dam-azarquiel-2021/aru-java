package customReaderWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public abstract class CustomObjectOutputStream {
	public ObjectOutputStream stream;

	public void write(String file) {
		this.stream = null;
		try {
			this.stream = new ObjectOutputStream(
				new FileOutputStream(new File(file))
			);
			this.main();
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

	public void fileNotFoundException() {
		System.out.println("El archivo no existe");
	}

	public void ioException() {
		System.out.println("Error al leer el dato");
	}
}
