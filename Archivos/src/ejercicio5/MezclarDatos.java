package ejercicio5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import customReaderWriter.CustomBufferedReader;
import customReaderWriter.CustomBufferedWriter;

public class MezclarDatos {
	private ArrayList<Seleccion> selecciones;
	private ArrayList<Demarcacion> demarcaciones;
	private ArrayList<Jugador> jugadores;
	private String ficheroDemarcaciones;
	private String ficheroSelecciones;
	private String ficheroJugadores;
	private String ficheroGuardado;

	public static void main(String[] args) {
		MezclarDatos mezclarDatos = new MezclarDatos(
			"demarcaciones.txt",
			"selecciones.txt",
			"jugadores.txt",
			"mezclado.txt"
		);
		mezclarDatos.cargarDemarcaciones();
		mezclarDatos.cargarSelecciones();
		mezclarDatos.cargarJugadores();
		mezclarDatos.guardarDatos();
	}

	public MezclarDatos(
		String ficheroDemarcaciones, String ficheroSelecciones,
		String ficheroJugadores, String ficheroGuardado
	) {
		super();
		this.selecciones = new ArrayList<Seleccion>();
		this.demarcaciones = new ArrayList<Demarcacion>();
		this.jugadores = new ArrayList<Jugador>();
		this.ficheroDemarcaciones = ficheroDemarcaciones;
		this.ficheroSelecciones = ficheroSelecciones;
		this.ficheroJugadores = ficheroJugadores;
		this.ficheroGuardado = ficheroGuardado;
	}

	public void guardarDatos() {
		CustomBufferedWriter customBufferedReader = new CustomBufferedWriter() {
			public void streamWrite() throws IOException {
				for (Seleccion seleccion : selecciones) {
					stream.write(seleccion.getNombre());
					stream.newLine();
					for (Jugador jugador : jugadores) {
						if (jugador.getSeleccion().equals(seleccion)) {
							stream.write(jugador.getNombre());
							stream.write(":");
							stream.write(jugador.getDemarcacion().getNombre());
							stream.newLine();
						}
					}
					stream.newLine();
				}
			}
		};

		customBufferedReader.write(ficheroGuardado);
	}

	public void cargarJugadores() {
		CustomBufferedReader customBufferedReader = new CustomBufferedReader() {
			public void streamRead() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					StringTokenizer partes = new StringTokenizer(linea, ":");
					jugadores.add(
						new Jugador(
							partes.nextToken(),
							getDemarcacion(partes.nextToken()),
							getSeleccion(partes.nextToken())
						)
					);
					linea = stream.readLine();
				}
			}
		};

		customBufferedReader.read(ficheroJugadores);
	}

	public void cargarSelecciones() {
		CustomBufferedReader customBufferedReader = new CustomBufferedReader() {
			public void streamRead() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					StringTokenizer partes = new StringTokenizer(linea, ":");
					selecciones.add(
						new Seleccion(partes.nextToken(), partes.nextToken())
					);
					linea = stream.readLine();
				}
			}
		};

		customBufferedReader.read(ficheroSelecciones);
	}

	public void cargarDemarcaciones() {
		CustomBufferedReader customBufferedReader = new CustomBufferedReader() {
			public void streamRead() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					StringTokenizer partes = new StringTokenizer(linea, ":");
					demarcaciones.add(
						new Demarcacion(partes.nextToken(), partes.nextToken())
					);
					linea = stream.readLine();
				}
			}
		};

		customBufferedReader.read(ficheroDemarcaciones);
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
}
