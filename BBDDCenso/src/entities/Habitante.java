package entities;

public class Habitante {
	private String nombre;
	private String email;
	private int edad;
	private Poblacion poblacion;

	public Habitante(
		String nombre, String email, int edad, Poblacion poblacion
	) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getEmail() {
		return this.email;
	}

	public int getEdad() {
		return this.edad;
	}

	public Poblacion getPoblacion() {
		return this.poblacion;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + "\nemail: " + email + "\nedad: " + edad
		+ "\npoblacion: " + poblacion + "\n";
	}
}
