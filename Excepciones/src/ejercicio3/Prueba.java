package ejercicio3;

public class Prueba {
	public static void main(String[] args) {
		Pandilla pandi = new Pandilla(2);

		try {
			pandi.add(new Amigo("Juan", "Callado"));
			pandi.add(new Amigo("Tomas", "A sorbos"));
			pandi.add(new Amigo("Pepino", "El pepino"));
		} catch (PandillaCompletaException e) {
			System.out.println(e.getMessage());
		} catch (VayaNombreDeMierdaException e) {
			System.out.println(e.getMessage());
		}
	}
}
