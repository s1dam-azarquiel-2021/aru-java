package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CalcularPeonadas {
	private ArrayList<Trabajador> trabajadores;
	private String ficheroTrabajadores;
	private String ficheroPeonadas;
	private String ficheroTotalPeonadas;

	public static void main(String[] args) {
		CalcularPeonadas calcularPeonadas = new CalcularPeonadas();
		calcularPeonadas.cargarTrabajadores();
		calcularPeonadas.cargarPeonadas();
		calcularPeonadas.guardarPeonadas();
	}

	public CalcularPeonadas() {
		this.trabajadores = new ArrayList<Trabajador>();
		this.ficheroTrabajadores = "Trabajadores.txt";
		this.ficheroPeonadas = "Peonadas.txt";
		this.ficheroTotalPeonadas = "TotalPeonadas.txt";
	}

	public Trabajador getTrabajador(String nombre) {
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador.getNombre().equals(nombre)) {
				return trabajador;
			}
		}
		return null;
	}

	public void guardarPeonadas() {
		BufferedWriter stream = null;
		try {
			stream = new BufferedWriter(
				new FileWriter(this.ficheroTotalPeonadas)
			);
			for (Trabajador trabajador : this.trabajadores) {
				stream.write(trabajador.toString());
				stream.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error escribiendo el texto");
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

	public void cargarPeonadas() {
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new FileReader(this.ficheroPeonadas));
			String linea = stream.readLine();
			while (linea != null) {
				StringTokenizer partes = new StringTokenizer(linea, ":");
				partes.nextToken();
				StringTokenizer trabajadores = new StringTokenizer(
					partes.nextToken(), ","
				);

				while (trabajadores.hasMoreElements()) {
					this.getTrabajador(
						trabajadores.nextToken()
					).aumentarDiasTrabajados();
				}

				linea = stream.readLine();
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException ae) {
			System.out.println("Error al escribir el dato");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void cargarTrabajadores() {
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(
				new FileReader(this.ficheroTrabajadores)
			);
			String linea = stream.readLine();
			while (linea != null) {
				this.trabajadores.add(new Trabajador(linea));
				linea = stream.readLine();
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		} catch (IOException ae) {
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
