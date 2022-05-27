package ejerciciosMetodos;

public class Ejercicio16 {
	public static void calendario(int m, int y) {
		System.out.printf("\t\t%s %d\n", intToMes(m), y);
		System.out.printf("L\tM\tX\tJ\tV\tS\tD\n");
		int inicio = diaComienzoMes(m, y);
		int dias = diasDeMes(m, y);
		for (int i = 1; i < dias + inicio; i += 7) {
			for (int j = i; j < i + 7 && j <= dias + inicio - 1; j++) {
				if (j < inicio) {
					System.out.printf("\t");
				} else {
					System.out.printf("%d\t", j - inicio + 1);
				}
			}
			System.out.printf("\n");
		}
	}

	public static String intToMes(int m) {
		String[] meses = {
			"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
			"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
		};

		return meses[m - 1];
	}

	public static boolean esBisiesto(int y) {
		return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
	}

	public static int diaComienzoMes(int m, int y) {
		if (m == 1 || m == 2) {
			return (y + 31 * (m - 1) + (y - 1) / 4 - 3 * ((y + 99) / 100) / 4)
			% 7;
		} else {
			return (y + 31 * (m - 1) - (4 * m + 23) / 10 + y / 4 - (3 * (y / 100
			+ 1)) / 4) % 7;
		}
	}

	public static int diasDeMes(int m, int y) {
		int[] dias = {
			31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
		};
		if (m == 2 && esBisiesto(y)) {
			return dias[m - 1] + 1;
		} else {
			return dias[m - 1];
		}
	}
}
