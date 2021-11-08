package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		// Obtener el numero del usuario y el numero premiado por Input
		Scanner input = new Scanner(System.in);
		System.out.print("Introduce tu numero: ");
		int n_usuario = input.nextInt();
		System.out.print("Introduce el numero premiado: ");
		int n_premiado = input.nextInt();
		input.close();

		// Sacar la primera y ultima cifra de ambos numeros
		final int N_USUARIO_PRIMERA_CIFRA  = n_usuario  / 10000,
				  N_USUARIO_ULTIMA_CIFRA   = n_usuario  % 10,
				  N_PREMIADO_PRIMERA_CIFRA = n_premiado / 10000,
				  N_PREMIADO_ULTIMA_CIFRA  = n_premiado % 10;

		if (N_USUARIO_PRIMERA_CIFRA == N_PREMIADO_PRIMERA_CIFRA ||
			N_USUARIO_ULTIMA_CIFRA  == N_PREMIADO_ULTIMA_CIFRA) {
			System.out.println("Si tiene reintegro");
		} else {
			System.out.println("No tiene reintegro");
		}
	}
}
