package empresa;

public class Empleado extends Staff {
	public Empleado(
		String dni,
		String nombre,
		String direccion,
		long telefono,
		int edad,
		float sueldo
	) {
		super(dni, nombre, direccion, telefono, edad, sueldo);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
