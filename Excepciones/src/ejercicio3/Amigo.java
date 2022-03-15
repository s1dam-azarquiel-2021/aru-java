package ejercicio3;

public class Amigo {
	private String nombre;
	private String apodo;

	public Amigo(String nombre, String apodo) {
		super();
		this.nombre = nombre;
		this.apodo = apodo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApodo() {
		return this.apodo;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + "\napodo: " + apodo + "\n";
	}
}
