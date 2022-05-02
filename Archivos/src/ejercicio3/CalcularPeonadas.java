package ejercicio3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import customReaderWriter.CustomBufferedReader;
import customReaderWriter.CustomBufferedWriter;

public class CalcularPeonadas {
	private ArrayList<Trabajador> trabajadores;
	private String ficheroTrabajadores;
	private String ficheroPeonadas;
	private String ficheroTotalPeonadas;

	public static void main(String[] args) {
		CalcularPeonadas calcularPeonadas = new CalcularPeonadas(
			"Trabajadores.txt",
			"Peonadas.txt",
			"TotalPeonadas.txt"
		);
		calcularPeonadas.cargarTrabajadores();
		calcularPeonadas.cargarPeonadas();
		calcularPeonadas.guardarPeonadas();
	}

	public CalcularPeonadas(
		String ficheroTrabajadores, String ficheroPeonadas,
		String ficheroTotalPeonadas
	) {
		super();
		this.trabajadores = new ArrayList<Trabajador>();
		this.ficheroTrabajadores = ficheroTrabajadores;
		this.ficheroPeonadas = ficheroPeonadas;
		this.ficheroTotalPeonadas = ficheroTotalPeonadas;
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
		CustomBufferedWriter bw = new CustomBufferedWriter() {
			public void main() throws IOException {
				for (Trabajador trabajador : trabajadores) {
					stream.write(trabajador.toString());
					stream.newLine();
				}
			}
		};

		bw.write(this.ficheroTotalPeonadas);
	}

	public void cargarPeonadas() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					StringTokenizer partes = new StringTokenizer(linea, ":");
					partes.nextToken();
					StringTokenizer trabajadores = new StringTokenizer(
						partes.nextToken(),
						","
					);

					while (trabajadores.hasMoreElements()) {
						getTrabajador(
							trabajadores.nextToken()
						).aumentarDiasTrabajados();
					}

					linea = stream.readLine();
				}
			}
		};

		br.read(this.ficheroPeonadas);
	}

	public void cargarTrabajadores() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					trabajadores.add(new Trabajador(linea));
					linea = stream.readLine();
				}
			}
		};

		br.read(ficheroTrabajadores);
	}
}
