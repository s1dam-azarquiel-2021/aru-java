package pruebas;

public class PruebaWrapper {
	public static void main(String[] args) {
		int a = 7,
			b = 7;
		
		@SuppressWarnings("removal")
		Integer c = new Integer(7),
				d = new Integer(7);
		
		System.out.println(a == b);
		System.out.println(c.equals(d));
	}
}
