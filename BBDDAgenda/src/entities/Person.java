package entities;

public class Person {
	private String dni;
	private String nombre;
	private long telefono;

	public Person(String dni, String nombre, long telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public long getTelefono() {
		return this.telefono;
	}

	@Override
	public String toString() {
		return "dni: " + dni + "\nnombre: " + nombre + "\ntelefono: " + telefono
		+ "\n";
	}
}
