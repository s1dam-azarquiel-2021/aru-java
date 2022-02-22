package ejercicio1;

public class Postres extends Plato {
	private boolean conAzucar;

	public Postres(String nombre, float precio, boolean conAzucar) {
		super(nombre, precio);
		this.conAzucar = conAzucar;
	}

	public boolean isConAzucar() {
		return conAzucar;
	}

	public void setConAzucar(boolean conAzucar) {
		this.conAzucar = conAzucar;
	}

	@Override
	public String toString() {
		return super.toString() + "Con azucar: " + conAzucar + "\n";
	}
}
