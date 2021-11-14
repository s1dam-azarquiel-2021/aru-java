package simpleYDoble;

import java.util.Scanner;

public class Horoscopo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Introduce tu dia y mes de nacimiento: ");
		int dia = scanner.nextInt();
		int mes = scanner.nextInt();
		scanner.close();

		String signo;

		switch (mes) {
		case 1:
			signo = dia <= 20 ? "Capricornio" : "Acuario";
			break;
		case 2:
			signo = dia <= 19 ? "Acuario" : "Piscis";
			break;
		case 3:
			signo = dia <= 20 ? "Piscis" : "Aries";
			break;
		case 4:
			signo = dia <= 21 ? "Aries" : "Tauro";
			break;
		case 5:
			signo = dia <= 21 ? "Tauro" : "Geminis";
			break;
		case 6:
			signo = dia <= 21 ? "Geminis" : "Cancer";
			break;
		case 7:
			signo = dia <= 22 ? "Cancer" : "Leo";
			break;
		case 8:
			signo = dia <= 22 ? "Leo" : "Virgo";
			break;
		case 9:
			signo = dia <= 22 ? "Virgo" : "Libra";
			break;
		case 10:
			signo = dia <= 22 ? "Libra" : "Escorpio";
			break;
		case 11:
			signo = dia <= 22 ? "Capricornio" : "Sagitario";
			break;
		case 12:
			signo = dia <= 22 ? "Sagitario" : "Capricornio";
			break;
		default:
			signo = "Eres un caso raro";
		}

		System.out.printf("%s\n", signo);
	}
}
