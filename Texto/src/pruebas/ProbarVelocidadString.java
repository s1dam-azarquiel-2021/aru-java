package pruebas;

public class ProbarVelocidadString {
	public static void main(String[] args) {
		String s = "";
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s = s.concat("Hola");
		}
		long fin = System.currentTimeMillis();
		System.out.printf("Tiempo de String: %d\n", fin - inicio);

		StringBuilder s2 = new StringBuilder();
		long inicio2 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s2.append("Hola");
		}
		long fin2 = System.currentTimeMillis();
		System.out.printf("Tiempo de StrinaBuilder: %d\n", fin2 - inicio2);
	}
}
