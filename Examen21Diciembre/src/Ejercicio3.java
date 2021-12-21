public class Ejercicio3 {
	public static void main(String[] args) {
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}

		int total = 0;
		for (int n : array) {
			total += n;
		}

		int sumaIzq = 0;
		int sumaDer = total - array[0];
		int centro = 0;
		int diferencia = Integer.MAX_VALUE;

		for (int i = 1; i < array.length - 1; i++) {
			sumaIzq += array[i - 1];
			sumaDer -= array[i];
			int difActual = Math.abs(sumaDer - sumaIzq);

			if (difActual < diferencia) {
				centro = i;
				diferencia = difActual;
			}
		}

		System.out.printf(
			"El centro esta en la posicion %d, con una diferencia de %d\n",
			centro, diferencia
		);
	}
}
