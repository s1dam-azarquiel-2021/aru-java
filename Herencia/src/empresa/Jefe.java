package empresa;

public class Jefe extends Staff {
	protected String matricula;

	public Jefe(
		String dni,
		String nombre,
		String direccion,
		long telefono,
		int edad,
		float sueldo,
		String matricula
	) {
		super(dni, nombre, direccion, telefono, edad, sueldo);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "Matricula: " + matricula + "\n";
	}
}
