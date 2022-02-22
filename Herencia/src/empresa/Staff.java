package empresa;

public class Staff extends Persona {
	protected float sueldo;

	public Staff(
		String dni,
		String nombre,
		String direccion,
		long telefono,
		int edad,
		float sueldo
	) {
		super(dni, nombre, direccion, telefono, edad);
		this.sueldo = sueldo;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return super.toString() + "Sueldo: " + sueldo + "\n";
	}
}
