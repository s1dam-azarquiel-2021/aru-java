import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		StringBuilder cifras = new StringBuilder("a".repeat(10));

		Scanner input = new Scanner(System.in);
		while (!cifras.toString().equals("0123456789")) {
			System.out.printf("Escribe un numero: ");
			String numero = input.nextLine();

			for (int i = 0; i < numero.length(); i++) {
				char cifra = numero.charAt(i);
				// Si la cifra esta entre esos valores ascii, que corresponden
				// al 0 y 9, es un numero, se le resta 48 al ascii y te da cual
				// es ese numero, que lo anado al string numero en su posicion
				if (cifra >= 48 && cifra < 58) {
					int n = cifra - 48;
					cifras.setCharAt(n, cifra);
				}
			}
		}
		input.close();

		System.out.printf("Correcto, ya has escrito todas las cifras!\n");
	}
}
