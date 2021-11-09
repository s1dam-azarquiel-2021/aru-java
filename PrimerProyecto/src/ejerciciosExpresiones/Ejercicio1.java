package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce tu edad: ");
		int age = scanner.nextInt();
		scanner.close();
		System.out.println("\nEdad: " + age +
			", mayor de edad: " + (age >= 18));
	}
}
