package ejercicio1;

public abstract class Plato {
	protected String nombre;
	protected float precio;

	public Plato(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nPrecio: " + precio + "\n";
	}
}
