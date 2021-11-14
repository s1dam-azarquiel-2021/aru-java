package ejerciciosInstruccionesControl;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		// Obtener una fecha en formato dia, mes y año por Input
		Scanner input = new Scanner(System.in);
		int dia = input.nextInt(),
		    mes = input.nextInt(),
		    año = input.nextInt();
		System.out.printf("Introduce una fecha como dia, mes y año: ");
		input.close();

		// Segun el dia puede que sea el ultimo de algun mes
		if (dia == 31) {
			// Meses que acaban el 31
			switch (mes) {
			case 12:
				// Si es el ultimo mes se suma un año, el mes y el dia es 1
				año++;
				mes = 1;
				dia = 1;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				// El resto de meses solo se suma 1 y el dia es 1
				mes++;
				dia = 1;
				break;
			}
		} else if (dia == 30) {
			// Meses que acaban el 30
			switch (mes) {
			case 4:
			case 6:
			case 9:
			case 11:
				// Igual que antes
				mes++;
				dia = 1;
				break;
			}
		} else if (dia == 28 && mes == 2) {
			// Y si es el ultimo dia de febrero lo mismo
			mes++;
			dia = 1;
		} else {
			// Si no es el ultimo dia del mes se suma 1 al dia
			dia++;
		}

		System.out.printf("Mañana sera: %d/%d/%d\n", dia, mes, año);
	}
}
