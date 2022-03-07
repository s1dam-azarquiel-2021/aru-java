package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		// Obtener una fecha en formato dia, mes y año por Input
		Scanner input = new Scanner(System.in);
		System.out.printf("Introduce una fecha como dia, mes y año: ");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		input.close();

		// Segun el dia puede que sea el ultimo de algun mes
		if (day == 31) {
			// Meses que acaban el 31
			switch (month) {
			case 12:
				// Si es el ultimo mes se suma un año, el mes y el dia es 1
				year++;
				month = 1;
				day = 1;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				// El resto de meses solo se suma 1 y el dia es 1
				month++;
				day = 1;
				break;
			}
		} else if (day == 30) {
			// Meses que acaban el 30
			switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				// Igual que antes
				month++;
				day = 1;
				break;
			}
		} else if (day == 28 && month == 2) {
			// Y si es el ultimo dia de febrero lo mismo
			month++;
			day = 1;
		} else {
			// Si no es el ultimo dia del mes se suma 1 al dia
			day++;
		}

		System.out.printf("Mañana sera: %d/%d/%d\n", day, month, year);
	}
}
