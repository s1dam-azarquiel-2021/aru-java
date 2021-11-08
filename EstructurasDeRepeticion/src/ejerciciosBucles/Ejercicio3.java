package ejerciciosBucles;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		// Pedir un numero
		System.out.print("Introduce un numero: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		String linea = "";
		// Ir anadiendo a cada linea el siguiente numero y mostrarla
		for (int i = 1; i <= n; i++) {
			linea += i + " ";
			System.out.println(linea);
		}
	}
}
