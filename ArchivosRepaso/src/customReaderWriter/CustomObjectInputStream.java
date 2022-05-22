package customReaderWriter;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class CustomObjectInputStream {
	public ObjectInputStream stream;

	public void read(String file) {
		this.stream = null;
		try {
			this.stream = new ObjectInputStream(
				new FileInputStream(new File(file))
			);
			this.main();
		} catch (EOFException e) {
			this.eofException();
		} catch (ClassNotFoundException e) {
			this.classNotFoundException();
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

	public abstract void main() throws IOException, ClassNotFoundException;

	public void eofException() {
	}

	public void classNotFoundException() {
		System.out.println("El archivo no contiene objetos Vehiculo");
	}

	public void fileNotFoundException() {
		System.out.println("El archivo no existe");
	}

	public void ioException() {
		System.out.println("Error al leer el dato");
	}
}
