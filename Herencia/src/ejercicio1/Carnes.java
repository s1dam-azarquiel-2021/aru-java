package ejercicio1;

public class Carnes extends Plato {
	private String grado;

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Carnes(String nombre, float precio, String grado) {
		super(nombre, precio);
		this.grado = grado;
	}

	@Override
	public String toString() {
		return super.toString() + "Grado: " + grado + "\n";
	}
}
