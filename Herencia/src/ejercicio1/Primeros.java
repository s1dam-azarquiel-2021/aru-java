package ejercicio1;

public class Primeros extends Plato {
	private boolean compartir;

	public Primeros(String nombre, float precio, boolean compartir) {
		super(nombre, precio);
		this.compartir = compartir;
	}

	public boolean isCompartir() {
		return compartir;
	}

	public void setCompartir(boolean compartir) {
		this.compartir = compartir;
	}

	@Override
	public String toString() {
		return super.toString() + "Compartir: " + compartir + "\n";
	}
}
