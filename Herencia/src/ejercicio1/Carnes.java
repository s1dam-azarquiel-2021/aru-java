package ejercicio1;

public class Carnes extends Plato {
	public enum Grado {
		POCO_HECHO, AL_PUNTO, MUY_HECHO, CARBONIZADO
	}

	private Grado grado;

	public Carnes(String nombre, float precio, Grado grado) {
		super(nombre, precio);
		this.grado = grado;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	@Override
	public String toString() {
		return super.toString() + "Grado: " + grado + "\n";
	}
}
