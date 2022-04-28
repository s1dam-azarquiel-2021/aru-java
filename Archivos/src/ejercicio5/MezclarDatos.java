package ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MezclarDatos {
	private ArrayList<Seleccion> selecciones;
	private ArrayList<Demarcacion> demarcaciones;
	private ArrayList<Jugador> jugadores;
	private String ficheroDemarcaciones;
	private String ficheroSelecciones;
	private String ficheroJugadores;
	private String ficheroGuardado;

	public static void main(String[] args) {
		MezclarDatos mezclarDatos = new MezclarDatos();
		mezclarDatos.cargarDemarcaciones();
		mezclarDatos.cargarSelecciones();
		mezclarDatos.cargarJugadores();
		mezclarDatos.guardarDatos();
	}

	public MezclarDatos() {
		this.selecciones = new ArrayList<Seleccion>();
		this.demarcaciones = new ArrayList<Demarcacion>();
		this.jugadores = new ArrayList<Jugador>();
		this.ficheroDemarcaciones = "demarcaciones.txt";
		this.ficheroSelecciones = "selecciones.txt";
		this.ficheroJugadores = "jugadores.txt";
		this.ficheroGuardado = "mezclado.txt";
	}

	public void guardarDatos() {
		BufferedWriter stream = null;
		try {
			stream = new BufferedWriter(new FileWriter(this.ficheroGuardado));
			for (Seleccion seleccion : this.selecciones) {
				stream.write(seleccion.getNombre());
				stream.newLine();
				for (Jugador jugador : this.jugadores) {
					if (jugador.getSeleccion().equals(seleccion)) {
						stream.write(jugador.getNombre());
						stream.write(":");
						stream.write(jugador.getDemarcacion().getNombre());
						stream.newLine();
					}
				}
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

	public Seleccion getSeleccion(String idSeleccion) {
		for (Seleccion seleccion : this.selecciones) {
			if (seleccion.getIdSeleccion().equals(idSeleccion)) {
				return seleccion;
			}
		}

		return null;
	}

	public Demarcacion getDemarcacion(String idDemarcacion) {
		for (Demarcacion demarcacion : this.demarcaciones) {
			if (demarcacion.getIdDemarcacion().equals(idDemarcacion)) {
				return demarcacion;
			}
		}

		return null;
	}

	public void cargarJugadores() {
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(new FileReader(this.ficheroJugadores));
			String linea = stream.readLine();
			while (linea != null) {
				StringTokenizer partes = new StringTokenizer(linea, ":");
				this.jugadores.add(
					new Jugador(
						partes.nextToken(),
						this.getDemarcacion(partes.nextToken()),
						this.getSeleccion(partes.nextToken())
					)
				);
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

	public void cargarSelecciones() {
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(
				new FileReader(this.ficheroSelecciones)
			);
			String linea = stream.readLine();
			while (linea != null) {
				StringTokenizer partes = new StringTokenizer(linea, ":");
				this.selecciones.add(
					new Seleccion(partes.nextToken(), partes.nextToken())
				);
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

	public void cargarDemarcaciones() {
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(
				new FileReader(this.ficheroDemarcaciones)
			);
			String linea = stream.readLine();
			while (linea != null) {
				StringTokenizer partes = new StringTokenizer(linea, ":");
				this.demarcaciones.add(
					new Demarcacion(partes.nextToken(), partes.nextToken())
				);
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
