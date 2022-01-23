package ejerciciosMetodos;

public class Ejercicio11 {
	public static String romano(int n) {
		String[] decenas = {
			"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
		};
		String[] unidades = {
			"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
		};
		return decenas[n / 10] + unidades[n % 10];
	}
}
