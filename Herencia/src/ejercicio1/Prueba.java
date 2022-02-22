package ejercicio1;

import java.util.ArrayList;

public class Prueba {
	public static void main(String[] args) {
		ArrayList<Plato> lista = new ArrayList<Plato>();
		lista.add(new Primeros("sopa", 5, false));
		lista.add(new Carnes("Solomillo", 8, "Muy hecho"));
		lista.add(new Pescados("Lubina", 8));
		lista.add(new Postres("Arroz con leche", 2, true));
		Comanda comanda = new Comanda(1, 1, lista);
		System.out.printf("%s\n", comanda);
		System.out.printf("%f\n", comanda.coste());
		System.out.printf("%s\n", comanda.hayDiabeticosEnLaMesa());
	}
}
