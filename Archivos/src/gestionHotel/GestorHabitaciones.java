package gestionHotel;

import java.io.IOException;
import java.util.ArrayList;

import customReaderWriter.CustomObjectInputStream;
import customReaderWriter.CustomObjectOutputStream;

public class GestorHabitaciones {
	private ArrayList<Habitacion> habitaciones;
	private String archivo;

	public GestorHabitaciones(String archivo) {
		super();
		this.archivo = archivo;
		this.habitaciones = new ArrayList<Habitacion>();
	}

	public void read() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					habitaciones.add((Habitacion) stream.readObject());
				}
			}
		};

		ois.read(this.archivo);
	}

	public void write() {
		CustomObjectOutputStream oos = new CustomObjectOutputStream() {
			public void main() throws IOException {
				for (Habitacion habitacion : habitaciones) {
					stream.writeObject(habitacion);
				}
			}
		};

		oos.write(this.archivo);
	}

	public Habitacion getHabitacion(Integer numero) {
		for (Habitacion habitacion : this.habitaciones) {
			if (habitacion.getNumero() == numero) {
				return habitacion;
			}
		}

		return null;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}
}
