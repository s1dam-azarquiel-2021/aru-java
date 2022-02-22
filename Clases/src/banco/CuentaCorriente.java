package banco;

public class CuentaCorriente {
	private long numeroCuenta;
	private String titular;
	private double saldo;

	public void ingresar(double cantidad) {
		saldo += cantidad;
	}

	public void sacar(double cantidad) {
		if (cantidad <= saldo) {
			saldo -= cantidad;
		} else {
			System.out.printf("No tienes suficiente dinero.\n");
		}
	}

	public void asignarTitulo(String nombre) {
		titular = nombre;
	}

	public void asignarNumeroCuenta(long numero) {
		numeroCuenta = numero;
	}

	public double dimeElSaldo() {
		return saldo;
	}

	public String dimeELTitular() {
		return titular;
	}

	public long dimeElNumeroCuenta() {
		return numeroCuenta;
	}

	public void mostrarDatosCuenta() {
		System.out.printf(
			"Numero de cuenta: %d\nTitular: %s\nSaldo: %.2f$\n", numeroCuenta,
			titular, saldo
		);
	}
}
