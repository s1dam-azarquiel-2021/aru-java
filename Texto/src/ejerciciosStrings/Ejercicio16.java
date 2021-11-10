package ejerciciosStrings;

import java.util.Scanner;

public class Ejercicio16 {
	public static void main(String[] args) {
		// Realiza un programa que compruebe si en una palabra se repite alguna
		// vocal mas de 2 veces. El programa pedira que se teclee una palabra
		// y comprobara que una vocal aparece mas de dos veces emitira un
		// mensaje en la pantalla y terminara. El programa debe terminar en el
		// mismo instante que encuentre mas de dos vocales iguales, no esperara
		// a comprobar toda la palabra

		System.out.printf("Introduce una palabra: ");
		Scanner input = new Scanner(System.in);
		String palabra = input.nextLine();
		input.close();

		// Quiero usar arrays :(
		StringBuilder nVocales = new StringBuilder("00000");
		boolean tieneMas2Vocales = false;

		for (int i = 0; i < palabra.length() && !tieneMas2Vocales; i++) {
			switch(palabra.charAt(i)) {
			case 'a', 'A':
				char nA = nVocales.charAt(0);
				nVocales.setCharAt(0, ++nA);
				if (nA == 51) {
					tieneMas2Vocales = true;
				}
				break;
			case 'e', 'E':
				char nE = nVocales.charAt(1);
				nVocales.setCharAt(0, ++nE);
				if (nE == 51) {
					tieneMas2Vocales = true;
				}
				break;
			case 'i', 'I':
				char nI = nVocales.charAt(2);
				nVocales.setCharAt(0, ++nI);
				if (nI == 51) {
					tieneMas2Vocales = true;
				}
				break;
			case 'o', 'O':
				char nO = nVocales.charAt(3);
				nVocales.setCharAt(0, ++nO);
				if (nO == 51) {
					tieneMas2Vocales = true;
				}
				break;
			case 'u', 'U':
				char nU = nVocales.charAt(4);
				nVocales.setCharAt(0, ++nU);
				if (nU == 51) {
					tieneMas2Vocales = true;
				}
				break;
			}
		}

		if (tieneMas2Vocales) {
			System.out.printf("Tiene mas de dos vocales iguales.\n");
		} else {
			System.out.printf("No tiene mas de dos vocales iguales.\n");
		}
	}
}
