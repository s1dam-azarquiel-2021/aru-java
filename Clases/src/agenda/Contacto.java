package agenda;

public class Contacto {
	private String nombre;
	private long telefono;

	public Contacto(String nombre, long telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Contacto: " + nombre + "\nTelefono: " + telefono + "\n";
	}
}