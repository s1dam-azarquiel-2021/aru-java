package pruebas;

public class PruebaString2 {
	public static void main(String[] args) {
		String s = "Hola que tal",
			   t = "hola que tal";
		
		System.out.println("Son iguales: " + s.equals(t));
		System.out.println("Son iguales: " + s.equalsIgnoreCase(t));

		System.out.println("Diferencia entre frases: " + s.compareTo(t));

		System.out.println("La frase comienza por \"Hola\": " +
						   s.startsWith("Hola"));
		System.out.println("La frase acaba en \".\": " + s.endsWith("."));

		System.out.println("Trozo de la posicion 3 a la 10: " +
						   s.substring(3, 10));
		System.out.println("Trozo de la posicion 2 en adelante: " +
						   s.substring(2));

		System.out.println("La letra \'q\' esta en la posicion: " +
						   s.indexOf('q'));
		System.out.println("La letra \'h\' esta en la posicion: " +
						   s.indexOf('h'));
		System.out.println("La letra \'a\' aparece por ultima vez: " +
						   s.lastIndexOf('a'));
		System.out.println("La palabra \"que\" esta en la posicion: " +
						   s.indexOf("que"));
		System.out.println("La letra \'a\' apartir de la posicion 4: " +
						   s.lastIndexOf('a', 4));
	}
}
