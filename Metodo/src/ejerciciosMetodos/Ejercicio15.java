package ejerciciosMetodos;

public class Ejercicio15 {
	public static String decToBinario (int n) {
		String resultado = "";
		while (n > 1) {
			resultado = n % 2 + resultado;
			n /= 2;
		}

		return n + resultado;
	}

	public static String decToOctal (int n) {
		String resultado = "";
		while (n > 7) {
			resultado = n % 8 + resultado;
			n /= 8;
		}

		return n + resultado;
	}

	public static String decToHexadecimal (int n) {
		String resultado = "";
		while (n > 15) {
			resultado = decHexToCharHex(n % 16) + resultado;
			n /= 16;
		}

		return decHexToCharHex(n) + resultado;
	}

	public static char decHexToCharHex (int n) {
		char[] hexChars = { 'A', 'B', 'C', 'D', 'E' };
		if (n > 9) {
			return hexChars[n - 10];
		} else {
			return (char) ('0' + n);
		}
	}
}
