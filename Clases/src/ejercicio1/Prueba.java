package ejercicio1;

public class Prueba {
	public static void main(String[] args) {
		Rectangulo rectangulo = new Rectangulo(5, 2);
		System.out.printf("%s\n", rectangulo);
		System.out.printf("Area: %s\n", rectangulo.area());
		System.out.printf("Perimetro: %s\n", rectangulo.perimeter());
		System.out.printf("Es horizontal? %s\n", rectangulo.isHorizontal());
		System.out.printf("Dibujo:\n");
		rectangulo.draw();
	}
}
