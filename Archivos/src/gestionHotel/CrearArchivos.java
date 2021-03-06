package gestionHotel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CrearArchivos {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(
			new FileOutputStream("habitaciones.obj")
		);

		for (int i = 0; i < 20; i++) {
			int numero = (i / 10 + 1) * 100 + i % 10 + 1;
			oos.writeObject(new Habitacion(numero));
		}

		oos.close();

		oos = new ObjectOutputStream(new FileOutputStream("Clientes.obj"));
		oos.writeObject(new Cliente("374648465J", "Carlos Martinez"));
		oos.writeObject(new Cliente("564647378H", "Sandra Sierra"));
		oos.writeObject(new Cliente("678574849P", "Luis Marcos"));
		oos.writeObject(new Cliente("353536372W", "Olga Sanchez"));
		oos.close();
	}
}
