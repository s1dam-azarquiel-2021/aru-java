package ejerciciosExpresiones;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce tu edad: ");
		int age = scanner.nextInt();
		scanner.close();
		System.out.printf("Edad: %d, mayor de edad: %s\n", age, (age >= 18));
	}
}
