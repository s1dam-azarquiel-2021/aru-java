import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce una frase: ");
		String frase = input.nextLine();
		input.close();

		char[][] array = new char[frase.length()][frase.length()];
		for (int i = 0; i < frase.length(); i++) {
			for (int j = 0; j < frase.length(); j++) {
				int pos = j + i;
				if (pos >= frase.length()) {
					pos -= frase.length();
				}
				array[i][pos] = frase.charAt(j);
			}
		}

		for (char[] ns : array) {
			for (char n : ns) {
				System.out.printf("%c ", n);
			}
			System.out.printf("\n");
		}
	}
}
