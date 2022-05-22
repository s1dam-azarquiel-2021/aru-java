package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import customReaderWriter.CustomBufferedReader;
import customReaderWriter.CustomBufferedWriter;

public class GenerarPremios {
	private String fCombinaciones;
	private String fCombiGanadora;
	private String fPremios;
	private ArrayList<ArrayList<Integer>> combinaciones;
	private ArrayList<Integer> combiGanadora;

	public static void main(String[] args) {
		GenerarPremios generarPremios = new GenerarPremios(
			"combinaciones.txt",
			"combiGanadora.txt",
			"premios.txt"
		);

		generarPremios.cargarCombinaciones();
		generarPremios.cargarCombiGanadora();
		generarPremios.guardarPremios();
	}

	public GenerarPremios(
		String fCombinaciones, String fCombiGanadora, String fPremios
	) {
		this.fCombinaciones = fCombinaciones;
		this.fCombiGanadora = fCombiGanadora;
		this.fPremios = fPremios;
		this.combinaciones = new ArrayList<>();
		this.combiGanadora = new ArrayList<>();
	}

	public void cargarCombinaciones() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					ArrayList<Integer> combinacionActual = new ArrayList<>();
					StringTokenizer numeros = new StringTokenizer(linea, ",");
					while (numeros.hasMoreElements()) {
						combinacionActual.add(
							Integer.valueOf(numeros.nextToken())
						);
					}
					combinaciones.add(combinacionActual);
					linea = stream.readLine();
				}
			}
		};

		br.read(this.fCombinaciones);
	}

	public void cargarCombiGanadora() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				String linea = stream.readLine();
				StringTokenizer numeros = new StringTokenizer(linea, ",");
				while (numeros.hasMoreElements()) {
					combiGanadora.add(Integer.valueOf(numeros.nextToken()));
				}
			}
		};

		br.read(this.fCombiGanadora);
	}

	public void guardarPremios() {
		CustomBufferedWriter bw = new CustomBufferedWriter() {
			public void main() throws IOException {
				for (ArrayList<Integer> combinacionActual : combinaciones) {
					int acertadas = 0;
					for (Integer n : combinacionActual) {
						if (combiGanadora.contains(n)) {
							acertadas++;
						}
					}
					stream.write(
						combinacionActual.toString().replaceAll("\\[|\\]", "")
						+ ": " + acertadas + " aciertos"
					);
					stream.newLine();
				}
			}
		};

		bw.write(fPremios);
	}
}
