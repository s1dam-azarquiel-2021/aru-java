package ejercicio3;

import java.util.ArrayList;

import ejercicio3.Electrodomestico.Color;
import ejercicio3.Electrodomestico.Consumo;

public class Prueba {
	public static void main(String[] args) {
		ArrayList<Electrodomestico> lista = new ArrayList<Electrodomestico>(10);
		lista.add(new Electrodomestico());
		lista.add(new Electrodomestico(10, 50));
		lista.add(new Electrodomestico(Color.ROJO, Consumo.B, 5, 200));
		lista.add(new Lavadora());
		lista.add(new Lavadora(40, 250));
		lista.add(new Lavadora(Color.BLANCO, Consumo.A, 60, 899, 80));
		lista.add(new Television());
		lista.add(new Television(28, 150));
		lista.add(new Television(Color.AZUL, Consumo.C, 6, 1779, 80, true));

		float pElectrodomestico = 0;
		float pLavadora = 0;
		float pTelevision = 0;
		for (Electrodomestico electrodomestico : lista) {
			if (electrodomestico instanceof Lavadora) {
				pLavadora += ((Lavadora) electrodomestico).precioFinal();
			} else if (electrodomestico instanceof Television) {
				pTelevision += ((Television) electrodomestico).precioFinal();
			} else {
				pElectrodomestico += electrodomestico.precioFinal();
			}
		}

		System.out.printf(
			"Precio electrodomesticos: %f\nPrecio lavadoras: %f\nPrecio televisiones: %f\n",
			pElectrodomestico, pLavadora, pTelevision
		);
	}
}
