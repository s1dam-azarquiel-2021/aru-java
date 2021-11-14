package pruebas;

public class PruebaString2 {
	public static void main(String[] args) {
		String s = "Hola que tal",
			   t = "hola que tal";
		

		System.out.printf("Son iguales: %s\n" + s.equals(t));
		System.out.printf("Son iguales: %s\n" + s.equalsIgnoreCase(t));

		System.out.printf("Diferencia entre frases: %s\n" + s.compareTo(t));

		System.out.printf(
			"La frase comienza por \"Hola\": %s\n",
			s.startsWith("Hola")
		);
		System.out.printf("La frase acaba en \".\": %s\n" + s.endsWith("."));

		System.out.printf(
			"Trozo de la posicion 3 a la 10: %s\n",
			s.substring(3, 10)
		);
		System.out.printf(
			"Trozo de la posicion 2 en adelante: %s\n",
			s.substring(2)
		);

		System.out.printf(
			"La letra \'q\' esta en la posicion: %s\n",
			s.indexOf('q')
		);
		System.out.printf(
			"La letra \'h\' esta en la posicion: %s\n",
			s.indexOf('h')
		);
		System.out.printf(
			"La letra \'a\' aparece por ultima vez: %s\n",
			s.lastIndexOf('a')
		);
		System.out.printf(
			"La palabra \"que\" esta en la posicion: %s\n",
			s.indexOf("que")
		);
		System.out.printf(
			"La letra \'a\' apartir de la posicion 4: %s\n",
			s.lastIndexOf('a', 4)
		);
	}
}
