package pruebas;

public class PruebaWrapper {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		int a = 7,
			b = 7;
		Integer c = new Integer(7),
				d = new Integer(7);
		

		System.out.printf("%s\n", a == b);
		System.out.printf("%s\n", c.equals(d));
	}
}
