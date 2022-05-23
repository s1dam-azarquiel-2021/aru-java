package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Arreglar {
	private String fMultas;
	private String fResidentes;
	private ArrayList<Residente> residentes;
	private ArrayList<Multa> multas;

	public static void main(String[] args) {
		Arreglar arreglar = new Arreglar("multas.txt", "residentes.txt");

		arreglar.cargarMultas();
		arreglar.cargarResidentes();
		arreglar.arreglar();
		arreglar.guardar();
	}

	public Arreglar(String fMultas, String fResidentes) {
		this.fMultas = fMultas;
		this.fResidentes = fResidentes;
		this.residentes = new ArrayList<>();
		this.multas = new ArrayList<>();
	}

	public void cargarResidentes() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					StringTokenizer tokens = new StringTokenizer(linea, ":");
					residentes.add(
						new Residente(tokens.nextToken(), tokens.nextToken())
					);
					linea = stream.readLine();
				}
			}
		};

		br.read(this.fResidentes);
	}

	private Residente getResidente(String matricula) {
		for (Residente residente : this.residentes) {
			if (residente.getMatricula().equals(matricula)) {
				return residente;
			}
		}

		return null;
	}

	public void cargarMultas() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				String linea = stream.readLine();
				while (linea != null) {
					StringTokenizer tokens = new StringTokenizer(linea, ":");
					multas.add(
						new Multa(
							tokens.nextToken(),
							tokens.nextToken(),
							tokens.nextToken()
						)
					);
					linea = stream.readLine();
				}
			}
		};

		br.read(this.fMultas);
	}

	public void arreglar() {
		for (int i = 0; i < this.multas.size(); i++) {
			if (this.getResidente(this.multas.get(i).getMatricula()) != null) {
				this.multas.remove(i);
			}
		}
	}

	public void guardar() {
		CustomBufferedWriter bw = new CustomBufferedWriter() {
			public void main() throws IOException {
				for (Multa multa : multas) {
					stream.write(
						multa.getFecha() + ":" + multa.getMatricula() + ":"
						+ multa.getDescripcion()
					);
					stream.newLine();
				}
			}
		};

		bw.write(this.fMultas);
	}
}
