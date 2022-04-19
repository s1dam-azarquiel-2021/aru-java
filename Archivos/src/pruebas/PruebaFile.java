package pruebas;

import java.io.File;
import java.text.DateFormat;

import javax.swing.JFileChooser;

public class PruebaFile {
	public static void main(String[] args) {
		JFileChooser dialogo = new JFileChooser();
		dialogo.showOpenDialog(null);

		File archivo = dialogo.getSelectedFile();

		if (archivo.exists()) {
			System.out.println("El archivo existe");
			System.out.println("Su ruta es: " + archivo.getAbsolutePath());
			System.out.println("Tamanio: " + archivo.length());
			System.out.println(
				"Fecha ultima modificacion: " + DateFormat.getInstance().format(
					archivo.lastModified()
				)
			);
			System.out.println("Permiso de lectura: " + archivo.canRead());
			System.out.println("Permiso de escritura: " + archivo.canWrite());
		} else {
			System.out.println("El archivo no existe");
		}
	}
}
