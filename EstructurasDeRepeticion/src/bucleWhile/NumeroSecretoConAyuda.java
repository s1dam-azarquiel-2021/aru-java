package bucleWhile;

import java.util.Scanner;

public class NumeroSecretoConAyuda {
	public static void main(String[] args) {
		// Generamos un numero aleatorio
		final int nSecreto = (int) (Math.random() * 100 + 1);

		Scanner input = new Scanner(System.in);
		int nIntroducido,
		    intentos = 0;
		do {
			// Pedimos un numero por input y incrementamos el intento
			System.out.print("Prueba suerte: ");
			nIntroducido = input.nextInt();
			intentos++;
			// Si el numero introducido es  mayor o menor que el secreto
			// Ayudar al usuario diciendoselo
			if (nIntroducido > nSecreto) {
				System.out.println("Te pasas prro");
			} else if (nIntroducido < nSecreto) {
				System.out.println("Te quedas corto");
			}
			// Mientras que no acertemos o nos queden intentos
		} while (nIntroducido != nSecreto && intentos < 8);
		input.close();
		
		if (intentos == 5) {
			System.out.println("Pero que malo eres!\n"
					         + "El numero era: " + nSecreto);
		} else {
			System.out.println("Ganador!");
		}
		
	}
}
