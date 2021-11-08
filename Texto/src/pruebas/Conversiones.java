package pruebas;

import java.util.Scanner;

public class Conversiones {
	public static void main(String[] args) {
		// int a = 123456;
		// String texto = String.valueOf(a);
		// a = Integer.parseInt(texto);
		
		Scanner input = new Scanner(System.in);
		String numero = input.nextLine();
		input.close();
		
		int n1 = Integer.parseInt(numero.substring(0, 3));
		int n2 = Integer.parseInt(numero.substring(3, 6));
		
		System.out.println("La suma es: " + (n1 + n2));
	}
}
