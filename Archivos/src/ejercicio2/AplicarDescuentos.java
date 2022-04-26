package ejercicio2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AplicarDescuentos {
	public static void main(String[] args) {
		ArrayList<Planta> plantas = cargarPlantasYAplicarDescuento();
		guardarPlantas(plantas);
	}

	public static Planta aplicarDescuento(Planta planta) {
		if (planta.getCantidad() < 10) {
			planta.setPrecio(planta.getPrecio() * 0.8);
		} else if (planta.getCantidad() < 50) {
			planta.setPrecio(planta.getPrecio() * 0.7);
		} else if (planta.getCantidad() > 50) {
			planta.setPrecio(planta.getPrecio() * 0.6);
		}

		return planta;
	}

	public static ArrayList<Planta> cargarPlantasYAplicarDescuento() {
		ArrayList<Planta> plantas = new ArrayList<Planta>();
		File file = new File("Plantas.venta");
		ObjectInputStream stream = null;
		try {
			stream = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				plantas.add(aplicarDescuento((Planta) stream.readObject()));
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException ae) {
			System.out.println("Error al escribir el dato");
		} catch (ClassNotFoundException e) {
			System.out.println("El archivo no contiene objetos planta");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return plantas;
	}

	public static void guardarPlantas(ArrayList<Planta> plantas) {
		File archivo = new File("Plantas.venta");

		ObjectOutputStream stream = null;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(archivo));
			for (Planta planta : plantas) {
				stream.writeObject(planta);
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
}
