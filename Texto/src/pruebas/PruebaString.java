package pruebas;

public class PruebaString {
	public static void main(String[] args) {
		String s = new String("Hola");
		String t = new String("Hola");

		System.out.printf("%s\n", s == t);
		System.out.printf("%s\n", s.equals(t));

		System.out.printf("La frase tiene %s letras\n", s.length());

		System.out.printf(
			"La letra que esta en la posicion 2 es la %c\n", s.charAt(2)
		);

		System.out.printf(
			"La ultima letra es la %c\n", s.charAt(s.length() - 1)
		);

		int a = 52352485;
		String frase = String.valueOf(a);
		System.out.printf("El numero tiene %d cifras\n", frase.length());
	}
}
