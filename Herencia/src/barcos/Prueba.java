package barcos;

import java.util.ArrayList;

public class Prueba {
	public static void main(String[] args) {
		BarcoPasajeros barco = new BarcoPasajeros(
			"Titanic", "Cristobal", 1200, 20
		);
		BarcoPesquero bp = new BarcoPesquero(
			"L barco chanquete", "Cristobal", 1200, true
		);

		System.out.printf("%s\n", barco);
		System.out.printf("%s\n", bp);

		ArrayList<Navegable> lista = new ArrayList<Navegable>();
		lista.add(bp);
		lista.add(barco);
	}
}
