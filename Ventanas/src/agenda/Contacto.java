package agenda;

public class Contacto {
	private String nombre;
	private long telefono;

	public Contacto(String nombre, long telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(long telefono) {
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
		return "Nombre: " + nombre + "\nTelefono: " + telefono + "\n";
	}
}
