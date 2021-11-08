package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		// Obtener un numero por Input
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce un numero del 0 al 9999: ");
		int n = input.nextInt();
		input.close();
		
		// Segun sea menor de potencias de 10 sabremos el resultado
		// Con un bucle seria mas facil
		if (n < 10) {
			System.out.println("Tiene " + 1 + " cifra");
		} else if (n < 100) {
			System.out.println("Tiene " + 2 + " cifras");
		} else if (n < 1000) {
			System.out.println("Tiene " + 3 + " cifras");
		} else if (n < 10000) {
			System.out.println("Tiene " + 4 + " cifras");
		} else {
			System.out.println("Demasiadas cifras");
		}
	}
}
