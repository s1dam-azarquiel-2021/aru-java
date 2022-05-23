package ejercicio1;

public class Residente {
	private String matricula;

	public Residente(String matricula, String nombre) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
	}

	private String nombre;

	public String getMatricula() {
		return this.matricula;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "matricula: " + matricula + "\nnombre: " + nombre + "\n";
	}
}
