package simpleYDoble;

import java.util.Scanner;

public class Horoscopo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce tu dia y mes de nacimiento: ");
		int dia = scanner.nextInt();
		int mes = scanner.nextInt();
		scanner.close();

		switch (mes) {
		case 1:
			System.out.println((dia <= 20) ? "Capricornio" : "Acuario");
			break;
		case 2:
			System.out.println((dia <= 19) ? "Acuario" : "Piscis");
			break;
		case 3:
			System.out.println((dia <= 20) ? "Piscis" : "Aries");
			break;
		case 4:
			System.out.println((dia <= 21) ? "Aries" : "Tauro");
			break;
		case 5:
			System.out.println((dia <= 21) ? "Tauro" : "Geminis");
			break;
		case 6:
			System.out.println((dia <= 21) ? "Geminis" : "Cancer");
			break;
		case 7:
			System.out.println((dia <= 22) ? "Cancer" : "Leo");
			break;
		case 8:
			System.out.println((dia <= 22) ? "Leo" : "Virgo");
			break;
		case 9:
			System.out.println((dia <= 22) ? "Virgo" : "Libra");
			break;
		case 10:
			System.out.println((dia <= 22) ? "Libra" : "Escorpio");
			break;
		case 11:
			System.out.println((dia <= 22) ? "Capricornio" : "Sagitario");
			break;
		case 12:
			System.out.println((dia <= 22) ? "Sagitario" : "Capricornio");
			break;
		default:
			System.out.println("Eres un caso raro");
		}
	}
}
