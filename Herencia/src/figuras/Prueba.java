package figuras;

import java.util.ArrayList;

public class Prueba {
	public static void main(String[] args) {
		Circulo c = new Circulo("Azul", 6);
		Triangulo t = new Triangulo("Rojo", 3, 4);
		Cuadrado s = new Cuadrado("Verde", 3);

		ArrayList<Figura> lista = new ArrayList<Figura>();
		lista.add(s);
		lista.add(t);
		lista.add(c);

		for (Figura figura : lista) {
			System.out.printf("%s", figura);
			System.out.printf("Area: %f\n", figura.getArea());
			System.out.printf("Perimetro: %f\n", figura.getPerimetro());
			System.out.printf("\n");
		}
	}
}
