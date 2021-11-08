package bucleWhile;

import java.util.Scanner;

public class NumeroSecreto {
	public static void main(String[] args) {
		final int nSecreto = (int) (Math.random() * 10);

		Scanner input = new Scanner(System.in);
		int nIntroducido;
		do {
			System.out.print("Prueba suerte: ");
			nIntroducido = input.nextInt();
		} while (nIntroducido != nSecreto);
		input.close();
		
		System.out.println("Ganador!");
	}
}
