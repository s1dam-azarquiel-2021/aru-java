package pruebas;

public class PrimeraPrueba {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] a = new int[20];
		a[4] = 37;

		System.out.printf("Hueco 5: %d\n\n", a[4]);

		for (int i = 0; i < a.length; i++) {
			System.out.printf("Hueco %d:\t%d\n", i, a[i]);
		}

		a = new int[30];

		a[6]++;
		a[7] = 33;
		a[8] = a[7] + a[6];

		System.out.printf("\n6: %d, 7: %d, 8: %d\n\n", a[6], a[7], a[8]);

		a = new int[10];

		// Rellenar el array con datos aleatorios
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}

		for (int i = 0; i < a.length; i++) {
			System.out.printf("Hueco %d:\t%d\n", i, a[i]);
		}

		// Declarar un array poniendo los valores directamente
		int[] b = {12, 45, 85, 32, 185, 3};
	}
}
