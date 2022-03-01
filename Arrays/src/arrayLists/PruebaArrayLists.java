package arrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PruebaArrayLists {
	@SuppressWarnings({
		"unchecked", "rawtypes", "unused"
	})
	public static void main(String[] args) {
		ArrayList lista = new ArrayList();
		lista.add("Hola");
		lista.add(18);
		lista.add(23.75);
		lista.add(true);

		System.out.printf("%s\n", lista);

		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Javier");
		nombres.add("Marcos");
		nombres.add("Alba");
		System.out.printf("%s\n", nombres);

		nombres.add(1, "Sonia");
		System.out.printf("%s\n", nombres);

		nombres.remove("Javier");
		System.out.printf("%s\n", nombres);

		nombres.set(1, "Matias");
		System.out.printf("%s\n", nombres);

		// nombres.clear();
		// System.out.printf("%s\n", nombres);

		// ArrayList<ArrayList<String>> listaDoble =
		// new ArrayList<ArrayList<String>>();

		for (int i = 0; i < nombres.size(); i++) {
			System.out.printf("%s\n", nombres.get(i));
		}

		for (String string : nombres) {
			System.out.printf("%s\n", string);
		}

		Iterator<String> iterador = nombres.iterator();
		while (iterador.hasNext()) {
			System.out.printf("%s\n", iterador.next());
		}

		System.out.printf(
			"Alba esta en la posicion %d\n", nombres.indexOf("Alba")
		);

		System.out.printf(
			"Esta alba en la lista? %s\n", nombres.contains("Alba")
		);

		ArrayList<Integer> numeros = new ArrayList<Integer>(
			Arrays.asList(5, 2, 3)
		);

		String[] arrayNombres = {
			"Pedro", "Juan", "Alberto"
		};

		ArrayList<String> listaNombres = new ArrayList<String>(
			Arrays.asList(arrayNombres)
		);

		Object[] array = listaNombres.toArray();
	}
}
