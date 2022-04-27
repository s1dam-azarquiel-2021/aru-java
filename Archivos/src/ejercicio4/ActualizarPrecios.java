package ejercicio4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ActualizarPrecios {
	private ArrayList<Vehiculo> vehiculos;
	private String ficheroVehiculos;

	public static void main(String[] args) throws ParseException {
		ActualizarPrecios actualizarPrecios = new ActualizarPrecios();
		actualizarPrecios.cargarVehiculos();
		actualizarPrecios.guardarVehiculos();
	}

	public ActualizarPrecios() {
		this.vehiculos = new ArrayList<Vehiculo>();
		this.ficheroVehiculos = "vehiculos.exp";
	}

	public void guardarVehiculos() {
		File archivo = new File(this.ficheroVehiculos);
		ObjectOutputStream stream = null;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(archivo));
			for (Vehiculo vehiculo : this.vehiculos) {
				stream.writeObject(vehiculo);
			}
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

	public void cargarVehiculos() {
		File archivo = new File(this.ficheroVehiculos);
		ObjectInputStream stream = null;
		try {
			stream = new ObjectInputStream(new FileInputStream(archivo));
			while (true) {
				Vehiculo vehiculo = (Vehiculo) stream.readObject();
				Date hoy = new Date();

				if (
					(hoy.getTime()
					- vehiculo.getEntradaEnExposicion().getTime())
					/ 86400000 > 5
				) {
					vehiculo.setPrecio((float) (vehiculo.getPrecio() * 0.85));
				}

				this.vehiculos.add(vehiculo);
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			System.out.println("Error leyendo el objeto");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("El archivo no contiene objetos Vehiculo");
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				System.out.println("Error cerrando el Stream");
			}
		}
	}
}
