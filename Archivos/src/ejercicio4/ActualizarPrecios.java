package ejercicio4;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import customReaderWriter.CustomObjectInputStream;
import customReaderWriter.CustomObjectOutputStream;

public class ActualizarPrecios {
	private ArrayList<Vehiculo> vehiculos;
	private String ficheroVehiculos;

	public static void main(String[] args) throws ParseException {
		ActualizarPrecios actualizarPrecios = new ActualizarPrecios(
			"vehiculos.exp"
		);
		actualizarPrecios.cargarVehiculos();
		actualizarPrecios.guardarVehiculos();
	}

	public ActualizarPrecios(String ficheroVehiculos) {
		super();
		this.vehiculos = new ArrayList<Vehiculo>();
		this.ficheroVehiculos = ficheroVehiculos;
	}

	public void guardarVehiculos() {
		CustomObjectOutputStream oos = new CustomObjectOutputStream() {
			public void main() throws IOException {
				for (Vehiculo vehiculo : vehiculos) {
					stream.writeObject(vehiculo);
				}
			}
		};

		oos.write(ficheroVehiculos);
	}

	public void cargarVehiculos() {
		CustomObjectInputStream ois = new CustomObjectInputStream() {
			public void main() throws IOException, ClassNotFoundException {
				while (true) {
					Vehiculo vehiculo = (Vehiculo) stream.readObject();
					Date hoy = new Date();

					if (
						(hoy.getTime()
						- vehiculo.getEntradaEnExposicion().getTime())
						/ 86400000 > 5
					) {
						vehiculo.setPrecio(
							(float) (vehiculo.getPrecio() * 0.85)
						);
					}

					vehiculos.add(vehiculo);
				}
			}
		};

		ois.read(this.ficheroVehiculos);
	}
}
