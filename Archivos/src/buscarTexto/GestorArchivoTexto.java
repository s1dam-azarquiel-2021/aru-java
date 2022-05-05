package buscarTexto;

import java.io.IOException;
import java.util.stream.Collectors;

import customReaderWriter.CustomBufferedReader;
import customReaderWriter.CustomBufferedWriter;

public class GestorArchivoTexto {
	private String archivo;
	private String contenido;

	public GestorArchivoTexto(String archivo) {
		super();
		this.archivo = archivo;
	}

	public void readContenido() {
		CustomBufferedReader br = new CustomBufferedReader() {
			public void main() throws IOException {
				contenido = stream.lines().collect(
					Collectors.joining(System.lineSeparator())
				);
			}
		};

		br.read(archivo);
	}

	public void guardarContenido() {
		CustomBufferedWriter bw = new CustomBufferedWriter() {
			public void main() throws IOException {
				stream.write(contenido);
			}
		};

		bw.write(archivo);
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
