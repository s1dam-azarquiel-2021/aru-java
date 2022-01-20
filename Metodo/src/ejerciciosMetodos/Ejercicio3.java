package ejerciciosMetodos;

public class Ejercicio3 {
	public static double redondear(double n, int p) {
		double precision = Math.pow(10, -p);
		double decimal = n % precision;
		double mitad = precision / 10 * 5;
		double sinDecimal = n - decimal;

		if (decimal >= mitad) {
			return sinDecimal + precision;
		} else {
			return sinDecimal;
		}
	}
}
