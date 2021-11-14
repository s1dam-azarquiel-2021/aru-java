package bucleFor;

public class TodasLasTablas {
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("Tabla del %d:\n", i);
			for (int j = 0; j <= 10; j++) {
				System.out.printf(
					"%d x %d = %d\n",
					j, i, (i * j)
				);
			}
			System.out.printf("\n-----\n\n");
		}
	}
}
