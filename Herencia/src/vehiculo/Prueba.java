package vehiculo;

public class Prueba {
	public static void main(String[] args) {
		Coche c1 = new Coche(
			"Citroen",
			"C1",
			"Blanco",
			15000,
			1100,
			"Gasolina",
			5
		);
		Moto m1 = new Moto(
			"Harley",
			"R3",
			"amarillo",
			1299,
			7,
			"Gasolina",
			"Americana"
		);
		System.out.printf("%s\n", c1);
		System.out.printf("%s\n", m1);
	}
}
