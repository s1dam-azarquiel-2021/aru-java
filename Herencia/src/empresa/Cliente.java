package empresa;

public class Cliente extends Persona {
	protected String numeroCuenta;

	public Cliente(
		String dni,
		String nombre,
		String direccion,
		long telefono,
		int edad,
		String numeroCuenta
	) {
		super(dni, nombre, direccion, telefono, edad);
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	@Override
	public String toString() {
		return super.toString() + "Numero de cuenta: " + numeroCuenta + "\n";
	}
}
