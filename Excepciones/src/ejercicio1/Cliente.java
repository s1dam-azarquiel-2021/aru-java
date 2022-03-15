package ejercicio1;

public class Cliente {
	private String dni;
	private String nombre;
	private long telefono;

	public Cliente(String dni, String nombre, long telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "DNI: " + dni + "\nNombre: " + nombre + "\nTelefono:" + telefono;
	}
}
