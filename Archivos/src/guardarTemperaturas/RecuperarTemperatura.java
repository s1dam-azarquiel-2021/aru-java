package guardarTemperaturas;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RecuperarTemperatura {
	public static void main(String[] args) {
		File archivo = new File("temperaturas.txt");

		DataInputStream stream = null;
		float[] temperaturas = new float[30];
		try {
			stream = new DataInputStream(new FileInputStream(archivo));

			for (int i = 0; true; i++) {
				temperaturas[i] = stream.readFloat();
			}
		} catch (EOFException e) {
			Scanner input = new Scanner(System.in);
			System.out.print("De que dia quieres la temperatura: ");
			int dia = input.nextInt();
			System.out.printf("Temperatura: %.2f°C\n", temperaturas[dia - 1]);
			input.close();
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
