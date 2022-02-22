package empresa;

public class Persona {
	protected String dni;
	protected String nombre;
	protected String direccion;
	protected long telefono;
	protected int edad;

	public Persona(
		String dni, String nombre, String direccion, long telefono, int edad
	) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Dni: " + dni + "\nNombre: " + nombre + "\nDireccion" + direccion
			+ "\nTelefono: " + telefono + "\nEdad: " + edad + "\n";
	}
}
